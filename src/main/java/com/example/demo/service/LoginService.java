package com.example.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.LoginMapper;
import com.example.demo.model.LoginVo;

@Service("com.example.service.LoginService")
public class LoginService {
	
	@Autowired
	private LoginMapper loginmapper;
	
	/**
	 * 
	 * @param session
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public String loginChk(HttpSession session, LoginVo vo) throws Exception {
		//로그인 성공 실패 값 넘길때 사용
		String msg = "";
		System.out.println("syso ====> "+"서비스");
		System.out.println("syso ====> "+vo.getUser_id());
		System.out.println("syso ====> "+vo.getUser_password());
		
		vo = loginmapper.loginChk(vo);
		
		if (vo == null){
			msg = "실패";
		}
		else {
			session.setAttribute("login", vo);
			msg = "성공";
		}
		
		return msg;
	}
}
