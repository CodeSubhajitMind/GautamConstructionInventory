package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.product;

public interface ProductRepository extends JpaRepository<product, Long>{
	public final static String GET_ALL_PRODUCTS = "SELECT * FROM product";
	public final static String INSERT_PRODUCT_DETAILS = "insert into product(name,unit,quantity,type) VALUES (:name,:unit,:quantity,:type)";
	
	@Query(value=GET_ALL_PRODUCTS,nativeQuery=true)
	List<product> getAllProducts();
	                                             
	@Modifying
    @Query(value = INSERT_PRODUCT_DETAILS, nativeQuery = true)
    @Transactional
	void InsertProductDetails(@Param("name") String name, @Param("unit") String unit, @Param("quantity") String quantity, @Param("type") String type);
    
}
