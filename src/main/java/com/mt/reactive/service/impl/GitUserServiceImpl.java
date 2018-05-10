package com.mt.reactive.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mt.reactive.DAO.GitUserDAO;
import com.mt.reactive.entity.GitUser;
import com.mt.reactive.service.GitUserService;
import com.mt.reactive.util.SystemInformationUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SuppressWarnings({ "rawtypes" })
@Service
public class GitUserServiceImpl implements GitUserService {

	private final GitUserDAO gitUserDAO;

	private final RestTemplate restTemplate;

	@Autowired
	public GitUserServiceImpl(GitUserDAO gitUserDAO, RestTemplate restTemplate) {
		super();
		this.gitUserDAO = gitUserDAO;
		this.restTemplate = restTemplate;
	}

	@Override
	public Flux<GitUser> getAllUser() {
		return Flux.fromIterable(gitUserDAO.findAll()).delayElements(Duration.ofSeconds(1));
	}

	@Override
	public List<GitUser> getUserFromGit() {
		ParameterizedTypeReference<List<GitUser>> responseType = new ParameterizedTypeReference<List<GitUser>>() {
		};

		long Id = 0;
		if (gitUserDAO.getMaxUserId() != null) {
			Id = gitUserDAO.getMaxUserId();
		}

		RequestEntity requestEntity = null;
		List<GitUser> list = new ArrayList<>();
		for (int i = 0; i < 500; i++) {
			try {
				requestEntity = RequestEntity
						.get(new URI(SystemInformationUtil.GIT_URL + "?since=" + Id + SystemInformationUtil.OAUTH_URL))
						.accept(MediaType.APPLICATION_JSON).build();
				list.addAll(restTemplate.exchange(requestEntity, responseType).getBody());
				Id = list.get(list.size() - 1).getUserId();

			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public Mono<String> saveAllUser(List<GitUser> gitUser) {

		gitUser.stream().forEach(user -> {
			gitUserDAO.save(user);
		});

		return Mono.just(gitUser.size() + " --> data are loaded from GitHub API to Local DataBase");
	}

	@Override
	public Optional<GitUser> getUserbyId(Long Id) {

		return gitUserDAO.findById(Id);

	}

}
