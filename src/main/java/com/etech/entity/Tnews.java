package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tnews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tnews", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "NewsID", nullable = false)
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@Column(name = "Title", nullable = false, length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "Content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "From", length = 100)
	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Column(name = "OriginalUrl", nullable = false, length = 100)
	public String getOriginalUrl() {
		return this.originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	@Column(name = "AddTime", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "ViewCount", nullable = false)
	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

}