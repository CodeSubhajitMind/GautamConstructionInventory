package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto;
import com.gautam_construction.InventoryManagement.DTO.product_add_by_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.product_add_by_ghy_office_dto;
import com.gautam_construction.InventoryManagement.model.product_add_by_challan;


public interface product_add_by_challan_repository extends JpaRepository<product_add_by_challan, Long>{
	public final static String GET_ALL_PRODUCT_ADD_BY_CHALLAN = "SELECT * FROM product_add_by_challan";
	public final static String GET_ALL_PRODUCT_ADD_BY_CHALLAN_CHNO = "SELECT new com.gautam_construction.InventoryManagement.DTO.product_add_by_challan_dto(pe.prod_id,p.name,p.unit,p.type,pe.quantity,pe.challan_no,pe.date_of_entry,pe.issuing_branch,pe.vehicle_no,pe.to,pe.sub_admin,pe.remarks,pe.bill_no) FROM product_add_by_challan pe inner join product p on pe.prod_id=p.prod_id where pe.challan_no=:challan_no";
	public final static String GET_BRIEF_PRODUCT_ADD_BY_CHALLAN = "SELECT new com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto(bill_no,challan_no,COUNT(prod_id) as total_prod,SUM(quantity) as total_quantity) FROM product_add_by_challan GROUP BY challan_no";
	public final static String INSERT_PRODUCT_ADD_BY_CHALLAN = "insert into product_add_by_challan(prod_id,quantity,challan_no,date_of_entry,issuing_branch,vehicle_no,sub_admin,remarks,bill_no) VALUES (:prod_id,:quantity,:challan_no,:date_of_entry,:issuing_branch,:vehicle_no,:sub_admin,:remarks,:bill_no)";
	//public final static String UPDATE_PRODUCT_ADD_BY_CHALLAN = "update product_add_by_challan(prod_id,quantity,challan_no,date_of_entry,issuing_branch,vehicle_no) VALUES (:prod_id,:quantity,:challan_no,:date_of_entry,:issuing_branch,:vehicle_no)";
	public final static String GET_MAX_BILL_NO = "SELECT COALESCE(max(bill_no),0) FROM product_add_by_challan";
	
	@Query(value=GET_MAX_BILL_NO,nativeQuery=true)
	String getMaxBillnNo();
	
	@Query(value=GET_ALL_PRODUCT_ADD_BY_CHALLAN,nativeQuery=true)
	List<product_add_by_challan> getAllProductAddByChallan();
	
	@Query(value=GET_ALL_PRODUCT_ADD_BY_CHALLAN_CHNO)
	List<product_add_by_challan_dto> getAllProductAddByChallanChNo(@Param("challan_no") String challan_no);
	
	
	@Query(value=GET_BRIEF_PRODUCT_ADD_BY_CHALLAN)
	List<brief_product_challan_dto> getBriefProductAddByChallan();
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_PRODUCT_ADD_BY_CHALLAN, nativeQuery = true)
    @Transactional
	void InsertProductAddByChallan(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("challan_no") String challan_no,@Param("date_of_entry") String date_of_entry,@Param("issuing_branch") String issuing_branch,@Param("vehicle_no") String vehicle_no,@Param("sub_admin") String sub_admin,@Param("remarks") String remarks,@Param("bill_no") String bill_no);
	
	public final static String DELETE_ALL_PRODUCT_ADD_BY_CHALLAN = "delete from product_add_by_challan where challan_no=:challan_no";
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_ALL_PRODUCT_ADD_BY_CHALLAN, nativeQuery = true)
    @Transactional
	void DeleteAllProductAddByChallan(@Param("challan_no") String challan_no);
	
	public final static String GET_PRODUCT_FILTER_BY_SEARCH = "select new com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto(pe.prod_id,p.name,p.unit,pe.quantity,pe.challan_no,pe.date_of_entry,'By Challan') FROM product_add_by_challan pe inner join product p on pe.prod_id=p.prod_id where (:prod_id IS NULL OR :prod_id = '' OR p.prod_id=:prod_id) and (:date IS NULL OR :date = '' OR pe.date_of_entry=:date)";
	@Query(value=GET_PRODUCT_FILTER_BY_SEARCH)
	List<filter_product_search_dto> getProductFilterBySearch(@Param("prod_id") String prod_id,@Param("date") String date);
	
}
