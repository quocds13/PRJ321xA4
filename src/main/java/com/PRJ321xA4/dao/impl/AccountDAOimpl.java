package com.PRJ321xA4.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.PRJ321xA4.dao.AccountDAO;
import com.PRJ321xA4.mapping.AccountMapper;
import com.PRJ321xA4.model.Account;

@Repository
public class AccountDAOimpl implements AccountDAO{
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	private DataSource ds;

	private Connection connect;
	private CallableStatement cstmt = null;

	public ArrayList<Account> getAccounts() {
		String SQL = "select * from Account";
		ArrayList<Account> accounts = (ArrayList<Account>) jdbcTemplateObject.query(SQL, new AccountMapper());
		return accounts;
	}

	public boolean loginAccount(String umail, String upass) throws SQLException {
		connect = ds.getConnection();
		cstmt = connect.prepareCall("{call getAccount (?, ?, ?)}");
		cstmt.setString(1, umail);
		cstmt.setString(2, upass);
		cstmt.registerOutParameter(3, java.sql.Types.INTEGER);
		cstmt.execute();
		return cstmt.getInt("count") > 0;
	}
}
