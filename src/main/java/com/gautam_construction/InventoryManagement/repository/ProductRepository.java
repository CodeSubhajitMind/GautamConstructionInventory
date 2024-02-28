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
	public final static String GET_PRODUCT_QUANTITY = "SELECT * FROM product where prod_id=:prod_id";
	public final static String UPDATE_PRODUCT_QUANTITY = "update product set quantity=:quantity where prod_id=:prod_id";
	

	@Query(value=GET_ALL_PRODUCTS,nativeQuery=true)
	List<product> getAllProducts();
	                                             
	@Modifying
    @Query(value = INSERT_PRODUCT_DETAILS, nativeQuery = true)
    @Transactional
	void InsertProductDetails(@Param("name") String name, @Param("unit") String unit, @Param("quantity") String quantity, @Param("type") String type);
    
	@Query(value=GET_PRODUCT_QUANTITY,nativeQuery=true)
	List<product> getProductQuantity(@Param("prod_id") Integer prod_id);
	
	@Modifying
    @Query(value = UPDATE_PRODUCT_QUANTITY, nativeQuery = true)
    @Transactional
	void UpdateProductQuantity(@Param("prod_id") Integer prod_id, @Param("quantity") String quantity);
    
	
}
