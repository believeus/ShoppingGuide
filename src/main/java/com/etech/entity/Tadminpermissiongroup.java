package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tadminpermissiongroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tadminpermissiongroup", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "AdminRolePermissionsOwnID", nullable = false)
	public Integer getAdminRolePermissionsOwnId() {
		return this.adminRolePermissionsOwnId;
	}

	public void setAdminRolePermissionsOwnId(Integer adminRolePermissionsOwnId) {
		this.adminRolePermissionsOwnId = adminRolePermissionsOwnId;
	}

	@Column(name = "AdminPermissionGroupName", nullable = false, length = 50)
	public String getAdminPermissionGroupName() {
		return this.adminPermissionGroupName;
	}

	public void setAdminPermissionGroupName(String adminPermissionGroupName) {
		this.adminPermissionGroupName = adminPermissionGroupName;
	}

	@Column(name = "Description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}