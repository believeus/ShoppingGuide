package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tfavoritegroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tfavoritegroup", catalog = "dbshop")
public class Tfavoritegroup implements java.io.Serializable {

	// Fields

	private Integer favoriteGroupId;
	private Integer phoneUserId;
	private Short groupType;
	private String favoriteGroupName;
	private Timestamp addTime;
	private Short isCustomGroup;

	// Constructors

	/** default constructor */
	public Tfavoritegroup() {
	}

	/** full constructor */
	public Tfavoritegroup(Integer phoneUserId, Short groupType,
			String favoriteGroupName, Timestamp addTime, Short isCustomGroup) {
		this.phoneUserId = phoneUserId;
		this.groupType = groupType;
		this.favoriteGroupName = favoriteGroupName;
		this.addTime = addTime;
		this.isCustomGroup = isCustomGroup;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "FavoriteGroupID", nullable = false)
	public Integer getFavoriteGroupId() {
		return this.favoriteGroupId;
	}

	public void setFavoriteGroupId(Integer favoriteGroupId) {
		this.favoriteGroupId = favoriteGroupId;
	}

	@Column(name = "PhoneUserID", nullable = false)
	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	@Column(name = "GroupType", nullable = false)
	public Short getGroupType() {
		return this.groupType;
	}

	public void setGroupType(Short groupType) {
		this.groupType = groupType;
	}

	@Column(name = "FavoriteGroupName", nullable = false, length = 50)
	public String getFavoriteGroupName() {
		return this.favoriteGroupName;
	}

	public void setFavoriteGroupName(String favoriteGroupName) {
		this.favoriteGroupName = favoriteGroupName;
	}

	@Column(name = "AddTime", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "IsCustomGroup", nullable = false)
	public Short getIsCustomGroup() {
		return this.isCustomGroup;
	}

	public void setIsCustomGroup(Short isCustomGroup) {
		this.isCustomGroup = isCustomGroup;
	}

}