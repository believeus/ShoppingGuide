package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tsystemconfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tsystemconfig", catalog = "dbshop")
public class Tsystemconfig implements java.io.Serializable {

	// Fields

	private Integer systemConfigId;
	private String value;
	private String remark;

	// Constructors

	/** default constructor */
	public Tsystemconfig() {
	}

	/** minimal constructor */
	public Tsystemconfig(String value) {
		this.value = value;
	}

	/** full constructor */
	public Tsystemconfig(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "SystemConfigID", nullable = false)
	public Integer getSystemConfigId() {
		return this.systemConfigId;
	}

	public void setSystemConfigId(Integer systemConfigId) {
		this.systemConfigId = systemConfigId;
	}

	@Column(name = "Value", nullable = false, length = 200)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "Remark", length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}