package com.etech.entity;

/**
 * Tfeature entity. @author MyEclipse Persistence Tools
 */

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

	public Integer getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	public String getFeatureName() {
		return this.featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public Short getFeatureType() {
		return this.featureType;
	}

	public void setFeatureType(Short featureType) {
		this.featureType = featureType;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}