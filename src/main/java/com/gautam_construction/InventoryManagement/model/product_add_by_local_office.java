package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_add_by_local_office")
public class product_add_by_local_office {
	@Id
	private Integer id;
	private Integer prod_id;
	private String quantity;
	private String invoice_no;
	private String invoice_date;
	private String vendor_name;
	private String vehicle_no;
	private String serial_no;
	
	public product_add_by_local_office() {
		super();
		// TODO Auto-generated constructor stub
	}

	public product_add_by_local_office(Integer id, Integer prod_id, String quantity, String invoice_no,
			String invoice_date, String vendor_name, String vehicle_no, String serial_no) {
		super();
		this.id = id;
		this.prod_id = prod_id;
		this.quantity = quantity;
		this.invoice_no = invoice_no;
		this.invoice_date = invoice_date;
		this.vendor_name = vendor_name;
		this.vehicle_no = vehicle_no;
		this.serial_no = serial_no;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, invoice_date, invoice_no, prod_id, quantity, serial_no, vehicle_no, vendor_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product_add_by_local_office other = (product_add_by_local_office) obj;
		return Objects.equals(id, other.id) && Objects.equals(invoice_date, other.invoice_date)
				&& Objects.equals(invoice_no, other.invoice_no) && Objects.equals(prod_id, other.prod_id)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(serial_no, other.serial_no)
				&& Objects.equals(vehicle_no, other.vehicle_no) && Objects.equals(vendor_name, other.vendor_name);
	}

	@Override
	public String toString() {
		return "product_add_by_local_office [id=" + id + ", prod_id=" + prod_id + ", quantity=" + quantity
				+ ", invoice_no=" + invoice_no + ", invoice_date=" + invoice_date + ", vendor_name=" + vendor_name
				+ ", vehicle_no=" + vehicle_no + ", serial_no=" + serial_no + "]";
	}
	
	
	
}
