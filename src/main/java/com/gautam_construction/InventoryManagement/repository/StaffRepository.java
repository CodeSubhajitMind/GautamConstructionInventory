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
	public final static String INSERT_STAFF_DETAILS = "insert into staff(emp_code,name,designation) VALUES (:emp_code,:name,:designation)";
	
	@Query(value=GET_ALL_STAFFS,nativeQuery=true)
	List<staff> getAllStaffs();
	                                             
	@Modifying
    @Query(value = INSERT_STAFF_DETAILS, nativeQuery = true)
    @Transactional
	void InsertStaffDetails(@Param("emp_code") String emp_code, @Param("name") String name, @Param("designation") String designation);
    
}
