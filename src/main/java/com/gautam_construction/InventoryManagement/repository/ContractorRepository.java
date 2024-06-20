package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.contractor;

public interface ContractorRepository extends JpaRepository<contractor, Long>{
	public final static String GET_ALL_CONTRACTORS = "SELECT * FROM contractor";
	public final static String GET_ALL_CONTRACTORS_BY_ID = "SELECT * FROM contractor where contractor_id=:contractor_id";
	public final static String INSERT_CONTRACTOR_DETAILS = "insert into contractor(name,dept,address) VALUES (:name,:dept,:address)";
	public final static String UPDATE_CONTRACTOR_ALL_ATTR = "update contractor set name=:name,dept=:dept,address=:address where contractor_id=:contractor_id";
	public final static String DELETE_CONTRACTOR_ID = "delete from contractor where contractor_id=:contractor_id";
	
	@Query(value=GET_ALL_CONTRACTORS,nativeQuery=true)
	List<contractor> getAllContractors();
	
	@Query(value=GET_ALL_CONTRACTORS_BY_ID,nativeQuery=true)
	List<contractor> getAllContractorsById(@Param("contractor_id") Integer contractor_id);
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_CONTRACTOR_DETAILS, nativeQuery = true)
    @Transactional
	void InsertContractorDetails(@Param("name") String name, @Param("dept") String dept, @Param("address") String address);
    
	@Modifying(clearAutomatically = true)
    @Query(value = UPDATE_CONTRACTOR_ALL_ATTR, nativeQuery = true)
    @Transactional
	void UpdateContractorDetailsAllAttr(@Param("contractor_id") Integer contractor_id, @Param("name") String name, @Param("dept") String dept, @Param("address") String address);
    
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_CONTRACTOR_ID, nativeQuery = true)
    @Transactional
	void DeleteContractorId(@Param("contractor_id") Integer contractor_id);
    
}
