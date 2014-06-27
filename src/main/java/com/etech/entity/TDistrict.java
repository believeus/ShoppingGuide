package com.etech.entity;

/**
 * TDistrict entity. @author MyEclipse Persistence Tools
 */

public class TDistrict implements java.io.Serializable {

	// Fields

	private Integer id;
	private String disName;
	private Integer cityId;
	private Integer disSort;

	// Constructors

	/** default constructor */
	public TDistrict() {
	}

	/** minimal constructor */
	public TDistrict(String disName, Integer cityId) {
		this.disName = disName;
		this.cityId = cityId;
	}

	/** full constructor */
	public TDistrict(String disName, Integer cityId, Integer disSort) {
		this.disName = disName;
		this.cityId = cityId;
		this.disSort = disSort;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisName() {
		return this.disName;
	}

	public void setDisName(String disName) {
		this.disName = disName;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDisSort() {
		return this.disSort;
	}

	public void setDisSort(Integer disSort) {
		this.disSort = disSort;
	}

}