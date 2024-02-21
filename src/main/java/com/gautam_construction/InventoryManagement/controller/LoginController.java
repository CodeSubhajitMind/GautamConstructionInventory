package com.gautam_construction.InventoryManagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.gautam_construction.InventoryManagement.repository.userRepository;
import com.gautam_construction.InventoryManagement.repository.user_roles_repository;
import com.gautam_construction.InventoryManagement.services.loginServices;


@Controller
public class LoginController {
	@Autowired
	private userRepository ur;
	@Autowired
	private loginServices ls;
	@Autowired
	private user_roles_repository urr;
	
	@PostMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		request.getSession().removeAttribute("Logged_In_Credentials");
		return "redirect:/";
	}
}
