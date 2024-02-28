package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.product_add_by_local_office;


public interface product_add_by_local_office_repository extends JpaRepository<product_add_by_local_office, Long>{
	public final static String GET_ALL_PRODUCT_ADD_BY_LOCAL_OFFICE = "SELECT * FROM product_add_by_local_office";
	public final static String GET_MAX_SERIAL_NUMBER = "SELECT max(serial_no) FROM product_add_by_local_office";
	public final static String INSERT_PRODUCT_ADD_BY_LOCAL_OFFICE = "insert into product_add_by_local_office(prod_id,quantity,invoice_no,invoice_date,vendor_name,vehicle_no,serial_no) VALUES (:prod_id,:quantity,:invoice_no,:invoice_date,:vendor_name,:vehicle_no,:serial_no)";
	
	@Query(value=GET_ALL_PRODUCT_ADD_BY_LOCAL_OFFICE,nativeQuery=true)
	List<product_add_by_local_office> getAllProductAddByLocalOffice();
	
	@Query(value=GET_MAX_SERIAL_NUMBER,nativeQuery=true)
	String getMaxSerialNumber();
	                                             
	@Modifying
    @Query(value = INSERT_PRODUCT_ADD_BY_LOCAL_OFFICE, nativeQuery = true)
    @Transactional
	void InsertProductAddByLocalOffice(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("invoice_no") String invoice_no,@Param("invoice_date") String invoice_date,@Param("vendor_name") String vendor_name,@Param("vehicle_no") String vehicle_no,@Param("serial_no") String serial_no);

}
