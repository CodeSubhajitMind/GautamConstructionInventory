package com.gautam_construction.InventoryManagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gautam_construction.InventoryManagement.model.users;
import com.gautam_construction.InventoryManagement.repository.userRepository;
import com.gautam_construction.InventoryManagement.repository.user_roles_repository;

@Service
public class InventoryUserDetailsService implements UserDetailsService{
	@Autowired
	private userRepository userRepo;
	@Autowired
	private user_roles_repository userRoleRepo;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
				users user = userRepo.getUserCredentiaLs(Integer.parseInt(userName)).get(0);
				if (user == null)
					throw new UsernameNotFoundException(userName);
				List<String> userRoles = userRoleRepo.getUserRoles(userName);
				System.out.println("user roles are: "+userRoles.size());
				return new org.springframework.security.core.userdetails.User(user.getUser_id().toString(), user.getPassword(),
						grantedAuthorities(userRoles));
			}
			
			private static List<? extends GrantedAuthority> grantedAuthorities(List<String> userRoles) {
				  
				  List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
				  for (String role : userRoles) {
						grantedAuthorities.add(new SimpleGrantedAuthority(role));
					}
				  
				  return grantedAuthorities; 
				  }
	
}
