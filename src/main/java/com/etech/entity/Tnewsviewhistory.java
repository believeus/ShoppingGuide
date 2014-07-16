package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tnewsviewhistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tnewsviewhistory", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "NewsViewHistoryID", nullable = false)
	public Integer getNewsViewHistoryId() {
		return this.newsViewHistoryId;
	}

	public void setNewsViewHistoryId(Integer newsViewHistoryId) {
		this.newsViewHistoryId = newsViewHistoryId;
	}

	@Column(name = "NewsID")
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@Column(name = "UserType", nullable = false)
	public Short getUserType() {
		return this.userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	@Column(name = "UserID", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "InsertTime", nullable = false, length = 19)
	public Timestamp getInsertTime() {
		return this.insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

}