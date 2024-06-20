package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.staff;

public interface StaffRepository extends JpaRepository<staff, Long>{
	public final static String GET_ALL_STAFFS = "SELECT * FROM staff";
	public final static String GET_ALL_STAFFS_BY_ID = "SELECT * FROM staff where id=:id";
	public final static String GET_ALL_STAFFS_BY_EMPCODE = "SELECT * FROM staff where emp_code=:emp_code";
	public final static String INSERT_STAFF_DETAILS = "insert into staff(emp_code,name,designation) VALUES (:emp_code,:name,:designation)";
	public final static String UPDATE_STAFF_ALL_ATTR = "update staff set emp_code=:emp_code,name=:name,designation=:designation where id=:id";
	public final static String DELETE_STAFF_ID = "delete from staff where id=:id";
	
	@Query(value=GET_ALL_STAFFS,nativeQuery=true)
	List<staff> getAllStaffs();
	
	@Query(value=GET_ALL_STAFFS_BY_ID,nativeQuery=true)
	List<staff> getAllStaffsById(@Param("id") Integer id);
	
	@Query(value=GET_ALL_STAFFS_BY_EMPCODE,nativeQuery=true)
	List<staff> getAllStaffsByEmpCode(@Param("emp_code") String emp_code);
	 
	
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_STAFF_DETAILS, nativeQuery = true)
    @Transactional
	void InsertStaffDetails(@Param("emp_code") String emp_code, @Param("name") String name, @Param("designation") String designation);
    
	@Modifying(clearAutomatically = true)
    @Query(value = UPDATE_STAFF_ALL_ATTR, nativeQuery = true)
    @Transactional
	void UpdateStaffDetailsAllAttr(@Param("id") Integer id, @Param("emp_code") String emp_code, @Param("name") String name, @Param("designation") String designation);
    
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_STAFF_ID, nativeQuery = true)
    @Transactional
	void DeleteStaffId(@Param("id") Integer id);
    
}
