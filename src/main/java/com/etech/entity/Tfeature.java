package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tfeature entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tfeature", catalog = "dbshop")
public class Tfeature implements java.io.Serializable {

	// Fields

	private Integer featureId;
	private String featureName;
	private Short featureType;
	private Integer count;

	// Constructors

	/** default constructor */
	public Tfeature() {
	}

	/** full constructor */
	public Tfeature(String featureName, Short featureType, Integer count) {
		this.featureName = featureName;
		this.featureType = featureType;
		this.count = count;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "FeatureID", nullable = false)
	public Integer getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	@Column(name = "FeatureName", nullable = false, length = 20)
	public String getFeatureName() {
		return this.featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	@Column(name = "FeatureType", nullable = false)
	public Short getFeatureType() {
		return this.featureType;
	}

	public void setFeatureType(Short featureType) {
		this.featureType = featureType;
	}

	@Column(name = "Count", nullable = false)
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}