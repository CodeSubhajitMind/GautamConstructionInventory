package com.gautam_construction.InventoryManagement.DTO;

import java.util.Objects;

public class filter_product_search_dto {
	private Integer prod_id;
	private String prod_name;
	private String prod_unit;
	private String prod_quantity;
	private String challan_no;
	private String challan_date;
	private String challan_type;
	
	public filter_product_search_dto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public filter_product_search_dto(Integer prod_id, String prod_name, String prod_unit, String prod_quantity,
			String challan_no, String challan_date, String challan_type) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_unit = prod_unit;
		this.prod_quantity = prod_quantity;
		this.challan_no = challan_no;
		this.challan_date = challan_date;
		this.challan_type = challan_type;
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

	public String getProd_quantity() {
		return prod_quantity;
	}

	public void setProd_quantity(String prod_quantity) {
		this.prod_quantity = prod_quantity;
	}

	public String getChallan_no() {
		return challan_no;
	}

	public void setChallan_no(String challan_no) {
		this.challan_no = challan_no;
	}

	public String getChallan_date() {
		return challan_date;
	}

	public void setChallan_date(String challan_date) {
		this.challan_date = challan_date;
	}

	public String getChallan_type() {
		return challan_type;
	}

	public void setChallan_type(String challan_type) {
		this.challan_type = challan_type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(challan_date, challan_no, challan_type, prod_id, prod_name, prod_quantity, prod_unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		filter_product_search_dto other = (filter_product_search_dto) obj;
		return Objects.equals(challan_date, other.challan_date) && Objects.equals(challan_no, other.challan_no)
				&& Objects.equals(challan_type, other.challan_type) && Objects.equals(prod_id, other.prod_id)
				&& Objects.equals(prod_name, other.prod_name) && Objects.equals(prod_quantity, other.prod_quantity)
				&& Objects.equals(prod_unit, other.prod_unit);
	}

	@Override
	public String toString() {
		return "filter_product_search_dto [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_unit=" + prod_unit
				+ ", prod_quantity=" + prod_quantity + ", challan_no=" + challan_no + ", challan_date=" + challan_date
				+ ", challan_type=" + challan_type + "]";
	}
	
	
}
