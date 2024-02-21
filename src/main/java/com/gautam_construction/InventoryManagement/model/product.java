package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class product {
	@Id
    private Integer prod_id;
	private String name;
	private String unit;
	private String quantity;
	private String type;
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product(Integer prod_id, String name, String unit, String quantity, String type) {
		super();
		this.prod_id = prod_id;
		this.name = name;
		this.unit = unit;
		this.quantity = quantity;
		this.type = type;
	}
	public Integer getProd_id() {
		return prod_id;
	}
	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, prod_id, quantity, type, unit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product other = (product) obj;
		return Objects.equals(name, other.name) && Objects.equals(prod_id, other.prod_id)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(type, other.type)
				&& Objects.equals(unit, other.unit);
	}
	@Override
	public String toString() {
		return "product [prod_id=" + prod_id + ", name=" + name + ", unit=" + unit + ", quantity=" + quantity
				+ ", type=" + type + "]";
	}
	
	
}
