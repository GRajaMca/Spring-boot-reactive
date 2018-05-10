package com.mt.reactive;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mt.reactive.service.GitUserService;

public class GitUserServiceImplTests extends ApplicationTests {

	@Autowired
	private GitUserService gitUserService;

	@Test
	public void getUserFromGitTest() {
		long size = gitUserService.getUserFromGit().size();
		assertNotEquals(0, size);
		assertEquals(1500, size);
		assertNotNull(size);
	}

}
