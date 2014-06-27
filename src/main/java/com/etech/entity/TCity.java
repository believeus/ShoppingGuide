package com.etech.entity;

/**
 * TCity entity. @author MyEclipse Persistence Tools
 */

public class TCity implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private String cityName;
	private Integer proId;
	private Integer citySort;

	// Constructors

	/** default constructor */
	public TCity() {
	}

	/** minimal constructor */
	public TCity(String cityName) {
		this.cityName = cityName;
	}

	/** full constructor */
	public TCity(String cityName, Integer proId, Integer citySort) {
		this.cityName = cityName;
		this.proId = proId;
		this.citySort = citySort;
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public Integer getCitySort() {
		return this.citySort;
	}

	public void setCitySort(Integer citySort) {
		this.citySort = citySort;
	}

}