package com.gautam_construction.InventoryManagement.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.gautam_construction.InventoryManagement.model.users;
import com.gautam_construction.InventoryManagement.repository.userRepository;


@Component
public class InventoryAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	@Autowired
	private userRepository userRepository;
	
	@Autowired
	private Environment env;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		boolean hasAdminRole = false;
		boolean hasSubAdminRole = false;
		String office_name = "";
		
		List<String> rolesArray = new ArrayList<String>();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		System.out.println("role array is: "+authorities.size());
		for (GrantedAuthority grantedAuthority : authorities) {
			rolesArray.add(grantedAuthority.getAuthority().toString());
			System.out.println("role is: "+grantedAuthority.getAuthority());
			 
			if(grantedAuthority.getAuthority().equals("ROLE_A")) {
				hasAdminRole = true;
				office_name = "Admin";
				break;
			}
			else if(grantedAuthority.getAuthority().equals("ROLE_SA")) {
				hasSubAdminRole = true;
				office_name = "Sub-Admin";
				break;
			}
			                                                                                                                                                                                                             
		}
		
		request.getSession().setAttribute("isAdminUser", hasAdminRole);
		request.getSession().setAttribute("isSubAdminUser", hasSubAdminRole);
		
		System.out.println("username is: "+authentication.getName());
		users loggedUser = userRepository.gettingUserId(Integer.parseInt(authentication.getName()));
		System.out.println("user login credentials :"+loggedUser.getUser_id());
		
		
		/*String applicationUrl = env.getRequiredProperty("application.url");
		String applicationEnv = env.getRequiredProperty("application.environment");
		String fileStorageLoc = env.getRequiredProperty("file.storage.location");
		String applAccessAlias = env.getRequiredProperty("application.access.alias");
		request.getSession().setAttribute("applUrl", applicationUrl);
		request.getSession().setAttribute("applEnv", applicationEnv);
		request.getSession().setAttribute("sangrahakFileStorage", fileStorageLoc);
		request.getSession().setAttribute("urlAlias", applAccessAlias);*/

		// setting the session timeout value
		request.getSession().setAttribute("userRoles", rolesArray);				
		request.getSession().setMaxInactiveInterval(15 * 60); // value in seconds
		//request.getSession().setAttribute("userInfo", loggedUser);
		request.getSession().setAttribute("userId", loggedUser.getUser_id());
		
		if(hasAdminRole) {
			request.getSession().setAttribute("userType", "A");
			request.getSession().setAttribute("officeName", office_name);
			redirectStrategy.sendRedirect(request, response, "/AdminHome");
		}
		else if(hasSubAdminRole) {
			request.getSession().setAttribute("userType", "SA");
			request.getSession().setAttribute("officeName", office_name);
			redirectStrategy.sendRedirect(request, response, "/SubAdminHome");
		}
		 		
	}

}
