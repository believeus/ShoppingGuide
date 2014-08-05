package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tadminrole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tadminrole", catalog = "dbshop")
public class Tadminrole implements java.io.Serializable {

	// Fields

	private Integer adminRoleId;
	private String adminRoleName;
	private String remark;

	// Constructors

	/** default constructor */
	public Tadminrole() {
	}

	/** minimal constructor */
	public Tadminrole(String adminRoleName) {
		this.adminRoleName = adminRoleName;
	}

	/** full constructor */
	public Tadminrole(String adminRoleName, String remark) {
		this.adminRoleName = adminRoleName;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "AdminRoleID", unique = true, nullable = false)
	public Integer getAdminRoleId() {
		return this.adminRoleId;
	}

	public void setAdminRoleId(Integer adminRoleId) {
		this.adminRoleId = adminRoleId;
	}

	@Column(name = "AdminRoleName", nullable = false, length = 50)
	public String getAdminRoleName() {
		return this.adminRoleName;
	}

	public void setAdminRoleName(String adminRoleName) {
		this.adminRoleName = adminRoleName;
	}

	@Column(name = "Remark", length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}