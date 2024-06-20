package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.fuel_exit;

public interface fuel_exit_repository extends JpaRepository<fuel_exit, Long>{
	public final static String GET_ALL_FUEL_EXIT = "SELECT * FROM fuel_exit";
	public final static String GET_ALL_FUEL_EXIT_BY_ID = "SELECT * FROM fuel_exit where id=:id";
	public final static String INSERT_FUEL_EXIT = "insert into fuel_exit(exit_type,fuel_type,vehicle_no,opening_reading,mileage,fuel_issue,issue_date,vehicle_type) VALUES (:exit_type,:fuel_type,:vehicle_no,:opening_reading,:mileage,:fuel_issue,:issue_date,:vehicle_type)";
	public final static String UPDATE_FUEL_EXIT_ALL_ATTR = "update fuel_exit set exit_type=:exit_type,fuel_type=:fuel_type,vehicle_no=:vehicle_no,opening_reading=:opening_reading,mileage=:mileage,fuel_issue=:fuel_issue,issue_date=:issue_date,vehicle_type=:vehicle_type where id=:id";
	public final static String DELETE_FUEL_EXIT_ID = "delete from fuel_exit where id=:id";
	
	@Query(value=GET_ALL_FUEL_EXIT,nativeQuery=true)
	List<fuel_exit> getAllFuelExit();
	
	@Query(value=GET_ALL_FUEL_EXIT_BY_ID,nativeQuery=true)
	List<fuel_exit> getAllFuelExitById(@Param("id") Integer id);
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_FUEL_EXIT, nativeQuery = true)
    @Transactional
	void InsertFuelExit(@Param("exit_type") String exit_type,@Param("fuel_type") String fuel_type,@Param("vehicle_no") String vehicle_no,@Param("opening_reading") String opening_reading,@Param("mileage") String mileage,@Param("fuel_issue") String fuel_issue,@Param("issue_date") String issue_date, @Param("vehicle_type") String vehicle_type);

	@Modifying(clearAutomatically = true)
    @Query(value = UPDATE_FUEL_EXIT_ALL_ATTR, nativeQuery = true)
    @Transactional
	void UpdateFuelExitAllAttr(@Param("id") Integer id, @Param("exit_type") String exit_type, @Param("fuel_type") String fuel_type, @Param("vehicle_no") String vehicle_no, @Param("opening_reading") String opening_reading, @Param("mileage") String mileage, @Param("fuel_issue") String fuel_issue, @Param("issue_date") String issue_date, @Param("vehicle_type") String vehicle_type);
    
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_FUEL_EXIT_ID, nativeQuery = true)
    @Transactional
	void deleteFuelExitId(@Param("id") Integer id);
	
}
