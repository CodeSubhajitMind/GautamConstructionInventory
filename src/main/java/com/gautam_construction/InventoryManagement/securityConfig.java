package com.gautam_construction.InventoryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.gautam_construction.InventoryManagement.services.CustomLogOutHandler;
import com.gautam_construction.InventoryManagement.services.InventoryAuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{																									
	
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	
	@Autowired
	private InventoryAuthenticationSuccessHandler successHandler;
	
	@Autowired
    private CustomLogOutHandler logoutHandler;
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	public securityConfig() {

	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
	                                                                                                                                                                                                                                                                        
		http
        .authorizeRequests() 
            .antMatchers("/login","/resources/**","/css/**","/js/**","/images/**","/img/**","/upload/**")
            .permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().accessDeniedPage("/unauthorized")
            .and()
        .formLogin()
            .loginPage("/login")
            .successHandler(successHandler)
            .permitAll()
            .and()
        .logout()
        		.addLogoutHandler(logoutHandler)
        		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        		.logoutSuccessUrl("/")
        		.permitAll();
		
		//http.csrf().ignoringAntMatchers("/");
				
	}
	
	 @Bean
	    public AuthenticationManager customAuthenticationManager() throws Exception {
	        return authenticationManager();
	    }
	    

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO Auto-generated method stub
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		}

}
