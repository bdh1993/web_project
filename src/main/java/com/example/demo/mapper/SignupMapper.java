package com.example.demo.mapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.SignupVo;

@Repository("com.example.demo.mapper.SignupMapper")
@Transactional
public interface SignupMapper {
	
	public int signInsert (SignupVo vo);
	public int selectId (String value);
}
