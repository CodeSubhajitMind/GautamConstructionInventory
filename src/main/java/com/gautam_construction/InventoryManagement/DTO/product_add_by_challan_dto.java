package com.gautam_construction.InventoryManagement.DTO;

import java.util.Objects;

public class product_add_by_challan_dto {
	private Integer prod_id;
	private String prod_name;
	private String prod_unit;
	private String prod_type;
	private String quantity;
	private String challan_no;
	private String date_of_entry;
	private String issuing_branch;
	private String vehicle_no;
	private String to;
	private String sub_admin;
	private String remarks;
	private String bill_no;
	public product_add_by_challan_dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product_add_by_challan_dto(Integer prod_id, String prod_name, String prod_unit, String prod_type, String quantity, String challan_no,
			String date_of_entry, String issuing_branch, String vehicle_no, String to,String sub_admin,String remarks,String bill_no) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_unit = prod_unit;
		this.prod_type = prod_type;
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
	public String getProd_unit() {
		return prod_unit;
	}
	public void setProd_unit(String prod_unit) {
		this.prod_unit = prod_unit;
	}
	public String getProd_type() {
		return prod_type;
	}
	public void setProd_type(String prod_type) {
		this.prod_type = prod_type;
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
		return Objects.hash(bill_no, challan_no, date_of_entry, issuing_branch, prod_id, prod_name, prod_type,
				prod_unit, quantity, remarks, sub_admin, to, vehicle_no);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product_add_by_challan_dto other = (product_add_by_challan_dto) obj;
		return Objects.equals(bill_no, other.bill_no) && Objects.equals(challan_no, other.challan_no)
				&& Objects.equals(date_of_entry, other.date_of_entry)
				&& Objects.equals(issuing_branch, other.issuing_branch) && Objects.equals(prod_id, other.prod_id)
				&& Objects.equals(prod_name, other.prod_name) && Objects.equals(prod_type, other.prod_type)
				&& Objects.equals(prod_unit, other.prod_unit) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(sub_admin, other.sub_admin)
				&& Objects.equals(to, other.to) && Objects.equals(vehicle_no, other.vehicle_no);
	}
	@Override
	public String toString() {
		return "product_add_by_challan_dto [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_unit="
				+ prod_unit + ", prod_type=" + prod_type + ", quantity=" + quantity + ", challan_no=" + challan_no
				+ ", date_of_entry=" + date_of_entry + ", issuing_branch=" + issuing_branch + ", vehicle_no="
				+ vehicle_no + ", to=" + to + ", sub_admin=" + sub_admin + ", remarks=" + remarks + ", bill_no="
				+ bill_no + "]";
	}
	
	
	
}
