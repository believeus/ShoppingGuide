package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tactivity entity. @author MyEclipse Persistence Tools
 */

public class Tactivity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer range;
	private Integer hostId;
	private Timestamp startTime;
	private Timestamp endingTime;
	private String title;
	private String content;
	private Timestamp publishTime;
	private Integer publishUserId;
	private String photosUrl;
	private Integer state;

	// Constructors

	/** default constructor */
	public Tactivity() {
	}

	/** minimal constructor */
	public Tactivity(Integer range, Integer hostId, Timestamp startTime,
			Timestamp endingTime, String title, String content,
			Timestamp publishTime, Integer publishUserId, Integer state) {
		this.range = range;
		this.hostId = hostId;
		this.startTime = startTime;
		this.endingTime = endingTime;
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
		this.publishUserId = publishUserId;
		this.state = state;
	}

	/** full constructor */
	public Tactivity(Integer range, Integer hostId, Timestamp startTime,
			Timestamp endingTime, String title, String content,
			Timestamp publishTime, Integer publishUserId, String photosUrl,
			Integer state) {
		this.range = range;
		this.hostId = hostId;
		this.startTime = startTime;
		this.endingTime = endingTime;
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
		this.publishUserId = publishUserId;
		this.photosUrl = photosUrl;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRange() {
		return this.range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

	public Integer getHostId() {
		return this.hostId;
	}

	public void setHostId(Integer hostId) {
		this.hostId = hostId;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndingTime() {
		return this.endingTime;
	}

	public void setEndingTime(Timestamp endingTime) {
		this.endingTime = endingTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getPublishUserId() {
		return this.publishUserId;
	}

	public void setPublishUserId(Integer publishUserId) {
		this.publishUserId = publishUserId;
	}

	public String getPhotosUrl() {
		return this.photosUrl;
	}

	public void setPhotosUrl(String photosUrl) {
		this.photosUrl = photosUrl;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}