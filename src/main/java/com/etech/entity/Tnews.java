package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tnews entity. @author MyEclipse Persistence Tools
 */

public class Tnews implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private String title;
	private String content;
	private String from;
	private String originalUrl;
	private Timestamp addTime;
	private Integer viewCount;

	// Constructors

	/** default constructor */
	public Tnews() {
	}

	/** minimal constructor */
	public Tnews(String title, String content, String originalUrl,
			Timestamp addTime, Integer viewCount) {
		this.title = title;
		this.content = content;
		this.originalUrl = originalUrl;
		this.addTime = addTime;
		this.viewCount = viewCount;
	}

	/** full constructor */
	public Tnews(String title, String content, String from, String originalUrl,
			Timestamp addTime, Integer viewCount) {
		this.title = title;
		this.content = content;
		this.from = from;
		this.originalUrl = originalUrl;
		this.addTime = addTime;
		this.viewCount = viewCount;
	}

	// Property accessors

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
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

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getOriginalUrl() {
		return this.originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

}