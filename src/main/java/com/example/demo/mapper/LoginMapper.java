package com.example.demo.mapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.LoginVo;

@Repository("com.example.demo.mapper.LoginMapper")
@Transactional
public interface LoginMapper {
	
	public LoginVo loginChk(LoginVo vo);
}
