package com.PRJ321xA4.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.PRJ321xA4.model.Account;

public class AccountMapper implements RowMapper<Account>{
	public Account mapRow(ResultSet rs, int rownum)throws SQLException{
		Account acc = new Account(rs.getString("user_mail"),rs.getString("user_name"));
		return acc;
	}
}
