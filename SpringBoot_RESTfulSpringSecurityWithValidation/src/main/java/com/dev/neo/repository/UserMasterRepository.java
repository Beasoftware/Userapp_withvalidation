package com.dev.neo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.neo.entity.UserMaster;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Integer> {
	@Query(value = "SELECT * FROM usermaster_tbl um WHERE " +
            "LOWER(um.firstname) LIKE LOWER(CONCAT('%',:query, '%')) OR " +
            "LOWER(um.lastname) LIKE LOWER(CONCAT('%',:query, '%')) OR " +
            "LOWER(um.emaiid) LIKE LOWER(CONCAT('%',:query, '%'))",
            nativeQuery = true)
    List<UserMaster> searchUserMaster(@Param("query") String query);
}
