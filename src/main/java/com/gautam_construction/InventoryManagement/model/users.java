package com.gautam_construction.InventoryManagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "users")
public class users {
	@Id
    private Integer user_id;
	@NonNull
	private String password;
	@NonNull
	private String name;
	@NonNull
	private String user_type;
	@NonNull
	private String datetime;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private Set<user_roles> user_roles = new HashSet<user_roles>();
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public Set<user_roles> getUser_roles() {
		return user_roles;
	}
	public void setUser_roles(Set<user_roles> user_roles) {
		this.user_roles = user_roles;
	}
	public users(Integer user_id, String password, String name, String user_type, String datetime, Set<user_roles> user_roles) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.user_type = user_type;
		this.datetime = datetime;
	}
	public users() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "users [user_id=" + user_id + ", password=" + password + ", name=" + name + ", user_type=" + user_type
				+ ", datetime=" + datetime + ", user_roles=" + user_roles + "]";
	}
	
	
}
