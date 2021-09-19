package com.ltts.productionWeb.model;

public class Member {
	
	private String name;
	private String email;
	private String mobile;
	private String location;
	private String password;
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Member(String name, String email, String mobile, String location, String password, String code) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.location = location;
		this.password = password;
		this.code = code;
	}
	public Member() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + ", mobile=" + mobile + ", location=" + location
				+ ", password=" + password + "]";
	};
	

}
