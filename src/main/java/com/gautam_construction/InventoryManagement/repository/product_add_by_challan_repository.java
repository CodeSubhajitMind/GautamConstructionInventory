package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.product_add_by_challan;


public interface product_add_by_challan_repository extends JpaRepository<product_add_by_challan, Long>{
	public final static String GET_ALL_PRODUCT_ADD_BY_CHALLAN = "SELECT * FROM product_add_by_challan";
	public final static String INSERT_PRODUCT_ADD_BY_CHALLAN = "insert into product_add_by_challan(prod_id,quantity,challan_no,date_of_entry,issuing_branch,vehicle_no) VALUES (:prod_id,:quantity,:challan_no,:date_of_entry,:issuing_branch,:vehicle_no)";
	
	@Query(value=GET_ALL_PRODUCT_ADD_BY_CHALLAN,nativeQuery=true)
	List<product_add_by_challan> getAllProductAddByChallan();
	                                             
	@Modifying
    @Query(value = INSERT_PRODUCT_ADD_BY_CHALLAN, nativeQuery = true)
    @Transactional
	void InsertProductAddByChallan(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("challan_no") String challan_no,@Param("date_of_entry") String date_of_entry,@Param("issuing_branch") String issuing_branch,@Param("vehicle_no") String vehicle_no);
}
