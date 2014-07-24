package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tcity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tcity", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "CityID", unique = true, nullable = false)
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "CityName", nullable = false, length = 50)
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "ProvinceID", nullable = false)
	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	@Column(name = "CitySortIndex", nullable = false)
	public Integer getCitySortIndex() {
		return this.citySortIndex;
	}

	public void setCitySortIndex(Integer citySortIndex) {
		this.citySortIndex = citySortIndex;
	}

	@Column(name = "Remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}