package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto;
import com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto_by_product;
import com.gautam_construction.InventoryManagement.DTO.product_add_by_local_office_dto;
import com.gautam_construction.InventoryManagement.model.product_add_by_ghy_office;
import com.gautam_construction.InventoryManagement.model.product_add_by_local_office;


public interface product_add_by_local_office_repository extends JpaRepository<product_add_by_local_office, Long>{
	public final static String GET_ALL_PRODUCT_ADD_BY_LOCAL_OFFICE = "SELECT * FROM product_add_by_local_office";
	public final static String GET_ALL_PRODUCT_ADD_BY_LOCAL_OFFICE_CHNO = "SELECT new com.gautam_construction.InventoryManagement.DTO.product_add_by_local_office_dto(pe.prod_id,p.name,p.unit,p.type,pe.quantity,pe.invoice_no,pe.invoice_date,pe.vendor_name,pe.vehicle_no,pe.serial_no,pe.sub_admin,pe.remarks) FROM product_add_by_local_office pe inner join product p on pe.prod_id=p.prod_id where pe.invoice_no=:invoice_no";
	
	public final static String GET_MAX_SERIAL_NUMBER = "SELECT COALESCE(max(serial_no),0) FROM product_add_by_local_office";
	public final static String GET_BRIEF_PRODUCT_ADD_BY_LOCAL_OFFICE = "SELECT new com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto(serial_no,invoice_no,COUNT(prod_id) as total_prod,SUM(quantity) as total_quantity) FROM product_add_by_local_office GROUP BY invoice_no";
	public final static String INSERT_PRODUCT_ADD_BY_LOCAL_OFFICE = "insert into product_add_by_local_office(prod_id,quantity,invoice_no,invoice_date,vendor_name,vehicle_no,serial_no,sub_admin,remarks) VALUES (:prod_id,:quantity,:invoice_no,:invoice_date,:vendor_name,:vehicle_no,:serial_no,:sub_admin,:remarks)";
	public final static String GET_MAX_BILL_NO = "SELECT COALESCE(max(bill_no),0) FROM product_add_by_local_office";
	
	@Query(value=GET_MAX_BILL_NO,nativeQuery=true)
	String getMaxBillnNo();
	
	@Query(value=GET_ALL_PRODUCT_ADD_BY_LOCAL_OFFICE,nativeQuery=true)
	List<product_add_by_local_office> getAllProductAddByLocalOffice();
	
	@Query(value=GET_ALL_PRODUCT_ADD_BY_LOCAL_OFFICE_CHNO)
	List<product_add_by_local_office_dto> getAllProductAddByLocalOfficeChNo(@Param("invoice_no") String invoice_no);
	
	@Query(value=GET_MAX_SERIAL_NUMBER,nativeQuery=true)
	String getMaxSerialNumber();
	
	@Query(value=GET_BRIEF_PRODUCT_ADD_BY_LOCAL_OFFICE)
	List<brief_product_challan_dto> getBriefProductAddByLocalOffice();
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_PRODUCT_ADD_BY_LOCAL_OFFICE, nativeQuery = true)
    @Transactional
	void InsertProductAddByLocalOffice(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("invoice_no") String invoice_no,@Param("invoice_date") String invoice_date,@Param("vendor_name") String vendor_name,@Param("vehicle_no") String vehicle_no,@Param("serial_no") String serial_no,@Param("sub_admin") String sub_admin,@Param("remarks") String remarks);

	public final static String DELETE_ALL_PRODUCT_ADD_BY_LOCAL_OFFICE = "delete from product_add_by_local_office where invoice_no=:invoice_no";
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_ALL_PRODUCT_ADD_BY_LOCAL_OFFICE, nativeQuery = true)
    @Transactional
	void DeleteAllProductAddByLocalOffice(@Param("invoice_no") String invoice_no);
	
	public final static String GET_PRODUCT_FILTER_BY_SEARCH = "select new com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto(pe.prod_id,p.name,p.type,p.unit,pe.quantity,pe.invoice_no,pe.invoice_date,'By Local Office') FROM product_add_by_local_office pe inner join product p on pe.prod_id=p.prod_id where (:prod_id IS NULL OR :prod_id = '' OR p.prod_id=:prod_id) and (:date IS NULL OR :date = '' OR pe.invoice_date=:date)";
	@Query(value=GET_PRODUCT_FILTER_BY_SEARCH)
	List<filter_product_search_dto> getProductFilterBySearch(@Param("prod_id") String prod_id,@Param("date") String date);
	
	public final static String GET_PRODUCT_FILTER_SEARCH_BY_PRODUCT = "select new com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto_by_product(pe.prod_id,p.name,p.type,p.unit,pe.quantity,pe.invoice_no,pe.invoice_date,'By Local Office') FROM product_add_by_local_office pe inner join product p on pe.prod_id=p.prod_id where (:prod_id IS NULL OR :prod_id = '' OR p.prod_id=:prod_id) and (COALESCE(:s_date, '') = '' OR STR_TO_DATE(pe.invoice_date, '%Y-%m-%d') >= STR_TO_DATE(:s_date, '%Y-%m-%d'))"
			+ "  AND (COALESCE(:e_date, '') = '' OR STR_TO_DATE(pe.invoice_date, '%Y-%m-%d') <= STR_TO_DATE(:e_date, '%Y-%m-%d')) ORDER BY pe.invoice_date";
	@Query(value=GET_PRODUCT_FILTER_SEARCH_BY_PRODUCT)
	List<filter_product_search_dto_by_product> getProductFilterSearchByProduct(@Param("prod_id") String prod_id,@Param("s_date") String s_date,@Param("e_date") String e_date);
	
}
