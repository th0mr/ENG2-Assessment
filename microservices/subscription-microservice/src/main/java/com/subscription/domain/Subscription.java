package com.subscription.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micronaut.serde.annotation.Serdeable;

@Entity
@Serdeable
public class Subscription {

	// This is the id of the subscription
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // The user that is subscribing
    private Long userId;
    
	// The hashtag they have subscribed to
    private Long hashtagId;
    
    // These are the videos that we build the top ten from
    @JsonIgnore
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Long> videosNotSeen = new HashSet<Long>();

    @JsonIgnore
    @ElementCollection(fetch = FetchType.EAGER)
	// The videos that have been watched since that user subscribed
    private Set<Long> videosSeenSinceSub = new HashSet<Long>();
    
    @JsonIgnore
    @ElementCollection(fetch = FetchType.EAGER)
    // The videos that have been posted since the user has subscribed to that tag
    private Set<Long> videosPostedSinceSub = new HashSet<Long>();
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getHashtagId() {
		return hashtagId;
	}

	public void setHashtagId(Long hashtagId) {
		this.hashtagId = hashtagId;
	}

    public Set<Long> getVideosNotSeen() {
		return videosNotSeen;
	}

	public void setVideosNotSeen(Set<Long> videosNotSeen) {
		this.videosNotSeen = videosNotSeen;
	}

	public Set<Long> getVideosSeenSinceSub() {
		return videosSeenSinceSub;
	}

	public void setVideosSeenSinceSub(Set<Long> videosSeenSinceSub) {
		this.videosSeenSinceSub = videosSeenSinceSub;
	}

	public Set<Long> getVideosPostedSinceSub() {
		return videosPostedSinceSub;
	}

	public void setVideosPostedSinceSub(Set<Long> videosPostedSinceSub) {
		this.videosPostedSinceSub = videosPostedSinceSub;
	}
	
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", userId=" + userId + ", hashtagId=" + hashtagId + "]";
	}
}
