package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tfavoritegroup entity. @author MyEclipse Persistence Tools
 */

public class Tfavoritegroup implements java.io.Serializable {

	// Fields

	private Integer favoriteGroupId;
	private Integer phoneUserId;
	private Short groupType;
	private String favoriteGroupName;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tfavoritegroup() {
	}

	/** full constructor */
	public Tfavoritegroup(Integer phoneUserId, Short groupType,
			String favoriteGroupName, Timestamp addTime) {
		this.phoneUserId = phoneUserId;
		this.groupType = groupType;
		this.favoriteGroupName = favoriteGroupName;
		this.addTime = addTime;
	}

	// Property accessors

	public Integer getFavoriteGroupId() {
		return this.favoriteGroupId;
	}

	public void setFavoriteGroupId(Integer favoriteGroupId) {
		this.favoriteGroupId = favoriteGroupId;
	}

	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	public Short getGroupType() {
		return this.groupType;
	}

	public void setGroupType(Short groupType) {
		this.groupType = groupType;
	}

	public String getFavoriteGroupName() {
		return this.favoriteGroupName;
	}

	public void setFavoriteGroupName(String favoriteGroupName) {
		this.favoriteGroupName = favoriteGroupName;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}