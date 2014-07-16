package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tprovince entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tprovince", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "ProvinceID", nullable = false)
	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	@Column(name = "ProvinceName", nullable = false, length = 50)
	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	@Column(name = "ProvinceSortIndex", nullable = false)
	public Integer getProvinceSortIndex() {
		return this.provinceSortIndex;
	}

	public void setProvinceSortIndex(Integer provinceSortIndex) {
		this.provinceSortIndex = provinceSortIndex;
	}

	@Column(name = "Remark", nullable = false, length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}