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
	@Id
	@GeneratedValue
	@Column(name = "AdminUserID", unique = true, nullable = false)
	public Integer getAdminUserId() {
		return this.adminUserId;
	}

	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
	}

	@Column(name = "AdminUserName", nullable = false, length = 50)
	public String getAdminUserName() {
		return this.adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	@Column(name = "Remark", length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}