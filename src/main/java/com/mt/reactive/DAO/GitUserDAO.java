package com.mt.reactive.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mt.reactive.entity.GitUser;

@Repository
public interface GitUserDAO extends PagingAndSortingRepository<GitUser, Long> {

	@Query(value = "select max(user_id) from git_user", nativeQuery = true)
	Long getMaxUserId();
}
