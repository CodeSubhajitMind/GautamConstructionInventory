package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.fuel_entry;

public interface fuel_entry_repository extends JpaRepository<fuel_entry, Long>{
	public final static String GET_ALL_FUEL_ENTRY = "SELECT * FROM fuel_entry";
	public final static String INSERT_FUEL_ADD = "insert into fuel_entry(fuel_type,quantity,invoice_no,invoice_date,vendor_name,vehicle_no) VALUES (:fuel_type,:quantity,:invoice_no,:invoice_date,:vendor_name,:vehicle_no)";
	
	@Query(value=GET_ALL_FUEL_ENTRY,nativeQuery=true)
	List<fuel_entry> getAllFuelEntry();
	                                             
	@Modifying
    @Query(value = INSERT_FUEL_ADD, nativeQuery = true)
    @Transactional
	void InsertFuelAdd(@Param("fuel_type") String fuel_type,@Param("quantity") String quantity,@Param("invoice_no") String invoice_no,@Param("invoice_date") String invoice_date,@Param("vendor_name") String vendor_name,@Param("vehicle_no") String vehicle_no);

}