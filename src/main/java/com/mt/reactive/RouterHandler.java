package com.mt.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mt.reactive.entity.GitUser;
import com.mt.reactive.service.GitUserService;

import reactor.core.publisher.Mono;

@Component
public class RouterHandler {

	private final GitUserService gitUserService;

	@Autowired
	public RouterHandler(GitUserService gitUserService) {
		super();
		this.gitUserService = gitUserService;
	}

	public Mono<ServerResponse> getAllUser(ServerRequest serverRequest) {
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(gitUserService.getAllUser(),
				GitUser.class);
	}

	public Mono<ServerResponse> loadData(ServerRequest serverRequest) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(gitUserService.saveAllUser(gitUserService.getUserFromGit()), String.class);
	}

}
