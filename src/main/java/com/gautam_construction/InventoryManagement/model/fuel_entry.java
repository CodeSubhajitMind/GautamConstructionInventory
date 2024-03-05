package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fuel_entry")
public class fuel_entry {
	@Id
    private Integer id;
	private String fuel_type;
	private String quantity;
	private String invoice_no;
	private String invoice_date;
	private String vendor_name;
	private String vehicle_no;
	public fuel_entry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public fuel_entry(Integer id, String fuel_type, String quantity, String invoice_no, String invoice_date,
			String vendor_name, String vehicle_no) {
		super();
		this.id = id;
		this.fuel_type = fuel_type;
		this.quantity = quantity;
		this.invoice_no = invoice_no;
		this.invoice_date = invoice_date;
		this.vendor_name = vendor_name;
		this.vehicle_no = vehicle_no;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
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
	@Override
	public int hashCode() {
		return Objects.hash(fuel_type, id, invoice_date, invoice_no, quantity, vehicle_no, vendor_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		fuel_entry other = (fuel_entry) obj;
		return Objects.equals(fuel_type, other.fuel_type) && Objects.equals(id, other.id)
				&& Objects.equals(invoice_date, other.invoice_date) && Objects.equals(invoice_no, other.invoice_no)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(vehicle_no, other.vehicle_no)
				&& Objects.equals(vendor_name, other.vendor_name);
	}
	@Override
	public String toString() {
		return "fuel_entry [id=" + id + ", fuel_type=" + fuel_type + ", quantity=" + quantity + ", invoice_no="
				+ invoice_no + ", invoice_date=" + invoice_date + ", vendor_name=" + vendor_name + ", vehicle_no="
				+ vehicle_no + "]";
	}
	
	
}
