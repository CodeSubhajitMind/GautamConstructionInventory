package com.gautam_construction.InventoryManagement.DTO;

import java.util.Objects;

public class product_add_by_local_office_dto {
	private Integer prod_id;
	private String prod_name;
	private String prod_unit;
	private String prod_type;
	private String quantity;
	private String invoice_no;
	private String invoice_date;
	private String vendor_name;
	private String vehicle_no;
	private String serial_no;
	private String sub_admin;
	private String remarks;
	
	public product_add_by_local_office_dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product_add_by_local_office_dto(Integer prod_id, String prod_name,String prod_unit, String prod_type, String quantity, String invoice_no,
			String invoice_date, String vendor_name, String vehicle_no, String serial_no,String sub_admin,String remarks) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_unit = prod_unit;
		this.prod_type = prod_type;
		this.quantity = quantity;
		this.invoice_no = invoice_no;
		this.invoice_date = invoice_date;
		this.vendor_name = vendor_name;
		this.vehicle_no = vehicle_no;
		this.serial_no = serial_no;
		this.sub_admin = sub_admin;
		this.remarks = remarks;
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
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	public String getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
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
	@Override
	public int hashCode() {
		return Objects.hash(invoice_date, invoice_no, prod_id, prod_name, prod_type, prod_unit, quantity, remarks,
				serial_no, sub_admin, vehicle_no, vendor_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product_add_by_local_office_dto other = (product_add_by_local_office_dto) obj;
		return Objects.equals(invoice_date, other.invoice_date) && Objects.equals(invoice_no, other.invoice_no)
				&& Objects.equals(prod_id, other.prod_id) && Objects.equals(prod_name, other.prod_name)
				&& Objects.equals(prod_type, other.prod_type) && Objects.equals(prod_unit, other.prod_unit)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(serial_no, other.serial_no) && Objects.equals(sub_admin, other.sub_admin)
				&& Objects.equals(vehicle_no, other.vehicle_no) && Objects.equals(vendor_name, other.vendor_name);
	}
	@Override
	public String toString() {
		return "product_add_by_local_office_dto [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_unit="
				+ prod_unit + ", prod_type=" + prod_type + ", quantity=" + quantity + ", invoice_no=" + invoice_no
				+ ", invoice_date=" + invoice_date + ", vendor_name=" + vendor_name + ", vehicle_no=" + vehicle_no
				+ ", serial_no=" + serial_no + ", sub_admin=" + sub_admin + ", remarks=" + remarks + "]";
	}	

	
	
	
	
}
