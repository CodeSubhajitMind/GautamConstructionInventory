package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_exit_by_staff")
public class product_exit_by_staff {
	@Id
	private Integer id;
	private Integer prod_id;
	private String quantity;
	private String challan_no;
	private String exit_date;
	private String staff_emp_code;
	private String receiving_person;
	private String bill;
	private String sub_admin;
	public product_exit_by_staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product_exit_by_staff(Integer id, Integer prod_id, String quantity, String challan_no, String exit_date, String staff_emp_code,
			String receiving_person, String bill,String sub_admin) {
		super();
		this.id = id;
		this.prod_id = prod_id;
		this.quantity = quantity;
		this.challan_no = challan_no;
		this.exit_date = exit_date;
		this.staff_emp_code = staff_emp_code;
		this.receiving_person = receiving_person;
		this.bill = bill;
		this.sub_admin = sub_admin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProd_id() {
		return prod_id;
	}
	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
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
	public String getBill() {
		return bill;
	}
	public void setBill(String bill) {
		this.bill = bill;
	}
	
	public String getSub_admin() {
		return sub_admin;
	}
	public void setSub_admin(String sub_admin) {
		this.sub_admin = sub_admin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bill, challan_no, exit_date, id, prod_id, quantity, receiving_person, staff_emp_code,
				sub_admin);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product_exit_by_staff other = (product_exit_by_staff) obj;
		return Objects.equals(bill, other.bill) && Objects.equals(challan_no, other.challan_no)
				&& Objects.equals(exit_date, other.exit_date) && Objects.equals(id, other.id)
				&& Objects.equals(prod_id, other.prod_id) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(receiving_person, other.receiving_person)
				&& Objects.equals(staff_emp_code, other.staff_emp_code) && Objects.equals(sub_admin, other.sub_admin);
	}
	@Override
	public String toString() {
		return "product_exit_by_staff [id=" + id + ", prod_id=" + prod_id + ", quantity=" + quantity + ", challan_no="
				+ challan_no + ", exit_date=" + exit_date + ", staff_emp_code=" + staff_emp_code + ", receiving_person="
				+ receiving_person + ", bill=" + bill + ", sub_admin=" + sub_admin + "]";
	}
	
	
}
