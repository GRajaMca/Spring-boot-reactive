package com.mt.reactive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.reactive.entity.GitUser;
import com.mt.reactive.entity.GitUserStream;
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

	@GetMapping("/getUsersFromGit")
	public List<GitUser> getUserFromGit() {
		List<GitUser> list = gitUserService.getUserFromGit();
		return list;
	}

	@GetMapping(value = "/getUsers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<GitUserStream> getUsers() {
		return gitUserService.getAllUser();
	}

}
