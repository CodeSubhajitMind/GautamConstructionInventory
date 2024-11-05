package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_return")
public class product_return {
	@Id
    private Integer id;
	private String prod_id;
	private String prod_name;
	private String return_quantity;
	private String return_date;
	private String contractor_name;
	private String receiving_person_name;
	
	public product_return() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product_return(Integer id, String prod_id, String prod_name, String return_quantity, String return_date,
			String contractor_name, String receiving_person_name) {
		super();
		this.id = id;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.return_quantity = return_quantity;
		this.return_date = return_date;
		this.contractor_name = contractor_name;
		this.receiving_person_name = receiving_person_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getReturn_quantity() {
		return return_quantity;
	}
	public void setReturn_quantity(String return_quantity) {
		this.return_quantity = return_quantity;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public String getContractor_name() {
		return contractor_name;
	}
	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}
	public String getReceiving_person_name() {
		return receiving_person_name;
	}
	public void setReceiving_person_name(String receiving_person_name) {
		this.receiving_person_name = receiving_person_name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contractor_name, id, prod_id, prod_name, receiving_person_name, return_date,
				return_quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product_return other = (product_return) obj;
		return Objects.equals(contractor_name, other.contractor_name) && Objects.equals(id, other.id)
				&& Objects.equals(prod_id, other.prod_id) && Objects.equals(prod_name, other.prod_name)
				&& Objects.equals(receiving_person_name, other.receiving_person_name)
				&& Objects.equals(return_date, other.return_date)
				&& Objects.equals(return_quantity, other.return_quantity);
	}
	@Override
	public String toString() {
		return "product_return [id=" + id + ", prod_id=" + prod_id + ", prod_name=" + prod_name + ", return_quantity="
				+ return_quantity + ", return_date=" + return_date + ", contractor_name=" + contractor_name
				+ ", receiving_person_name=" + receiving_person_name + "]";
	}
	
	
}
