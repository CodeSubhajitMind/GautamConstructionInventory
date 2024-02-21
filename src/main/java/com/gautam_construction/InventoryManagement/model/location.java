package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "location")
public class location {
	@Id
    private Integer id;
	private String location_name;
	public location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public location(Integer id, String location_name) {
		super();
		this.id = id;
		this.location_name = location_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, location_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		location other = (location) obj;
		return Objects.equals(id, other.id) && Objects.equals(location_name, other.location_name);
	}
	@Override
	public String toString() {
		return "location [id=" + id + ", location_name=" + location_name + "]";
	}
	
	
}
