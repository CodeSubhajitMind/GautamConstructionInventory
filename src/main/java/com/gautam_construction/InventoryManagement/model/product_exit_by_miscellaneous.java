package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_exit_by_miscellaneous")
public class product_exit_by_miscellaneous {
	@Id
	private Integer id;
	private Integer prod_id;
	private String quantity;
	private String challan_no;
	private String exit_date;
	private String work_name;
	private String receiving_person;
	private String bill;
	public product_exit_by_miscellaneous() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product_exit_by_miscellaneous(Integer id, Integer prod_id, String quantity, String challan_no, String exit_date,
			String work_name, String receiving_person, String bill) {
		super();
		this.id = id;
		this.prod_id = prod_id;
		this.quantity = quantity;
		this.challan_no = challan_no;
		this.exit_date = exit_date;
		this.work_name = work_name;
		this.receiving_person = receiving_person;
		this.bill = bill;
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
	public String getWork_name() {
		return work_name;
	}
	public void setWork_name(String work_name) {
		this.work_name = work_name;
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
	@Override
	public int hashCode() {
		return Objects.hash(bill, challan_no, exit_date, id, prod_id, quantity, receiving_person, work_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product_exit_by_miscellaneous other = (product_exit_by_miscellaneous) obj;
		return Objects.equals(bill, other.bill) && Objects.equals(challan_no, other.challan_no)
				&& Objects.equals(exit_date, other.exit_date) && Objects.equals(id, other.id)
				&& Objects.equals(prod_id, other.prod_id) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(receiving_person, other.receiving_person)
				&& Objects.equals(work_name, other.work_name);
	}
	@Override
	public String toString() {
		return "product_exit_by_miscellaneous [id=" + id + ", prod_id=" + prod_id + ", quantity=" + quantity
				+ ", challan_no=" + challan_no + ", exit_date=" + exit_date + ", work_name=" + work_name
				+ ", receiving_person=" + receiving_person + ", bill=" + bill + "]";
	}
	
	
	
}
