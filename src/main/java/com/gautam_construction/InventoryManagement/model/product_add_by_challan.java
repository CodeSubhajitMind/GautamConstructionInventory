package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_add_by_challan")
public class product_add_by_challan {
	@Id
	private Integer id;
	private Integer prod_id;
	private String quantity;
	private String challan_no;
	private String date_of_entry;
	private String issuing_branch;
	private String vehicle_no;
	private String to;
	private String sub_admin;
	private String remarks;
	private String bill_no;
	public product_add_by_challan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product_add_by_challan(Integer id, Integer prod_id, String quantity, String challan_no, String date_of_entry,
			String issuing_branch, String vehicle_no, String to, String sub_admin,String remarks,String bill_no) {
		super();
		this.id = id;
		this.prod_id = prod_id;
		this.quantity = quantity;
		this.challan_no = challan_no;
		this.date_of_entry = date_of_entry;
		this.issuing_branch = issuing_branch;
		this.vehicle_no = vehicle_no;
		this.to = to;
		this.sub_admin = sub_admin;
		this.remarks = remarks;
		this.bill_no = bill_no;
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
	public String getDate_of_entry() {
		return date_of_entry;
	}
	public void setDate_of_entry(String date_of_entry) {
		this.date_of_entry = date_of_entry;
	}
	public String getIssuing_branch() {
		return issuing_branch;
	}
	public void setIssuing_branch(String issuing_branch) {
		this.issuing_branch = issuing_branch;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getSub_admin() {
		return sub_admin;
	}
	public void setSub_admin(String sub_admin) {
		this.sub_admin = sub_admin;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getBill_no() {
		return bill_no;
	}
	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bill_no, challan_no, date_of_entry, id, issuing_branch, prod_id, quantity, remarks,
				sub_admin, to, vehicle_no);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product_add_by_challan other = (product_add_by_challan) obj;
		return Objects.equals(bill_no, other.bill_no) && Objects.equals(challan_no, other.challan_no)
				&& Objects.equals(date_of_entry, other.date_of_entry) && Objects.equals(id, other.id)
				&& Objects.equals(issuing_branch, other.issuing_branch) && Objects.equals(prod_id, other.prod_id)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(sub_admin, other.sub_admin) && Objects.equals(to, other.to)
				&& Objects.equals(vehicle_no, other.vehicle_no);
	}
	@Override
	public String toString() {
		return "product_add_by_challan [id=" + id + ", prod_id=" + prod_id + ", quantity=" + quantity + ", challan_no="
				+ challan_no + ", date_of_entry=" + date_of_entry + ", issuing_branch=" + issuing_branch
				+ ", vehicle_no=" + vehicle_no + ", to=" + to + ", sub_admin=" + sub_admin + ", remarks=" + remarks
				+ ", bill_no=" + bill_no + "]";
	}
	
	

	}
