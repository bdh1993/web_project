package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.SignupMapper;
import com.example.demo.model.SignupVo;

@Service("com.example.demo.service.SignupService")
public class SignupService {
	
	@Autowired
	SignupMapper mSignupMapper;
	
	/**
	 * 회원가입 서비스
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public String signInsertService(SignupVo vo) throws Exception {
		String msg = "";
		int cnt;
		System.out.println("service ====> " + "컨트롤러에서 값을 가지고 옴");
		System.out.println("service ====> " + vo.getUser_id());
		System.out.println("service ====> " + vo.getUser_password());
		System.out.println("service ====> " + vo.getUser_repassword());
		System.out.println("service ====> " + vo.getUser_name());
		
		cnt = mSignupMapper.selectId(vo.getUser_id());
		//DB의 중복여부, 암호화된 비밀번호 등을 설정 msg로 성공여부 반환
		if (0 < cnt) {
			msg = "중복된 아이디 입니다.";
		} else {
			mSignupMapper.signInsert(vo);
			msg = "회원가입이 완료됬습니다.";
		}
		
		
		return msg;
	}
	
	/**
	 * 아이디 중복 확인
	 * @param kind
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public String CheckId(String kind, String value) throws Exception {
		
		System.out.println("syso ====> " + kind);
		System.out.println("syso ====> " + value);
		
		String msg ="";
		int cnt;
		//아이디 확인
		if(kind.equals("id")) {
			cnt = mSignupMapper.selectId(value);
			
			if(0 < cnt) {
				msg = "등록된 아이디 입니다.";
			} else {
				msg = "등록 가능한 아이디 입니다.";
			}
		} else
		{
			msg = "잘못된 접근입니다.";
		}
		
		
		
		return msg;
	}
}
