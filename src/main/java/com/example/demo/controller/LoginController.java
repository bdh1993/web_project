package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.LoginVo;
import com.example.demo.service.LoginService;

//해당 클래스가 컨트롤러임을 나타내기 위한 어노테이션
@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	/**
	 * 로그인 페이지
	 * 메인 페이지
	 * @return login
	 */
	@RequestMapping("/")
	public String loginPage(HttpSession session) throws Exception {
		System.out.println("syso ====> " + "로그인 페이지");
		return "login";
	}

	
	/**
	 * 로그인 처리 (사용자 입력 값을 서비스쪽으로 보내주기 위한 준비)
	 * login.jsp의 form의 요청을 받음 post방식으로 받는다.
	 * 세션으로 loginService에 넘겨줘서 service안에서 로그인 처리를 한다.
	 * @param session
	 * @param user_id
	 * @param user_password
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/loginchk", method=RequestMethod.POST)
	public String loginChk(HttpSession session, @ModelAttribute("user_id") String user_id, @ModelAttribute("user_password") String user_password) throws Exception {
		System.out.println("Controller ====> "+"로그인 컨트롤러");
		System.out.println("Controller ====> "+"id : " + user_id);
		System.out.println("Controller ====> "+"pw : " + user_password);
		
		String msg ="";
		
		//서비스로 넘겨줌
		if (null == user_id || "".equals(user_id) || null == user_password || "".equals(user_password)) {
			msg = "값이 입력되지 않았습니다.";
		} else {
			msg = loginService.loginChk(session, new LoginVo(user_id, user_password));
		}
		
		System.out.println(msg);
		
		String id = user_id;
				
		if (msg == "성공") {
			msg = "로그인에 성공했습니다.";
		} else {
			msg = "로그인에 실패했습니다.";
		}
		
		return msg;
	}
}