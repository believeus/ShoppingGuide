package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tarea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tarea", catalog = "dbshop")
public class Tarea implements java.io.Serializable {

	// Fields

	private Integer areaId;
	private String areaName;
	private Integer cityId;
	private Integer areaSortIndex;
	private String remark;

	// Constructors

	/** default constructor */
	public Tarea() {
	}

	/** minimal constructor */
	public Tarea(String areaName, Integer cityId, Integer areaSortIndex) {
		this.areaName = areaName;
		this.cityId = cityId;
		this.areaSortIndex = areaSortIndex;
	}

	/** full constructor */
	public Tarea(String areaName, Integer cityId, Integer areaSortIndex,
			String remark) {
		this.areaName = areaName;
		this.cityId = cityId;
		this.areaSortIndex = areaSortIndex;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "AreaID", unique = true, nullable = false)
	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	@Column(name = "AreaName", nullable = false, length = 50)
	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "CityID", nullable = false)
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "AreaSortIndex", nullable = false)
	public Integer getAreaSortIndex() {
		return this.areaSortIndex;
	}

	public void setAreaSortIndex(Integer areaSortIndex) {
		this.areaSortIndex = areaSortIndex;
	}

	@Column(name = "Remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}