package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tphoneuserfeature entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tphoneuserfeature", catalog = "dbshop")
public class Tphoneuserfeature implements java.io.Serializable {

	// Fields

	private Integer phoneUserFeatureId;
	private Integer phoneUserId;
	private Integer featureId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tphoneuserfeature() {
	}

	/** full constructor */
	public Tphoneuserfeature(Integer phoneUserId, Integer featureId,
			Timestamp addTime) {
		this.phoneUserId = phoneUserId;
		this.featureId = featureId;
		this.addTime = addTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "PhoneUserFeatureID", nullable = false)
	public Integer getPhoneUserFeatureId() {
		return this.phoneUserFeatureId;
	}

	public void setPhoneUserFeatureId(Integer phoneUserFeatureId) {
		this.phoneUserFeatureId = phoneUserFeatureId;
	}

	@Column(name = "PhoneUserID", nullable = false)
	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	@Column(name = "FeatureID", nullable = false)
	public Integer getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	@Column(name = "AddTime", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}