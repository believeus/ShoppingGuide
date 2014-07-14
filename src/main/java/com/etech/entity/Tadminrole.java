package com.etech.entity;

/**
 * Tadminrole entity. @author MyEclipse Persistence Tools
 */

public class Tadminrole implements java.io.Serializable {

	// Fields

	private Integer adminUserId;
	private String adminUserName;
	private String remark;

	// Constructors

	/** default constructor */
	public Tadminrole() {
	}

	/** minimal constructor */
	public Tadminrole(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	/** full constructor */
	public Tadminrole(String adminUserName, String remark) {
		this.adminUserName = adminUserName;
		this.remark = remark;
	}

	// Property accessors

	public Integer getAdminUserId() {
		return this.adminUserId;
	}

	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getAdminUserName() {
		return this.adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}