package com.etech.entity;

/**
 * Tsystemconfig entity. @author MyEclipse Persistence Tools
 */

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

	public Integer getSystemConfigId() {
		return this.systemConfigId;
	}

	public void setSystemConfigId(Integer systemConfigId) {
		this.systemConfigId = systemConfigId;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}