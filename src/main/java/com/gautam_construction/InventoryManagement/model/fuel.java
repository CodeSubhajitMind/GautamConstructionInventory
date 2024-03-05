package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fuel")
public class fuel {
	@Id
    private Integer id;
	private String fuel_type;
	private String quantity;
	public fuel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public fuel(Integer id, String fuel_type, String quantity) {
		super();
		this.id = id;
		this.fuel_type = fuel_type;
		this.quantity = quantity;
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
	@Override
	public int hashCode() {
		return Objects.hash(fuel_type, id, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		fuel other = (fuel) obj;
		return Objects.equals(fuel_type, other.fuel_type) && Objects.equals(id, other.id)
				&& Objects.equals(quantity, other.quantity);
	}
	@Override
	public String toString() {
		return "fuel [id=" + id + ", fuel_type=" + fuel_type + ", quantity=" + quantity + "]";
	}
	
	
}
