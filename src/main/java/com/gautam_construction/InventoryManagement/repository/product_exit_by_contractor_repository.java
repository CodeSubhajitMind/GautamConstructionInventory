package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_contractor_dto;
import com.gautam_construction.InventoryManagement.model.product_exit_by_contractor;


public interface product_exit_by_contractor_repository extends JpaRepository<product_exit_by_contractor, Long>{
	public final static String GET_ALL_PRODUCT_EXIT_BY_CONTRACTOR = "SELECT * FROM product_exit_by_contractor";
	public final static String GET_ALL_PRODUCT_EXIT_BY_CONTRACTOR_CHNO = "SELECT new com.gautam_construction.InventoryManagement.DTO.product_exit_by_contractor_dto(pe.prod_id,p.name,pe.quantity,pe.challan_no,pe.exit_date,pe.contractor_name,pe.receiving_person) FROM product_exit_by_contractor pe inner join product p on pe.prod_id=p.prod_id where pe.challan_no=:challan_no";
	public final static String GET_MAX_CHALLAN_NO = "SELECT max(challan_no) FROM product_exit_by_contractor";
	public final static String INSERT_PRODUCT_EXIT_BY_CONTRACTOR = "insert into product_exit_by_contractor(prod_id,quantity,challan_no,exit_date,contractor_name,receiving_person,bill) VALUES (:prod_id,:quantity,:challan_no,:exit_date,:contractor_name,:receiving_person,:bill)";
	public final static String GET_BRIEF_PRODUCT_EXIT_BY_CONTRACTOR = "SELECT new com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto(challan_no,COUNT(prod_id) as total_prod,SUM(quantity) as total_quantity) FROM product_exit_by_contractor GROUP BY challan_no";
	
	@Query(value=GET_BRIEF_PRODUCT_EXIT_BY_CONTRACTOR)
	List<brief_product_challan_dto> getBriefProductExitByContractor();
	
	@Query(value=GET_ALL_PRODUCT_EXIT_BY_CONTRACTOR,nativeQuery=true)
	List<product_exit_by_contractor> getAllProductExitByContractor();
	
	@Query(value=GET_ALL_PRODUCT_EXIT_BY_CONTRACTOR_CHNO)
	List<product_exit_by_contractor_dto> getAllProductExitByContractorChNo(@Param("challan_no") String challan_no);
	
	@Query(value=GET_MAX_CHALLAN_NO,nativeQuery=true)
	String getMaxChallanNo();
	                                             
	@Modifying
    @Query(value = INSERT_PRODUCT_EXIT_BY_CONTRACTOR, nativeQuery = true)
    @Transactional
	void InsertProductExitByContractor(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("challan_no") String challan_no,@Param("exit_date") String exit_date,@Param("contractor_name") String contractor_name,@Param("receiving_person") String receiving_person,@Param("bill") String bill);

}
