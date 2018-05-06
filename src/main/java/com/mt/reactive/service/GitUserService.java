package com.mt.reactive.service;

import java.util.List;

import com.mt.reactive.entity.GitUser;
import com.mt.reactive.entity.GitUserStream;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GitUserService {

	public Flux<GitUserStream> getAllUser();

	public Mono<GitUser> getUserbyId(Long Id);

	public void SaveUser(List<GitUser> gitUsers);

	public List<GitUser> getUserFromGit();

}
