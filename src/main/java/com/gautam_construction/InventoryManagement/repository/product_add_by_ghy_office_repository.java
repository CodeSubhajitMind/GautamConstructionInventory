package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto;
import com.gautam_construction.InventoryManagement.DTO.product_add_by_ghy_office_dto;
import com.gautam_construction.InventoryManagement.DTO.product_add_by_local_office_dto;
import com.gautam_construction.InventoryManagement.model.product_add_by_ghy_office;

public interface product_add_by_ghy_office_repository extends JpaRepository<product_add_by_ghy_office, Long>{
	public final static String GET_ALL_PRODUCT_ADD_BY_GHY_OFFICE = "SELECT * FROM product_add_by_ghy_office";
	public final static String GET_ALL_PRODUCT_ADD_BY_GHY_OFFICE_CHNO = "SELECT new com.gautam_construction.InventoryManagement.DTO.product_add_by_ghy_office_dto(pe.prod_id,p.name,p.unit,p.type,pe.quantity,pe.invoice_no,pe.invoice_date,pe.vendor_name,pe.vehicle_no,pe.sub_admin,pe.remarks,pe.bill_no) FROM product_add_by_ghy_office pe inner join product p on pe.prod_id=p.prod_id where pe.invoice_no=:invoice_no";
	
	public final static String GET_BRIEF_PRODUCT_ADD_BY_GHY_OFFICE = "SELECT new com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto(bill_no,invoice_no,COUNT(prod_id) as total_prod,SUM(quantity) as total_quantity) FROM product_add_by_ghy_office GROUP BY invoice_no";
	public final static String INSERT_PRODUCT_ADD_BY_GHY_OFFICE = "insert into product_add_by_ghy_office(prod_id,quantity,invoice_no,invoice_date,vendor_name,vehicle_no,sub_admin,remarks,bill_no) VALUES (:prod_id,:quantity,:invoice_no,:invoice_date,:vendor_name,:vehicle_no,:sub_admin,:remarks,:bill_no)";
	public final static String GET_MAX_BILL_NO = "SELECT COALESCE(max(bill_no),0) FROM product_add_by_ghy_office";
	
	@Query(value=GET_MAX_BILL_NO,nativeQuery=true)
	String getMaxBillnNo();
	
	@Query(value=GET_ALL_PRODUCT_ADD_BY_GHY_OFFICE,nativeQuery=true)
	List<product_add_by_ghy_office> getAllProductAddByGhyOffice();
	
	@Query(value=GET_ALL_PRODUCT_ADD_BY_GHY_OFFICE_CHNO)
	List<product_add_by_ghy_office_dto> getAllProductAddByGhyOfficeChNo(@Param("invoice_no") String invoice_no);
	
	@Query(value=GET_BRIEF_PRODUCT_ADD_BY_GHY_OFFICE)
	List<brief_product_challan_dto> getBriefProductAddByGhyOffice();
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_PRODUCT_ADD_BY_GHY_OFFICE, nativeQuery = true)
    @Transactional
	void InsertProductAddByGhyOffice(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("invoice_no") String invoice_no,@Param("invoice_date") String invoice_date,@Param("vendor_name") String vendor_name,@Param("vehicle_no") String vehicle_no,@Param("sub_admin") String sub_admin,@Param("remarks") String remarks,@Param("bill_no") String bill_no);

	public final static String DELETE_ALL_PRODUCT_ADD_BY_GHY_OFFICE = "delete from product_add_by_ghy_office where invoice_no=:invoice_no";
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_ALL_PRODUCT_ADD_BY_GHY_OFFICE, nativeQuery = true)
    @Transactional
	void DeleteAllProductAddByGhyOffice(@Param("invoice_no") String invoice_no);
	
//	public final static String GET_PRODUCT_FILTER_BY_SEARCH = "select new com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto(pe.prod_id,p.name,p.unit,pe.quantity,pe.invoice_no,pe.invoice_date,'Entry By Purchase from Ghy Office') FROM product_add_by_ghy_office pe inner join product p on pe.prod_id=p.prod_id where p.prod_id=:prod_id and pe.invoice_date=:date";
//	@Query(value=GET_PRODUCT_FILTER_BY_SEARCH)
//	List<filter_product_search_dto> getProductFilterBySearchGO(@Param("prod_id") String prod_id,@Param("date") String date);
	
	public final static String GET_PRODUCT_FILTER_BY_SEARCH = "SELECT new com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto(pe.prod_id,p.name,p.unit,pe.quantity,pe.invoice_no,pe.invoice_date,'By Sub-Contractor') FROM product_add_by_ghy_office pe inner join product p on pe.prod_id=p.prod_id where (:prod_id IS NULL OR :prod_id = '' OR p.prod_id=:prod_id) and (:date IS NULL OR :date = '' OR pe.invoice_date=:date)";
	@Query(value=GET_PRODUCT_FILTER_BY_SEARCH)
	List<filter_product_search_dto> getProductFilterBySearch(@Param("prod_id") String prod_id,@Param("date") String date);
	
//	public final static String GET_PRODUCT_FILTER_BY_SEARCH = "select new com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto(pe.prod_id,p.name,p.unit,pe.quantity,pe.challan_no,pe.date_of_entry,'Entry By Challan') FROM product_add_by_challan pe inner join product p on pe.prod_id=p.prod_id where p.prod_id=:prod_id and pe.date_of_entry=:date";
//	@Query(value=GET_PRODUCT_FILTER_BY_SEARCH)
//	List<filter_product_search_dto> getProductFilterBySearch(@Param("prod_id") String prod_id,@Param("date") String date);
	
	

}
