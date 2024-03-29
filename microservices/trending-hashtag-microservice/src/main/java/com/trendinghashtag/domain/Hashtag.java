package com.trendinghashtag.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micronaut.serde.annotation.Serdeable;

@Entity
@Serdeable
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

	@JsonIgnore
    @ManyToMany(mappedBy = "hashtags", fetch = FetchType.EAGER)
    private Set<Video> videos = new HashSet<>();

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Set<Video> getVideos() {
		return videos;
	}

	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}
	
	@Override
	public String toString() {
		return "Hashtag [id=" + id + ", name=" + name + "]";
	}
    
}
