package com.gautam_construction.InventoryManagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gautam_construction.InventoryManagement.repository.userRepository;
import com.gautam_construction.InventoryManagement.services.loginServices;



@Controller
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	private userRepository ur;
	@Autowired
	private loginServices ls;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/login")
	public String loginText(Model model, String error) {
		
		
		if(error!=null) {
		    model.addAttribute("loginError", "Invalid Username or Password");
		    logger.error("Invalid Username or Password");
		}

		Date currentDate=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        model.addAttribute("currentDate",formatter.format(currentDate));
		return "login";
	}


	@GetMapping("/login-error")
	  public String LoginError(Model model,String loginError ) {
		
		System.out.println("loginError : "+loginError);
		if(loginError!=null) {
	    model.addAttribute("loginError", "Invalid Username or Password");
	    logger.error("Invalid Username or Password");
		}

		Date currentDate=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        model.addAttribute("currentDate",formatter.format(currentDate));
		return "login";
	}
	
	@GetMapping("/login-ActiveError")
	  public String LoginActiveError(Model model,String loginError) {
	    
		model.addAttribute("loginError", "User Is Inactive");
	    logger.error("User is Inactive");
		
		Date currentDate=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        model.addAttribute("currentDate",formatter.format(currentDate));
		return "login";
	}


	@GetMapping("/login-LoggedError")
	  public String LoginLoggedError(Model model,String loginError) {
		
	    model.addAttribute("loginError", "User Is Already Logged In a Different PC");
	    model.addAttribute("displayTerminationLink", "true");
	    logger.error("User is Inactive");
		
		Date currentDate=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        model.addAttribute("currentDate",formatter.format(currentDate));
		return "login";
	}
	

	@GetMapping("/login-ValidError")
	  public String CbdfLoginValidError(Model model,String loginError) {
		
	    model.addAttribute("loginError", "The Validity of the CBDF Account Has Expired");
	    logger.error("User is Inactive");
		
		Date currentDate=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		model.addAttribute("currentDate",formatter.format(currentDate));
		return "login";
	}

	
	
	@GetMapping({ "/", "/index" })
	public String login(Model model) {
		Date currentDate=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        model.addAttribute("currentDate",formatter.format(currentDate));
		return "login";
	}
	



	@GetMapping({ "/unauthorized" })
	public String accessDenied(Model model,HttpSession session) {
		
		@SuppressWarnings("unchecked")
		List<String> rolesArray	= (List<String>) session.getAttribute("userRoles");	
		for(int i=0;i<rolesArray.size();i++) {
			if(rolesArray.get(i).equalsIgnoreCase("ROLE_ADMIN")) {
				model.addAttribute("adminRole", rolesArray.get(i));
			}
		}
		
		
		return "unauthorized";
	}
 
	
}