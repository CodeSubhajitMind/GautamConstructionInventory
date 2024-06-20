package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.vehicle;

public interface VehicleRepository extends JpaRepository<vehicle, Long>{
	public final static String GET_ALL_VEHICLES = "SELECT * FROM vehicle";
	public final static String GET_ALL_VEHICLES_BY_ID = "SELECT * FROM vehicle where id=:id";
	public final static String INSERT_VEHICLE_DETAILS = "insert into vehicle(vehicle_no,driver_lisence_no,tyre_no,battery_no,pollution_from_date,pollution_expiry_date,fitness_from_date,fitness_end_date,insurance_from_date,insurance_end_date,last_servicing_date,vehicle_type) VALUES (:vehicle_no,:driver_lisence_no,:tyre_no,:battery_no,:pollution_from_date,:pollution_expiry_date,:fitness_from_date,:fitness_end_date,:insurance_from_date,:insurance_end_date,:last_servicing_date,:vehicle_type)";
	public final static String UPDATE_VEHICLE_ALL_ATTR = "update vehicle set vehicle_no=:vehicle_no,driver_lisence_no=:driver_lisence_no,tyre_no=:tyre_no,battery_no=:battery_no,pollution_from_date=:pollution_from_date,pollution_expiry_date=:pollution_expiry_date,fitness_from_date=:fitness_from_date,fitness_end_date=:fitness_end_date,insurance_from_date=:insurance_from_date,insurance_end_date=:insurance_end_date,last_servicing_date=:last_servicing_date,vehicle_type=:vehicle_type where id=:id";
	public final static String DELETE_VEHICLE_ID = "delete from vehicle where id=:id";
	public final static String GET_DISTINCT_VEHICLES = "SELECT DISTINCT vehicle_type FROM vehicle";
	
	@Query(value=GET_ALL_VEHICLES,nativeQuery=true)
	List<vehicle> getAllVehicles();
	
	@Query(value=GET_ALL_VEHICLES_BY_ID,nativeQuery=true)
	List<vehicle> getAllVehiclesById(@Param("id") Integer id);
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_VEHICLE_DETAILS, nativeQuery = true)
    @Transactional
	void InsertVehicleDetails(@Param("vehicle_no") String vehicle_no, @Param("driver_lisence_no") String driver_lisence_no, @Param("tyre_no") String tyre_no, @Param("battery_no") String battery_no, @Param("pollution_from_date") String pollution_from_date, @Param("pollution_expiry_date") String pollution_expiry_date, @Param("fitness_from_date") String fitness_from_date, @Param("fitness_end_date") String fitness_end_date, @Param("insurance_from_date") String insurance_from_date, @Param("insurance_end_date") String insurance_end_date, @Param("last_servicing_date") String last_servicing_date, @Param("vehicle_type") String vehicle_type);
    
	@Modifying(clearAutomatically = true)
    @Query(value = UPDATE_VEHICLE_ALL_ATTR, nativeQuery = true)
    @Transactional
	void UpdateVehicleDetailsAllAttr(@Param("id") Integer id, @Param("vehicle_no") String vehicle_no, @Param("driver_lisence_no") String driver_lisence_no, @Param("tyre_no") String tyre_no, @Param("battery_no") String battery_no, @Param("pollution_from_date") String pollution_from_date, @Param("pollution_expiry_date") String pollution_expiry_date, @Param("fitness_from_date") String fitness_from_date, @Param("fitness_end_date") String fitness_end_date, @Param("insurance_from_date") String insurance_from_date, @Param("insurance_end_date") String insurance_end_date, @Param("last_servicing_date") String last_servicing_date, @Param("vehicle_type") String vehicle_type);
    
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_VEHICLE_ID, nativeQuery = true)
    @Transactional
	void DeleteVehicleId(@Param("id") Integer id);
	
	@Query(value=GET_DISTINCT_VEHICLES,nativeQuery=true)
	List<String> getDistinctVehicleTypes();
    
}

