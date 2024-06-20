package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_staff_dto;
import com.gautam_construction.InventoryManagement.model.product_exit_by_staff;


public interface product_exit_by_staff_repository extends JpaRepository<product_exit_by_staff, Long>{
	public final static String GET_ALL_PRODUCT_EXIT_BY_STAFF = "SELECT * FROM product_exit_by_staff";
	public final static String GET_ALL_PRODUCT_EXIT_BY_STAFF_CHNO = "SELECT new com.gautam_construction.InventoryManagement.DTO.product_exit_by_staff_dto(pe.prod_id,p.name,p.unit,p.type,pe.quantity,pe.challan_no,pe.exit_date,pe.staff_emp_code,pe.receiving_person,pe.sub_admin) FROM product_exit_by_staff pe inner join product p on pe.prod_id=p.prod_id where pe.challan_no=:challan_no";
	public final static String GET_MAX_CHALLAN_NO = "SELECT max(challan_no) FROM product_exit_by_staff";
	public final static String INSERT_PRODUCT_EXIT_BY_STAFF = "insert into product_exit_by_staff(prod_id,quantity,challan_no,exit_date,staff_emp_code,receiving_person,bill,sub_admin) VALUES (:prod_id,:quantity,:challan_no,:exit_date,:staff_emp_code,:receiving_person,:bill,:sub_admin)";
	public final static String GET_BRIEF_PRODUCT_EXIT_BY_STAFF = "SELECT new com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto(challan_no,challan_no,COUNT(prod_id) as total_prod,SUM(quantity) as total_quantity) FROM product_exit_by_staff GROUP BY challan_no";
	
	@Query(value=GET_BRIEF_PRODUCT_EXIT_BY_STAFF)
	List<brief_product_challan_dto> getBriefProductExitByStaff();
	
	
	@Query(value=GET_ALL_PRODUCT_EXIT_BY_STAFF,nativeQuery=true)
	List<product_exit_by_staff> getAllProductExitByStaff();
	
	@Query(value=GET_ALL_PRODUCT_EXIT_BY_STAFF_CHNO)
	List<product_exit_by_staff_dto> getAllProductExitByStaff_ChNo(@Param("challan_no") String challan_no);
	
	@Query(value=GET_MAX_CHALLAN_NO,nativeQuery=true)
	String getMaxChallanNo();
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_PRODUCT_EXIT_BY_STAFF, nativeQuery = true)
    @Transactional
	void InsertProductExitByStaff(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("challan_no") String challan_no,@Param("exit_date") String exit_date,@Param("staff_emp_code") String staff_emp_code,@Param("receiving_person") String receiving_person,@Param("bill") String bill,@Param("sub_admin") String sub_admin);

	public final static String DELETE_ALL_PRODUCT_EXIT_BY_STAFF = "delete from product_exit_by_staff where challan_no=:challan_no";
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_ALL_PRODUCT_EXIT_BY_STAFF, nativeQuery = true)
    @Transactional
	void DeleteAllProductExitByStaff(@Param("challan_no") String challan_no);
	
	public final static String GET_PRODUCT_FILTER_BY_SEARCH = "select new com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto(pe.prod_id,p.name,p.unit,pe.quantity,pe.challan_no,pe.exit_date,'Exit By Staff') FROM product_exit_by_staff pe inner join product p on pe.prod_id=p.prod_id where (:prod_id IS NULL OR :prod_id = '' OR p.prod_id=:prod_id) and (:date IS NULL OR :date = '' OR pe.exit_date=:date)";
	@Query(value=GET_PRODUCT_FILTER_BY_SEARCH)
	List<filter_product_search_dto> getProductFilterBySearch(@Param("prod_id") String prod_id,@Param("date") String date);
}
