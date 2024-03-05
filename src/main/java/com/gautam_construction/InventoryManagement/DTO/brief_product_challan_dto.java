package com.gautam_construction.InventoryManagement.DTO;

import java.util.Objects;

public class brief_product_challan_dto {
	private String challan_no;
	private Long total_prod;
	private String total_quantity;
	public brief_product_challan_dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public brief_product_challan_dto(String challan_no, Long total_prod, String total_quantity) {
		super();
		this.challan_no = challan_no;
		this.total_prod = total_prod;
		this.total_quantity = total_quantity;
	}
	public String getChallan_no() {
		return challan_no;
	}
	public void setChallan_no(String challan_no) {
		this.challan_no = challan_no;
	}
	public Long getTotal_prod() {
		return total_prod;
	}
	public void setTotal_prod(Long total_prod) {
		this.total_prod = total_prod;
	}
	public String getTotal_quantity() {
		return total_quantity;
	}
	public void setTotal_quantity(String total_quantity) {
		this.total_quantity = total_quantity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(challan_no, total_prod, total_quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		brief_product_challan_dto other = (brief_product_challan_dto) obj;
		return Objects.equals(challan_no, other.challan_no) && Objects.equals(total_prod, other.total_prod)
				&& Objects.equals(total_quantity, other.total_quantity);
	}
	@Override
	public String toString() {
		return "brief_product_challan_dto [challan_no=" + challan_no + ", total_prod=" + total_prod
				+ ", total_quantity=" + total_quantity + "]";
	}
	
	                                                                                                    
}
