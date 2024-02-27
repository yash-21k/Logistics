package com.wecp.logisticsmanagementandtrackingsystem.repository;


import com.wecp.logisticsmanagementandtrackingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long>{
    // extend jpa repository and add custom methods if needed
    // @Query("Select u from User u WHERE u.username= :username")
    // User findByUsername(@Param("username") String username);
    User findByUsername(String username);
}
