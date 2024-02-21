package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.location;


public interface LocationRepository extends JpaRepository<location, Long>{
	public final static String GET_ALL_LOCATIONS = "SELECT * FROM location";
	public final static String INSERT_LOCATION_DETAILS = "insert into location(location_name) VALUES (:location_name)";
	
	@Query(value=GET_ALL_LOCATIONS,nativeQuery=true)
	List<location> getAllLocations();
	                                             
	@Modifying
    @Query(value = INSERT_LOCATION_DETAILS, nativeQuery = true)
    @Transactional
	void InsertLocationDetails(@Param("location_name") String location_name);
    
}
