package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto;
import com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto_by_product;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_contractor_dto;
import com.gautam_construction.InventoryManagement.model.product_exit_by_contractor;


public interface product_exit_by_contractor_repository extends JpaRepository<product_exit_by_contractor, Long>{
	public final static String GET_ALL_PRODUCT_EXIT_BY_CONTRACTOR = "SELECT * FROM product_exit_by_contractor";
	public final static String GET_ALL_PRODUCT_EXIT_BY_CONTRACTOR_CHNO = "SELECT new com.gautam_construction.InventoryManagement.DTO.product_exit_by_contractor_dto(pe.prod_id,p.name,p.unit,p.type,pe.quantity,pe.challan_no,pe.exit_date,pe.contractor_name,pe.receiving_person,pe.sub_admin) FROM product_exit_by_contractor pe inner join product p on pe.prod_id=p.prod_id where pe.challan_no=:challan_no";
	public final static String GET_MAX_CHALLAN_NO = "SELECT max(challan_no) FROM product_exit_by_contractor";
	public final static String INSERT_PRODUCT_EXIT_BY_CONTRACTOR = "insert into product_exit_by_contractor(prod_id,quantity,challan_no,exit_date,contractor_name,receiving_person,bill,sub_admin) VALUES (:prod_id,:quantity,:challan_no,:exit_date,:contractor_name,:receiving_person,:bill,:sub_admin)";
	public final static String GET_BRIEF_PRODUCT_EXIT_BY_CONTRACTOR = "SELECT new com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto(challan_no,challan_no,COUNT(prod_id) as total_prod,SUM(quantity) as total_quantity) FROM product_exit_by_contractor GROUP BY challan_no";
	
	@Query(value=GET_BRIEF_PRODUCT_EXIT_BY_CONTRACTOR)
	List<brief_product_challan_dto> getBriefProductExitByContractor();
	
	@Query(value=GET_ALL_PRODUCT_EXIT_BY_CONTRACTOR,nativeQuery=true)
	List<product_exit_by_contractor> getAllProductExitByContractor();
	
	@Query(value=GET_ALL_PRODUCT_EXIT_BY_CONTRACTOR_CHNO)
	List<product_exit_by_contractor_dto> getAllProductExitByContractorChNo(@Param("challan_no") String challan_no);
	
	@Query(value=GET_MAX_CHALLAN_NO,nativeQuery=true)
	String getMaxChallanNo();
	                                             
	@Modifying(clearAutomatically = true)
    @Query(value = INSERT_PRODUCT_EXIT_BY_CONTRACTOR, nativeQuery = true)
    @Transactional
	void InsertProductExitByContractor(@Param("prod_id") Integer prod_id,@Param("quantity") String quantity,@Param("challan_no") String challan_no,@Param("exit_date") String exit_date,@Param("contractor_name") String contractor_name,@Param("receiving_person") String receiving_person,@Param("bill") String bill,@Param("sub_admin") String sub_admin);

	public final static String DELETE_ALL_PRODUCT_EXIT_BY_CONTRACTOR = "delete from product_exit_by_contractor where challan_no=:challan_no";
	@Modifying(clearAutomatically = true)
    @Query(value = DELETE_ALL_PRODUCT_EXIT_BY_CONTRACTOR, nativeQuery = true)
    @Transactional
	void DeleteAllProductExitByContractor(@Param("challan_no") String challan_no);
	
	public final static String GET_PRODUCT_FILTER_BY_SEARCH = "select new com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto(pe.prod_id,p.name,p.type,p.unit,pe.quantity,pe.challan_no,pe.exit_date,'Exit By Sub-Contractor') FROM product_exit_by_contractor pe inner join product p on pe.prod_id=p.prod_id where (:prod_id IS NULL OR :prod_id = '' OR p.prod_id=:prod_id) and (:date IS NULL OR :date = '' OR pe.exit_date=:date)";
	@Query(value=GET_PRODUCT_FILTER_BY_SEARCH)
	List<filter_product_search_dto> getProductFilterBySearch(@Param("prod_id") String prod_id,@Param("date") String date);
	
	public final static String GET_PRODUCT_FILTER_SEARCH_BY_PRODUCT = "select new com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto_by_product(pe.prod_id,p.name,p.type,p.unit,pe.quantity,pe.challan_no,pe.exit_date,'Exit By Sub-Contractor') FROM product_exit_by_contractor pe inner join product p on pe.prod_id=p.prod_id where (:prod_id IS NULL OR :prod_id = '' OR p.prod_id=:prod_id) and (COALESCE(:s_date, '') = '' OR STR_TO_DATE(pe.exit_date, '%Y-%m-%d') >= STR_TO_DATE(:s_date, '%Y-%m-%d'))"
			+ "  AND (COALESCE(:e_date, '') = '' OR STR_TO_DATE(pe.exit_date, '%Y-%m-%d') <= STR_TO_DATE(:e_date, '%Y-%m-%d')) ORDER BY pe.exit_date";
	@Query(value=GET_PRODUCT_FILTER_SEARCH_BY_PRODUCT)
	List<filter_product_search_dto_by_product> getProductFilterSearchByProduct(@Param("prod_id") String prod_id,@Param("s_date") String s_date,@Param("e_date") String e_date);
	
}
