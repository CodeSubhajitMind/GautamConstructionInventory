package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.fuel;

public interface fuel_repository extends JpaRepository<fuel, Long>{
	public final static String GET_FUEL_DETAILS_BY_TYPE = "SELECT * FROM fuel where fuel_type=:fuel_type";
	public final static String UPDATE_FUEL_QUANTITY = "update fuel set quantity=:quantity where fuel_type=:fuel_type";
	
	@Query(value=GET_FUEL_DETAILS_BY_TYPE,nativeQuery=true)
	List<fuel> getFuelDetailsByType(@Param("fuel_type") String fuel_type);
	                                             
	@Modifying
    @Query(value = UPDATE_FUEL_QUANTITY, nativeQuery = true)
    @Transactional
	void UpdateFuelQuantity(@Param("fuel_type") String fuel_type,@Param("quantity") String quantity);

	
}
