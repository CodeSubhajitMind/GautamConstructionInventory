package com.gautam_construction.InventoryManagement.DTO;

import java.util.Objects;

public class product_exit_by_staff_dto {
	private Integer prod_id;
	private String prod_name;
	private String quantity;
	private String challan_no;
	private String exit_date;
	private String staff_emp_code;
	private String receiving_person;
	public product_exit_by_staff_dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product_exit_by_staff_dto(Integer prod_id, String prod_name, String quantity, String challan_no,
			String exit_date, String staff_emp_code, String receiving_person) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.quantity = quantity;
		this.challan_no = challan_no;
		this.exit_date = exit_date;
		this.staff_emp_code = staff_emp_code;
		this.receiving_person = receiving_person;
	}
	public Integer getProd_id() {
		return prod_id;
	}
	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getChallan_no() {
		return challan_no;
	}
	public void setChallan_no(String challan_no) {
		this.challan_no = challan_no;
	}
	public String getExit_date() {
		return exit_date;
	}
	public void setExit_date(String exit_date) {
		this.exit_date = exit_date;
	}
	public String getStaff_emp_code() {
		return staff_emp_code;
	}
	public void setStaff_emp_code(String staff_emp_code) {
		this.staff_emp_code = staff_emp_code;
	}
	public String getReceiving_person() {
		return receiving_person;
	}
	public void setReceiving_person(String receiving_person) {
		this.receiving_person = receiving_person;
	}
	@Override
	public int hashCode() {
		return Objects.hash(challan_no, exit_date, prod_id, prod_name, quantity, receiving_person, staff_emp_code);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product_exit_by_staff_dto other = (product_exit_by_staff_dto) obj;
		return Objects.equals(challan_no, other.challan_no) && Objects.equals(exit_date, other.exit_date)
				&& Objects.equals(prod_id, other.prod_id) && Objects.equals(prod_name, other.prod_name)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(receiving_person, other.receiving_person)
				&& Objects.equals(staff_emp_code, other.staff_emp_code);
	}
	@Override
	public String toString() {
		return "product_exit_by_staff_dto [prod_id=" + prod_id + ", prod_name=" + prod_name + ", quantity=" + quantity
				+ ", challan_no=" + challan_no + ", exit_date=" + exit_date + ", staff_emp_code=" + staff_emp_code
				+ ", receiving_person=" + receiving_person + "]";
	}
	
	
}
