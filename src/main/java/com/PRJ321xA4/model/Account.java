package com.PRJ321xA4.model;

public class Account {
	private String usermail = "", password = "", name = "", address = "", phone = "", valadiation = " ";
	private int role, check;

	public Account() {
	}

	public Account(String usermail, String password) {
		this.usermail = usermail;
		this.password = password;
	}

	public Account(String usermail, String password, String name, String address, String phone, int role) {
		this.usermail = usermail;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.role = role;
		this.check = 1;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public String getValadiation() {
		return valadiation;
	}

}
