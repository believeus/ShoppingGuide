package com.etech.entity;

/**
 * Tadminpermission entity. @author MyEclipse Persistence Tools
 */

public class Tadminpermission implements java.io.Serializable {

	// Fields

	private Integer adminPermissionId;
	private Integer adminPermissionGroupId;
	private String adminPermissionName;
	private String remark;

	// Constructors

	/** default constructor */
	public Tadminpermission() {
	}

	/** minimal constructor */
	public Tadminpermission(Integer adminPermissionGroupId,
			String adminPermissionName) {
		this.adminPermissionGroupId = adminPermissionGroupId;
		this.adminPermissionName = adminPermissionName;
	}

	/** full constructor */
	public Tadminpermission(Integer adminPermissionGroupId,
			String adminPermissionName, String remark) {
		this.adminPermissionGroupId = adminPermissionGroupId;
		this.adminPermissionName = adminPermissionName;
		this.remark = remark;
	}

	// Property accessors

	public Integer getAdminPermissionId() {
		return this.adminPermissionId;
	}

	public void setAdminPermissionId(Integer adminPermissionId) {
		this.adminPermissionId = adminPermissionId;
	}

	public Integer getAdminPermissionGroupId() {
		return this.adminPermissionGroupId;
	}

	public void setAdminPermissionGroupId(Integer adminPermissionGroupId) {
		this.adminPermissionGroupId = adminPermissionGroupId;
	}

	public String getAdminPermissionName() {
		return this.adminPermissionName;
	}

	public void setAdminPermissionName(String adminPermissionName) {
		this.adminPermissionName = adminPermissionName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}