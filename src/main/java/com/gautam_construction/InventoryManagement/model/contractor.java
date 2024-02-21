package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "contractor")
public class contractor {
	@Id
    private Integer contractor_id;
	private String name;
	private String dept;
	private String address;
	public contractor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public contractor(Integer contractor_id, String name, String dept, String address) {
		super();
		this.contractor_id = contractor_id;
		this.name = name;
		this.dept = dept;
		this.address = address;
	}
	public Integer getContractor_id() {
		return contractor_id;
	}
	public void setContractor_id(Integer contractor_id) {
		this.contractor_id = contractor_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, contractor_id, dept, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		contractor other = (contractor) obj;
		return Objects.equals(address, other.address) && Objects.equals(contractor_id, other.contractor_id)
				&& Objects.equals(dept, other.dept) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "contractor [contractor_id=" + contractor_id + ", name=" + name + ", dept=" + dept + ", address="
				+ address + "]";
	}
	
	
}
