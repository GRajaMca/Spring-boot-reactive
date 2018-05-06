package com.mt.reactive.service.impl;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mt.reactive.DAO.GitUserDAO;
import com.mt.reactive.entity.GitUser;
import com.mt.reactive.entity.GitUserStream;
import com.mt.reactive.service.GitUserService;
import com.mt.reactive.util.SystemInformationUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@SuppressWarnings("unchecked")
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
	public Flux<GitUserStream> getAllUser() {
		return gitUserDAO.findAll().flatMap(gitUser -> {
			Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
			Flux<GitUserStream> gitUserFlux = Flux
					.fromStream(Stream.generate(() -> GitUserStream.getInstance().GitUser(gitUser)));
			return Flux.zip(interval, gitUserFlux).map(Tuple2::getT2);
		});
	}

	@Override
	public Mono<GitUser> getUserbyId(Long Id) {
		return gitUserDAO.findById(Id);
	}

	@Override
	public void SaveUser(List<GitUser> gitUser) {
		gitUserDAO.deleteAll();
		gitUser.stream().forEach(user -> {
			gitUserDAO.save(user).subscribe(System.out::println);
		});

	}

	@Override
	public List<GitUser> getUserFromGit() {
		List<GitUser> list = restTemplate.getForObject(SystemInformationUtil.GIT_URL + "?since=100", List.class);
		list.addAll(restTemplate.getForObject(SystemInformationUtil.GIT_URL + "?since=131", List.class));
		return list;
	}

}
