package com.etech.entity;

/**
 * Tprovince entity. @author MyEclipse Persistence Tools
 */

public class Tprovince implements java.io.Serializable {

	// Fields

	private Integer provinceId;
	private String provinceName;
	private Integer provinceSortIndex;
	private String remark;

	// Constructors

	/** default constructor */
	public Tprovince() {
	}

	/** full constructor */
	public Tprovince(String provinceName, Integer provinceSortIndex,
			String remark) {
		this.provinceName = provinceName;
		this.provinceSortIndex = provinceSortIndex;
		this.remark = remark;
	}

	// Property accessors

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Integer getProvinceSortIndex() {
		return this.provinceSortIndex;
	}

	public void setProvinceSortIndex(Integer provinceSortIndex) {
		this.provinceSortIndex = provinceSortIndex;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}