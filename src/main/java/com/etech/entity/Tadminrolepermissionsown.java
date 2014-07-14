package com.etech.entity;

/**
 * Tadminrolepermissionsown entity. @author MyEclipse Persistence Tools
 */

public class Tadminrolepermissionsown implements java.io.Serializable {

	// Fields

	private Integer adminRolePermissionsOwnId;
	private Integer adminRoleId;
	private Integer adminPermissionId;

	// Constructors

	/** default constructor */
	public Tadminrolepermissionsown() {
	}

	/** full constructor */
	public Tadminrolepermissionsown(Integer adminRoleId,
			Integer adminPermissionId) {
		this.adminRoleId = adminRoleId;
		this.adminPermissionId = adminPermissionId;
	}

	// Property accessors

	public Integer getAdminRolePermissionsOwnId() {
		return this.adminRolePermissionsOwnId;
	}

	public void setAdminRolePermissionsOwnId(Integer adminRolePermissionsOwnId) {
		this.adminRolePermissionsOwnId = adminRolePermissionsOwnId;
	}

	public Integer getAdminRoleId() {
		return this.adminRoleId;
	}

	public void setAdminRoleId(Integer adminRoleId) {
		this.adminRoleId = adminRoleId;
	}

	public Integer getAdminPermissionId() {
		return this.adminPermissionId;
	}

	public void setAdminPermissionId(Integer adminPermissionId) {
		this.adminPermissionId = adminPermissionId;
	}

}