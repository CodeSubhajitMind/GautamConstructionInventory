package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.codec.language.bm.Lang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.user_roles;



public interface user_roles_repository extends JpaRepository<user_roles, Lang>{
	@Query(value = "SELECT * FROM user_roles", nativeQuery = true)
    List<user_roles> allRoles(); 
    
    @Query(value = "select  urm.role_name as role_name_ from  user_roles rl INNER JOIN user_role_master urm  on rl.role_id=urm.role_id where rl.user_id=?", nativeQuery = true)
    List<String> getUserRoles(String user_id);
    
    @Modifying(clearAutomatically = true)
    @Query(value= "insert into user_roles(user_id,role_id) values(:user_id,:role_id)", nativeQuery = true)
    @Transactional
    void regsiterNewUserRole(@Param("user_id") String user_id,@Param("role_id") Integer role_id);
    
    @Modifying(clearAutomatically = true)
    @Query(value= "delete from user_roles where user_id = :user_id", nativeQuery = true)
    @Transactional
    void deleteUserRole(@Param("user_id") String user_id);
}
