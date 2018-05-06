package com.mt.reactive.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document
public class GitUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	@Id
	@JsonProperty("id")
	private Long userId;
	@JsonProperty("avatar_url")
	private String avatarUrl;
	@JsonProperty("gravatar_id")
	private String gravatarId;
	@JsonProperty("url")
	private String url;
	@JsonProperty("html_url")
	private String htmlUrl;
	@JsonProperty("followers_url")
	private String followersUrl;
	@JsonProperty("following_url")
	private String followingUrl;
	@JsonProperty("gists_url")
	private String gistsUrl;
	@JsonProperty("starred_url")
	private String starredUrl;
	@JsonProperty("subscriptions_url")
	private String subscriptionsUrl;
	@JsonProperty("organizations_url")
	private String organizationsUrl;
	@JsonProperty("repos_url")
	private String reposUrl;
	@JsonProperty("events_url")
	private String eventsUrl;
	@JsonProperty("received_events_url")
	private String receivedEventsUrl;
	@JsonProperty("type")
	private String type;
	@JsonProperty("site_admin")
	private boolean siteAdmin;

	public static GitUser getInstance() {
		return new GitUser();
	}

	public GitUser Login(String login) {
		this.login = login;
		return this;
	}

	public GitUser UserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public GitUser AvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
		return this;
	}

	public GitUser GravatarId(String gravatarId) {
		this.gravatarId = gravatarId;
		return this;
	}

	public GitUser Url(String url) {
		this.url = url;
		return this;
	}

	public GitUser HtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
		return this;
	}

	public GitUser FollowersUrl(String followersUrl) {
		this.followersUrl = followersUrl;
		return this;
	}

	public GitUser FollowingUrl(String followingUrl) {
		this.followingUrl = followingUrl;
		return this;
	}

	public GitUser GistsUrl(String gistsUrl) {
		this.gistsUrl = gistsUrl;
		return this;
	}

	public GitUser StarredUrl(String starredUrl) {
		this.starredUrl = starredUrl;
		return this;
	}

	public GitUser SubscriptionsUrl(String subscriptionsUrl) {
		this.subscriptionsUrl = subscriptionsUrl;
		return this;
	}

	public GitUser OrganizationsUrl(String organizationsUrl) {
		this.organizationsUrl = organizationsUrl;
		return this;
	}

	public GitUser ReposUrl(String reposUrl) {
		this.reposUrl = reposUrl;
		return this;
	}

	public GitUser EventsUrl(String eventsUrl) {
		this.eventsUrl = eventsUrl;
		return this;
	}

	public GitUser ReceivedEventsUrl(String receivedEventsUrl) {
		this.receivedEventsUrl = receivedEventsUrl;
		return this;
	}

	public GitUser Type(String type) {
		this.type = type;
		return this;
	}

	public GitUser SiteAdmin(boolean siteAdmin) {
		this.siteAdmin = siteAdmin;
		return this;
	}

}
