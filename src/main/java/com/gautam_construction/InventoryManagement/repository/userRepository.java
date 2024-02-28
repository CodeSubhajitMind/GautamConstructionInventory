package com.gautam_construction.InventoryManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gautam_construction.InventoryManagement.model.users;


public interface userRepository extends JpaRepository<users, Long>{
	public final static String GET_USER_CREDENTIALS = "SELECT * FROM users u WHERE u.user_id = :userid";
	public final static String INSERT_USER_CREDENTIALS = "insert into users(user_id,password,name,user_type,datetime) VALUES (:user_id,:password,:name,:office_type,:datetime)";
	public final static String FIND_BY_USER_ID = "SELECT * FROM users u WHERE u.user_id = :userid LIMIT 1";
	
	@Query(value=GET_USER_CREDENTIALS,nativeQuery=true)
	List<users> getUserCredentiaLs(@Param("userid") Integer userid);
	                                             
	@Modifying
    @Query(value = INSERT_USER_CREDENTIALS, nativeQuery = true)
    @Transactional
	void registerOfficeDetails(@Param("user_id") Integer user_id, @Param("password") String password, @Param("name") String name, @Param("office_type") String office_type, @Param("datetime") String datetime);
    
	@Query(value=FIND_BY_USER_ID,nativeQuery=true)
	 users gettingUserId(@Param("userid") Integer userid);
		

	
	//@Query(value=FIND_BY_USER_ID,nativeQuery=true)
	//user findByUserid(@Param("userid") Integer userId);
}
