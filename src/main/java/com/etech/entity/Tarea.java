package com.etech.entity;

/**
 * Tarea entity. @author MyEclipse Persistence Tools
 */

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

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getAreaSortIndex() {
		return this.areaSortIndex;
	}

	public void setAreaSortIndex(Integer areaSortIndex) {
		this.areaSortIndex = areaSortIndex;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}