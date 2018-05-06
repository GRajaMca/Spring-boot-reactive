package com.mt.reactive.DAO;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.mt.reactive.entity.GitUser;

@Repository
public interface GitUserDAO extends ReactiveMongoRepository<GitUser, Long> {

}
