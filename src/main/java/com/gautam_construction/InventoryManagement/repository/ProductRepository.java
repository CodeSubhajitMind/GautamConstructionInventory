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
	public final static String GET_ALL_REFUNDABLE_PRODUCTS = "SELECT * FROM product where type='refundable'";
	public final static String INSERT_PRODUCT_DETAILS = "insert into product(name,unit,quantity,type,material) VALUES (:name,:unit,:quantity,:type, :material)";
	public final static String GET_PRODUCT_QUANTITY = "SELECT * FROM product where prod_id=:prod_id";
	public final static String UPDATE_PRODUCT_QUANTITY = "update product set quantity=:quantity where prod_id=:prod_id";
	public final static String UPDATE_PRODUCT_ALL_ATTR = "update product set name=:name,unit=:unit,quantity=:quantity,type=:type,material=:material where prod_id=:prod_id";
	public final static String DELETE_PRODUCT_ID = "delete from product where prod_id=:prod_id";
	

	@Query(value=GET_ALL_PRODUCTS,nativeQuery=true)
	List<product> getAllProducts();
	
	@Query(value=GET_ALL_REFUNDABLE_PRODUCTS,nativeQuery=true)
	List<product> getAllRefundableProducts();
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_PRODUCT_DETAILS, nativeQuery = true)
    @Transactional
	void InsertProductDetails(@Param("name") String name, @Param("unit") String unit, @Param("quantity") String quantity, @Param("type") String type, @Param("material") String material);
    
	@Query(value=GET_PRODUCT_QUANTITY,nativeQuery=true)
	List<product> getProductQuantity(@Param("prod_id") Integer prod_id);
	
	@Modifying(clearAutomatically = true)
    @Query(value = UPDATE_PRODUCT_QUANTITY, nativeQuery = true)
    @Transactional
	void UpdateProductQuantity(@Param("prod_id") Integer prod_id, @Param("quantity") String quantity);
	
	@Modifying(clearAutomatically = true)
    @Query(value = UPDATE_PRODUCT_ALL_ATTR, nativeQuery = true)
    @Transactional
	void UpdateProductAllAttr(@Param("prod_id") Integer prod_id, @Param("name") String name, @Param("unit") String unit, @Param("quantity") String quantity, @Param("type") String type, @Param("material") String material);
    
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_PRODUCT_ID, nativeQuery = true)
    @Transactional
	void deleteProductId(@Param("prod_id") Integer prod_id);
	
}
