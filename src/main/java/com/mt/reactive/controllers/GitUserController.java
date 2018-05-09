package com.mt.reactive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.reactive.entity.GitUser;
import com.mt.reactive.service.GitUserService;

import reactor.core.publisher.Flux;

@RestController
public class GitUserController {

	private GitUserService gitUserService;

	@Autowired
	public GitUserController(GitUserService gitUserService) {
		super();
		this.gitUserService = gitUserService;
	}

	@GetMapping(value = "/getUsers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<GitUser> getUsers() {
		return gitUserService.getAllUser();
	}

	@GetMapping(value = "/dataLoad")
	public String loadData() {
		long size = gitUserService.saveAllUser(gitUserService.getUserFromGit());
		return size + " --> data are loaded from GitHub API to Local DataBase";

	}

}
