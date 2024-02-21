package com.gautam_construction.InventoryManagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "user_role_master")
public class user_role_master {
	@Id
    private Integer role_id;
	@NonNull
	private String role_name;
	
	@OneToMany(mappedBy = "user_role_master")
	private Set<user_roles> user_roles = new HashSet<user_roles>();
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public Set<user_roles> getUser_roles() {
		return user_roles;
	}
	public void setUser_roles(Set<user_roles> user_roles) {
		this.user_roles = user_roles;
	}
	
	

}
