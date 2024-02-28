package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.product_exit_by_challan;


public interface product_exit_by_challan_repository extends JpaRepository<product_exit_by_challan, Long>{
	public final static String GET_ALL_PRODUCT_EXIT_BY_CHALLAN = "SELECT * FROM product_exit_by_challan";
	public final static String GET_MAX_CHALLAN_NO = "SELECT max(challan_no) FROM product_exit_by_challan";
	public final static String INSERT_PRODUCT_EXIT_BY_CHALLAN = "insert into product_exit_by_challan(prod_id,quantity,challan_no,exit_date,to_location,vehicle_no,bill) VALUES (:prod_id,:quantity,:challan_no,:exit_date,:to_location,:vehicle_no,:bill)";
	
	@Query(value=GET_ALL_PRODUCT_EXIT_BY_CHALLAN,nativeQuery=true)
	List<product_exit_by_challan> getAllProductExitByChallan();
	
	@Query(value=GET_MAX_CHALLAN_NO,nativeQuery=true)
	String getMaxChallanNo();
	                                             
	@Modifying
    @Query(value = INSERT_PRODUCT_EXIT_BY_CHALLAN, nativeQuery = true)
    @Transactional
	void InsertProductExitByChallan(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("challan_no") String challan_no,@Param("exit_date") String exit_date,@Param("to_location") String to_location,@Param("vehicle_no") String vehicle_no,@Param("bill") String bill);

}
