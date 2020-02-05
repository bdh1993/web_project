package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.SignupVo;
import com.example.demo.service.SignupService;

@Controller
public class SignupController {
	
	@Autowired
	SignupService mSignupService;
	
	// 회원가입 화면
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupPage() throws Exception{
		System.out.println("controller ====> " + "회원가입 페이지");
		return "/signup";
	}
	
	// 회원가입 체크
	/**
	 * 
	 * @param session
	 * @param user_id
	 * @param user_password
	 * @param user_repassword
	 * @param user_name
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/signupchk", method=RequestMethod.POST)
	public String signChk(@ModelAttribute("user_id") String user_id, @ModelAttribute("user_password") String user_password,
			@ModelAttribute("user_repassword") String user_repassword, @ModelAttribute("user_name") String user_name) throws Exception {
		String msg = "";

		System.out.println("controller ====> " + user_id);
		System.out.println("controller ====> " + user_password);
		System.out.println("controller ====> " + user_repassword);
		System.out.println("controller ====> " + user_name);
		
		msg = mSignupService.signInsertService(new SignupVo(user_id, user_password, user_repassword, user_name));

		System.out.println("controller ====>" + msg);

		return msg;
	}
	
	//아이디 중복 확인
	/**
	 * 
	 * @param session
	 * @param kind
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/chkid", method=RequestMethod.POST)
	public String checkId(@ModelAttribute("kind") String kind, @ModelAttribute("value") String value) throws Exception {
		
		String msg = "";
		
		if(null == kind || "".equals(kind) || null == value || "".equals(value)) {
			msg = "아이디가 입력되지 않았습니다.--";
		} else {
			msg = mSignupService.CheckId(kind,value);
		}
		return msg;
	}
}
