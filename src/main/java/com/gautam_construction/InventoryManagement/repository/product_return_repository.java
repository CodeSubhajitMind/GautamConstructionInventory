package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.product_return;

public interface product_return_repository extends JpaRepository<product_return, Long>{
	public final static String GET_ALL_PRODUCT_RETURN = "SELECT * FROM product_return";
	public final static String INSERT_PRODUCT_RETURN_DETAILS = "insert into product_return(prod_id,prod_name,return_quantity,return_date,contractor_name,receiving_person_name) VALUES (:prod_id,:prod_name,:return_quantity,:return_date,:contractor_name,:receiving_person_name)";
	
	@Query(value=GET_ALL_PRODUCT_RETURN,nativeQuery=true)
	List<product_return> getAllProductReturn();
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_PRODUCT_RETURN_DETAILS, nativeQuery = true)
    @Transactional
	void InsertProductReturnDetails(@Param("prod_id") String prod_id, @Param("prod_name") String prod_name, @Param("return_quantity") String return_quantity, @Param("return_date") String return_date, @Param("contractor_name") String contractor_name, @Param("receiving_person_name") String receiving_person_name);
    
}
