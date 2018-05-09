package com.mt.reactive.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GitUserStream implements Serializable {

	private static final long serialVersionUID = 1L;
	private GitUser gitUser;

	private List<GitUser> gitUsers;

}
