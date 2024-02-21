package com.gautam_construction.InventoryManagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gautam_construction.InventoryManagement.model.user;
import com.gautam_construction.InventoryManagement.repository.userRepository;

@Controller
public class SubAdminController {
	@Autowired
	private userRepository ur;
	@RequestMapping("/SubAdminHome")
	public Object SubAdminHome(HttpSession session,Model model,Authentication authentication) {
		@SuppressWarnings("unchecked")
		String user_id = session.getAttribute("userId").toString();
		String user_type = session.getAttribute("userType").toString();
		String office_name = session.getAttribute("officeName").toString();
		model.addAttribute("office_name", office_name);
		Date currentDate=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        model.addAttribute("currentDate",formatter.format(currentDate));
		model.addAttribute("office_name", office_name);
        List<user> user_info = ur.getUserCredentiaLs(Integer.parseInt(user_id));
        return "sub_admin_home";
	}
}
