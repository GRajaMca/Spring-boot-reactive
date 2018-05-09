package com.mt.reactive.service;

import java.util.List;
import java.util.Optional;

import com.mt.reactive.entity.GitUser;

import reactor.core.publisher.Flux;

public interface GitUserService {

	public Flux<GitUser> getAllUser();

	public Optional<GitUser> getUserbyId(Long Id);

	public List<GitUser> getUserFromGit();

	public Long saveAllUser(List<GitUser> list);
}
