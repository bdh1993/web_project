package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginSuccessController {
	
	@RequestMapping("/success")
	public String LoginSuccess() {
		return "/loginSuccess";
	}
}
