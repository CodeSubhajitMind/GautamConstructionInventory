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
	public final static String GET_ALL_LOCATIONS_BY_ID = "SELECT * FROM location where id=:id";
	public final static String INSERT_LOCATION_DETAILS = "insert into location(location_name) VALUES (:location_name)";
	public final static String UPDATE_LOCATION_ALL_ATTR = "update location set location_name=:location_name where id=:id";
	public final static String DELETE_LOCATION_ID = "delete from location where id=:id";
	
	@Query(value=GET_ALL_LOCATIONS,nativeQuery=true)
	List<location> getAllLocations();
	
	@Query(value=GET_ALL_LOCATIONS_BY_ID,nativeQuery=true)
	List<location> getAllLocationsById(@Param("id") Integer id);
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_LOCATION_DETAILS, nativeQuery = true)
    @Transactional
	void InsertLocationDetails(@Param("location_name") String location_name);
    
	@Modifying(clearAutomatically = true)
    @Query(value = UPDATE_LOCATION_ALL_ATTR, nativeQuery = true)
    @Transactional
	void UpdateLocationDetailsAllAttr(@Param("id") Integer id,@Param("location_name") String location_name);
    
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_LOCATION_ID, nativeQuery = true)
    @Transactional
	void DeleteLocationId(@Param("id") Integer id);
    
}
