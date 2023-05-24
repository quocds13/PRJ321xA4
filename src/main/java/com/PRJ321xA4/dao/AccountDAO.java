package com.PRJ321xA4.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.PRJ321xA4.model.Account;


public interface AccountDAO {
	public ArrayList<Account> getAccounts();
	public boolean loginAccount(String s1, String s2) throws SQLException;
}
