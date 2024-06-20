package com.gautam_construction.InventoryManagement.DTO;

import java.util.Objects;

public class userLoginDetailsDTO {
	private String name;
	private String user_id;
	private String password;
	public userLoginDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public userLoginDetailsDTO(String name, String user_id, String password) {
		super();
		this.name = name;
		this.user_id = user_id;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, password, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		userLoginDetailsDTO other = (userLoginDetailsDTO) obj;
		return Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(user_id, other.user_id);
	}
	@Override
	public String toString() {
		return "userLoginDetailsDTO [name=" + name + ", user_id=" + user_id + ", password=" + password + "]";
	}
	
	
}
