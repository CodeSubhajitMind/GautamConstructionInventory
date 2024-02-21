package com.gautam_construction.InventoryManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class user_roles {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
	private user user;
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false, referencedColumnName = "role_id")
	private user_role_master user_role_master;
	
	
	public user_roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public user_roles(Integer id, user user,user_role_master user_role_master) {
		super();
		this.id = id;
		this.user = user;
		this.user_role_master = user_role_master;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public user_role_master getUser_role_master() {
		return user_role_master;
	}
	public void setUser_role_master(user_role_master user_role_master) {
		this.user_role_master = user_role_master;
	}

	@Override
	public String toString() {
		return "user_roles [id=" + id + ", user=" + user + ", user_role_master=" + user_role_master + "]";
	}
	
	
	
}