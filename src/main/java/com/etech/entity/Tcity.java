package com.etech.entity;

/**
 * Tcity entity. @author MyEclipse Persistence Tools
 */

public class Tcity implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private String cityName;
	private Integer provinceId;
	private Integer citySortIndex;
	private String remark;

	// Constructors

	/** default constructor */
	public Tcity() {
	}

	/** minimal constructor */
	public Tcity(String cityName, Integer provinceId, Integer citySortIndex) {
		this.cityName = cityName;
		this.provinceId = provinceId;
		this.citySortIndex = citySortIndex;
	}

	/** full constructor */
	public Tcity(String cityName, Integer provinceId, Integer citySortIndex,
			String remark) {
		this.cityName = cityName;
		this.provinceId = provinceId;
		this.citySortIndex = citySortIndex;
		this.remark = remark;
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

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCitySortIndex() {
		return this.citySortIndex;
	}

	public void setCitySortIndex(Integer citySortIndex) {
		this.citySortIndex = citySortIndex;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}