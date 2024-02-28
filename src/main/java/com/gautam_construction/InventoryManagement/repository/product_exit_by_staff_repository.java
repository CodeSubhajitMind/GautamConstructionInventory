package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.product_exit_by_staff;


public interface product_exit_by_staff_repository extends JpaRepository<product_exit_by_staff, Long>{
	public final static String GET_ALL_PRODUCT_EXIT_BY_STAFF = "SELECT * FROM product_exit_by_staff";
	public final static String GET_MAX_CHALLAN_NO = "SELECT max(challan_no) FROM product_exit_by_staff";
	public final static String INSERT_PRODUCT_EXIT_BY_STAFF = "insert into product_exit_by_staff(prod_id,quantity,challan_no,exit_date,staff_emp_code,receiving_person,bill) VALUES (:prod_id,:quantity,:challan_no,:exit_date,:staff_emp_code,:receiving_person,:bill)";
	
	@Query(value=GET_ALL_PRODUCT_EXIT_BY_STAFF,nativeQuery=true)
	List<product_exit_by_staff> getAllProductExitByStaff();
	
	@Query(value=GET_MAX_CHALLAN_NO,nativeQuery=true)
	String getMaxChallanNo();
	                                             
	@Modifying
    @Query(value = INSERT_PRODUCT_EXIT_BY_STAFF, nativeQuery = true)
    @Transactional
	void InsertProductExitByStaff(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("challan_no") String challan_no,@Param("exit_date") String exit_date,@Param("staff_emp_code") String staff_emp_code,@Param("receiving_person") String receiving_person,@Param("bill") String bill);

}
