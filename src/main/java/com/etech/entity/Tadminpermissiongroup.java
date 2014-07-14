package com.etech.entity;

/**
 * Tadminpermissiongroup entity. @author MyEclipse Persistence Tools
 */

public class Tadminpermissiongroup implements java.io.Serializable {

	// Fields

	private Integer adminRolePermissionsOwnId;
	private String adminPermissionGroupName;
	private String description;

	// Constructors

	/** default constructor */
	public Tadminpermissiongroup() {
	}

	/** minimal constructor */
	public Tadminpermissiongroup(String adminPermissionGroupName) {
		this.adminPermissionGroupName = adminPermissionGroupName;
	}

	/** full constructor */
	public Tadminpermissiongroup(String adminPermissionGroupName,
			String description) {
		this.adminPermissionGroupName = adminPermissionGroupName;
		this.description = description;
	}

	// Property accessors

	public Integer getAdminRolePermissionsOwnId() {
		return this.adminRolePermissionsOwnId;
	}

	public void setAdminRolePermissionsOwnId(Integer adminRolePermissionsOwnId) {
		this.adminRolePermissionsOwnId = adminRolePermissionsOwnId;
	}

	public String getAdminPermissionGroupName() {
		return this.adminPermissionGroupName;
	}

	public void setAdminPermissionGroupName(String adminPermissionGroupName) {
		this.adminPermissionGroupName = adminPermissionGroupName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}