package com.PRJ321xA4.Utilities;

import org.springframework.stereotype.Repository;

@Repository
public class AccountValidation {	
	private String msg1, msg2;

	public String getMsg1() {
		return msg1;
	}
	public String getMsg2() {
		return msg2;
	}
	public boolean isvalidation(String umail, String upass) {
		boolean result = true;

		if (!umail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			this.msg1 = "Tài khoản mail không đúng định dạng";
			result = false;
		}
		if (upass.length() < 8) {
			this.msg2 = "Password không đủ 8 ký tự";
			result = false;
		}
		return result;
	}
}
