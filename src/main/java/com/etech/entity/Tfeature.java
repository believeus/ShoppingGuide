package com.etech.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Tfeature entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tfeature", catalog = "dbshop")
public class Tfeature implements java.io.Serializable {

	private static final long serialVersionUID = 934741253301408491L;
	private Integer featureId;
	private String featureName;
	private Short featureType;
	private Integer count;
	private String objectFlag;
	private List<Tshop> shops=new ArrayList<Tshop>(0);
	private List<Tgoods> goodses=new ArrayList<Tgoods>(0);
	

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
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },mappedBy="features")
	public List<Tshop> getShops() {
		return shops;
	}

	public void setShops(List<Tshop> shops) {
		this.shops = shops;
	}
	@ManyToMany(cascade = { CascadeType.ALL},mappedBy="features")
	public List<Tgoods> getGoodses() {
		return goodses;
	}

	public void setGoodses(List<Tgoods> goodses) {
		this.goodses = goodses;
	}

	@Column(name = "ObjectFlag", nullable = false, length = 3)
	public String getObjectFlag() {
		return this.objectFlag;
	}

	public void setObjectFlag(String objectFlag) {
		this.objectFlag = objectFlag;
	}
	
	
}