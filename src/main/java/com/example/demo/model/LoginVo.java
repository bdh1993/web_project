package com.example.demo.model;

public class LoginVo {
	
	private String user_id;
	private String user_password;
	private String user_name;
	
	//Controller에서 Service로 넘겨주기 위한 생성자
	
	public LoginVo(String user_id, String user_password) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
	}
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
	
}
