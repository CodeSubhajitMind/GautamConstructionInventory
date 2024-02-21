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
	public final static String INSERT_PRODUCT_DETAILS = "insert into contractor(name,dept,address) VALUES (:name,:dept,:address)";
	
	@Query(value=GET_ALL_CONTRACTORS,nativeQuery=true)
	List<contractor> getAllContractors();
	                                             
	@Modifying
    @Query(value = INSERT_PRODUCT_DETAILS, nativeQuery = true)
    @Transactional
	void InsertContractorDetails(@Param("name") String name, @Param("dept") String dept, @Param("address") String address);
    
}
