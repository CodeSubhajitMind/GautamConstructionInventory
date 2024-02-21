package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class staff {
	@Id
    private String emp_code;
	private String name;
	private String designation;
	
	public staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public staff(String emp_code, String name, String designation) {
		super();
		this.emp_code = emp_code;
		this.name = name;
		this.designation = designation;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public int hashCode() {
		return Objects.hash(designation, emp_code, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		staff other = (staff) obj;
		return Objects.equals(designation, other.designation) && Objects.equals(emp_code, other.emp_code)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "staff [emp_code=" + emp_code + ", name=" + name + ", designation=" + designation + "]";
	}
	
	
}
