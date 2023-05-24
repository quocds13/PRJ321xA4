package com.PRJ321xA4.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.PRJ321xA4.dao.impl.AccountDAOimpl;
import com.PRJ321xA4.model.Account;

@Controller
public class HomeController {

	@RequestMapping("/trang-chu")
	public String homePage(ModelMap map, HttpServletRequest request) throws UnsupportedEncodingException {
		String s = request.getParameter("msg");
		if(s != null) {
			map.addAttribute("msg", s);
		}	
		else {
			map.addAttribute("msg2", "Bạn phải đăng nhập trước");
			return "login";
		}	
		return "home";
	}
}
