package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tnewsviewhistory entity. @author MyEclipse Persistence Tools
 */

public class Tnewsviewhistory implements java.io.Serializable {

	// Fields

	private Integer newsViewHistoryId;
	private Integer newsId;
	private Short userType;
	private Integer userId;
	private Timestamp insertTime;

	// Constructors

	/** default constructor */
	public Tnewsviewhistory() {
	}

	/** minimal constructor */
	public Tnewsviewhistory(Short userType, Integer userId, Timestamp insertTime) {
		this.userType = userType;
		this.userId = userId;
		this.insertTime = insertTime;
	}

	/** full constructor */
	public Tnewsviewhistory(Integer newsId, Short userType, Integer userId,
			Timestamp insertTime) {
		this.newsId = newsId;
		this.userType = userType;
		this.userId = userId;
		this.insertTime = insertTime;
	}

	// Property accessors

	public Integer getNewsViewHistoryId() {
		return this.newsViewHistoryId;
	}

	public void setNewsViewHistoryId(Integer newsViewHistoryId) {
		this.newsViewHistoryId = newsViewHistoryId;
	}

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Short getUserType() {
		return this.userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getInsertTime() {
		return this.insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

}