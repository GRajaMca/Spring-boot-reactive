package com.mt.reactive.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class GitUserStream implements Serializable {

	private static final long serialVersionUID = 1L;
	private GitUser gitUser;

	public GitUserStream GitUser(GitUser gitUser) {
		this.gitUser = gitUser;
		return this;
	}

	public static GitUserStream getInstance() {
		return new GitUserStream();
	}

}
