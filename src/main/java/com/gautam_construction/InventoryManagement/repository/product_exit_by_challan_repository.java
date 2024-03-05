package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_challan_dto;
import com.gautam_construction.InventoryManagement.model.product_exit_by_challan;


public interface product_exit_by_challan_repository extends JpaRepository<product_exit_by_challan, Long>{
	public final static String GET_ALL_PRODUCT_EXIT_BY_CHALLAN = "SELECT * FROM product_exit_by_challan";
	public final static String GET_ALL_PRODUCT_EXIT_BY_CHALLAN_CHNO = "SELECT new com.gautam_construction.InventoryManagement.DTO.product_exit_by_challan_dto(pe.prod_id,p.name,pe.quantity,pe.challan_no,pe.exit_date,pe.to_location,pe.vehicle_no) FROM product_exit_by_challan pe inner join product p on pe.prod_id=p.prod_id where pe.challan_no=:challan_no";
	public final static String GET_BRIEF_PRODUCT_EXIT_BY_CHALLAN = "SELECT new com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto(challan_no,COUNT(prod_id) as total_prod,SUM(quantity) as total_quantity) FROM product_exit_by_challan GROUP BY challan_no";
	public final static String GET_MAX_CHALLAN_NO = "SELECT max(challan_no) FROM product_exit_by_challan";
	public final static String INSERT_PRODUCT_EXIT_BY_CHALLAN = "insert into product_exit_by_challan(prod_id,quantity,challan_no,exit_date,to_location,vehicle_no,bill) VALUES (:prod_id,:quantity,:challan_no,:exit_date,:to_location,:vehicle_no,:bill)";
	
	@Query(value=GET_ALL_PRODUCT_EXIT_BY_CHALLAN,nativeQuery=true)
	List<product_exit_by_challan> getAllProductExitByChallan();
	
	@Query(value=GET_ALL_PRODUCT_EXIT_BY_CHALLAN_CHNO)
	List<product_exit_by_challan_dto> getAllProductExitByChallanChNo(@Param("challan_no") String challan_no);
	
	@Query(value=GET_MAX_CHALLAN_NO,nativeQuery=true)
	String getMaxChallanNo();
	
	@Query(value=GET_BRIEF_PRODUCT_EXIT_BY_CHALLAN)
	List<brief_product_challan_dto> getBriefProductExitByChallan();
	                                             
	@Modifying
    @Query(value = INSERT_PRODUCT_EXIT_BY_CHALLAN, nativeQuery = true)
    @Transactional
	void InsertProductExitByChallan(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("challan_no") String challan_no,@Param("exit_date") String exit_date,@Param("to_location") String to_location,@Param("vehicle_no") String vehicle_no,@Param("bill") String bill);

}
