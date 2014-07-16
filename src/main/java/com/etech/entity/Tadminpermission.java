package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tadminpermission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tadminpermission", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "AdminPermissionID", nullable = false)
	public Integer getAdminPermissionId() {
		return this.adminPermissionId;
	}

	public void setAdminPermissionId(Integer adminPermissionId) {
		this.adminPermissionId = adminPermissionId;
	}

	@Column(name = "AdminPermissionGroupID", nullable = false)
	public Integer getAdminPermissionGroupId() {
		return this.adminPermissionGroupId;
	}

	public void setAdminPermissionGroupId(Integer adminPermissionGroupId) {
		this.adminPermissionGroupId = adminPermissionGroupId;
	}

	@Column(name = "AdminPermissionName", nullable = false, length = 50)
	public String getAdminPermissionName() {
		return this.adminPermissionName;
	}

	public void setAdminPermissionName(String adminPermissionName) {
		this.adminPermissionName = adminPermissionName;
	}

	@Column(name = "Remark", length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}