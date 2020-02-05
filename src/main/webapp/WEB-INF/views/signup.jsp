<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>signUp</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

var msg = {
		SIGNUP_SUCCESS : "회원가입이 완료됬습니다.",
		NULL_ID : "아이디가 입력되지 않았습니다.",
		NULL_PASSWORD : "비밀번호가 입력되지 않았습니다.",
		NULL_REPASSWORD : "비밀번호 확인이 입력되지 않았습니다.",
		NULL_NAME : "이름이 입력되지 않았습니다.",
		NOT_MATCH_PASSWORD : "비밀번호가 일치하지 않습니다."	,
		SIGNUP_FAIL : "회원가입에 실패했습니다."
}

$(document).ready(function() {
	//아이디
	$('#user_id').blur(function() {
		console.log("user_id");
		checkInput('id');
	})
	//비밀번호
	$('#user_password').blur(function() {
			console.log("user_password");
			checkInput('password');
	})
	//비밀번호 확인
	$('#user_repassword').blur(function() {
			console.log("user_repassword");
			checkInput('repassword');
	})
	//이름
	$('#user_name').blur(function() {
			console.log("name");
			checkInput('name');
	})
	
	//등록
	$('#signupBtn').click(function() {
		signupChk();
	})
	
	//취소
	$('#cancelBtn').click(function() {
		location.href='/';
	})
})



var id_OK = 0;

function checkInput(kind) {
	var value;
	if(kind == 'id') {
		console.log("checkInput의 id");
		value = $('[name=user_id]').val();
		console.log(value);
	}
	if(kind == 'password') {
		console.log("checkInput의 pw");
		value = $('[name=user_password]').val();
		console.log(value);
	}
	if(kind == 'repassword') {
		console.log("checkInput의 repw");
		value = $('[name=user_repassword]').val();
		console.log(value);
	}
	if(kind == 'name') {
		console.log("checkInput의 name");
		value = $('[name=user_name]').val();
		console.log(value);
	}
	
	//입력유무 확인
	if(value == undefined || value == null || value == "" || value.length < 1) {
		if(kind == 'id') {
			$('#textInfo').text(msg.NULL_ID);
		}
		if(kind == 'password') {
			$('#textInfo').text(msg.NULL_PASSWORD);
		}
		if(kind == 'repassword') {
			$('#textInfo').text(msg.NULL_REPASSWORD);
		}
		if(kind == 'name') {
			$('#textInfo').text(msg.NULL_NAME);
		}
	}
	else {
		$('#textInfo').text("");
	}
	
	//아이디 유효성 검사
	if(kind == 'id') {
		$.ajax({
			url: '/chkid',
			type: 'post',
			data: {kind:kind, value:value},
			success: function(result) {
				if(kind == 'id' && result == "등록 가능한 아이디 입니다.") {
					id_OK = 1;
					console.log("id_OK : "+id_OK);
				} else {//(kind == 'id' && result == "등록된 아이디 입니다.") {
					id_OK = 0;
					console.log("id_OK : "+id_OK);
				}
				console.log(result);
				$('#textInfo').text(result+"++");
			}
		})
	}
		
} 


//등록 확인
function signupChk() {
	
	var formData = $('#signupForm').serialize();
	
	//아이디가 등록됬는지 확인
	if(id_OK == 0) {
		return false;
	}
	
	//비밀번호의 값이 비어있는지 확인
	if($('[name=user_password]').val() == "") {
		$('#textInfo').text(msg.NULL_PASSWORD);
		return false;
	}
	//비밀번호와 비밀번호 확인값이 일치하는지 확인
	if($('[name=user_password]').val() != $('[name=user_repassword]').val()) {
		$('#textInfo').text(msg.NOT_MATCH_PASSWORD);
		return false;
	}
	//이름의 값이 비어있는지 확인
	if($('#user_name').val() == "") {
		$('#textInfo').text(msg.NULL_NAME);
		return false;
	}
	else {
		$.ajax({
			url: '/signupchk',
			type: 'post',
			data: formData,
			success: function(result) {
				if(msg.SIGNUP_SUCCESS == result) {
				alert(msg.SIGNUP_SUCCESS);
				location.href="/";
				} else {
					alert(msg.SIGNUP_FAIL);
					return false;
				}
			}
		})
	}
}

</script>
</head>
<body>
<h2>회원가입</h2>

<form method="post" id="signupForm">
	<ul>
		<li><input type="text" id="user_id" name="user_id" placeholder="아이디"/></li>
		<li><input type="password" id="user_password" name="user_password" placeholder="비밀번호"/></li>
		<li><input type="password" id="user_repassword" name="user_repassword" placeholder="비밀번호 확인"/></li>
		<li><input type="text" id="user_name" name="user_name" placeholder="이름"/></li>	
	</ul>
</form>
<p id=textInfo></p>
<ul>
	<li><button type="button" id="cancelBtn">취소</button></li>
	<li><button type="button" id="signupBtn">등록</button></li>	
</ul>
</body>
</html>