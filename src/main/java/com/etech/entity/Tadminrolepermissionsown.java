package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tadminrolepermissionsown entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tadminrolepermissionsown", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "AdminRolePermissionsOwnID", unique = true, nullable = false)
	public Integer getAdminRolePermissionsOwnId() {
		return this.adminRolePermissionsOwnId;
	}

	public void setAdminRolePermissionsOwnId(Integer adminRolePermissionsOwnId) {
		this.adminRolePermissionsOwnId = adminRolePermissionsOwnId;
	}

	@Column(name = "AdminRoleID", nullable = false)
	public Integer getAdminRoleId() {
		return this.adminRoleId;
	}

	public void setAdminRoleId(Integer adminRoleId) {
		this.adminRoleId = adminRoleId;
	}

	@Column(name = "AdminPermissionID", nullable = false)
	public Integer getAdminPermissionId() {
		return this.adminPermissionId;
	}

	public void setAdminPermissionId(Integer adminPermissionId) {
		this.adminPermissionId = adminPermissionId;
	}

}