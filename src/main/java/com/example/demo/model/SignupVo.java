package com.example.demo.model;


public class SignupVo {
	
	private String user_id;
	private String user_password;
	private String user_repassword;
	private String user_name;
	
	//vo에 msg값을 받아서 넘겨줄 때 사
	private String InfoMsg;
	
	public SignupVo(String user_id, String user_password, String user_repassword, String user_name) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_repassword = user_repassword;
		this.user_name = user_name;
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
	public String getUser_repassword() {
		return user_repassword;
	}
	public void setUser_repassword(String user_repassword) {
		this.user_repassword = user_repassword;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	
	

	public String getInfoMsg() {
		return InfoMsg;
	}

	public void setInfoMsg(String infoMsg) {
		InfoMsg = infoMsg;
	}
	
	
	
	
	
	
}
