package com.PRJ321xA4.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.PRJ321xA4.Utilities.AccountValidation;
import com.PRJ321xA4.dao.AccountDAO;

@Controller
public class LoginController {
	@Autowired
	private AccountValidation validation;

	@Autowired
	private AccountDAO accountDao;

	private Map<String, String> paraMap = new HashMap<>();;

	@RequestMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAction(HttpServletRequest request, HttpServletResponse response, ModelMap map)
			throws SQLException {
		if (request.getParameter("action").equals("login")) {
			String umail = request.getParameter("username");
			String upass = request.getParameter("pass");
			if (validation.isvalidation(umail, upass)) {
				if (accountDao.loginAccount(umail, upass)) {
					map.addAttribute("msg", umail);
					return "home";
				} else {
					paraMap.put("msg2", "Tài khoản hoặc mật khẩu không đúng");
				}
			} else {
				paraMap.put("msg1", validation.getMsg1());
				paraMap.put("msg2", validation.getMsg2());
			}
			if (paraMap.size() > 0) {
				map.addAllAttributes(paraMap);
			}
		}
		return "login";
	}
}
