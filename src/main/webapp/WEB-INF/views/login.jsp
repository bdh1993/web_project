<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginPage</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var kind = "";
		//아이디
		$('[name=user_id]').keydown(function(key) { 
			if(key.keyCode == 13) {
				$('#user_password').focus();
			}
		});
		//비밀번호
		$('[name=user_password]').keydown(function(key) {
			if(key.keyCode == 13) {
				$('#loginBtn').trigger("click");
			}
		});
		//회원가입 버튼
		$('#signupBtn').click(function() {
			location.href='/signup';
		});
		//로그인 버튼
		$('#loginBtn').click(function() {
			loginChk();
		});
	});

	function loginChk() {
		var user_id = $('[name=user_id]').val();
		var user_password = $('[name=user_password]').val();
		
		//아이디 입력유무 확인.
		if(user_id == undefined || user_id == null || user_id == "" || user_id.length < 1) {
			$('[name=user_id]').focus();
			$('#textInfo').text("아이디가 입력되지 않았습니다.");
			return;
		}
		//비밀번호 입력유무 확인.
		if(user_password == undefined || user_password == null || user_password == "" || user_password.length < 1) {
			$('[name=user_password]').focus();
			$('#textInfo').text("비밀번호가 입력되지 않았습니다.");
			return;
		}
		
		$.ajax({
			url: '/loginchk',
			type: 'POST',
			data:{
				user_id : user_id,
				user_password : user_password
			},
			success: function(result) {
				if("로그인에 성공했습니다." == result) {
					console.log("login");
					location.href='/success';
				} else {
					$('#textInfo').text(result);
				}
			}
		})
	}
</script>
</head>
<body>

<!-- 
 - 로그인 화면 페이지 사용자에게 보여지는 뷰 화면이다.
 - 로그인 버튼을 누르면 form의 action, 여기서는 loginchk로 요청한다.
 - 보내는 방식은 post방식이다.
 -->
<form method="post" id="loginForm">
	<ul>
		<li><input type="text" id = "user_id" name="user_id" placeholder="아이디"/></li>
		<li><input type="password" id = "user_password" name="user_password" placeholder="비밀번호"/></li>
		<li><button type="button" id="loginBtn">로그인</button></li>
	</ul>
	<h5 id="textInfo"></h5>
</form>
<ul>
	<li><button type="button" id="signupBtn">회원가입</button></li>
</ul>
</body>
</html>