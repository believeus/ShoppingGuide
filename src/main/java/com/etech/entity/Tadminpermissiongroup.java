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

	private Integer adminPermissionGroupId;
	private String adminPermissionGroupName;
	private Short isRequired;
	private Short isSingleSelection;
	private String description;

	// Constructors

	/** default constructor */
	public Tadminpermissiongroup() {
	}

	/** minimal constructor */
	public Tadminpermissiongroup(String adminPermissionGroupName,
			Short isRequired, Short isSingleSelection) {
		this.adminPermissionGroupName = adminPermissionGroupName;
		this.isRequired = isRequired;
		this.isSingleSelection = isSingleSelection;
	}

	/** full constructor */
	public Tadminpermissiongroup(String adminPermissionGroupName,
			Short isRequired, Short isSingleSelection, String description) {
		this.adminPermissionGroupName = adminPermissionGroupName;
		this.isRequired = isRequired;
		this.isSingleSelection = isSingleSelection;
		this.description = description;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "AdminPermissionGroupID", unique = true, nullable = false)
	public Integer getAdminPermissionGroupId() {
		return this.adminPermissionGroupId;
	}

	public void setAdminPermissionGroupId(Integer adminPermissionGroupId) {
		this.adminPermissionGroupId = adminPermissionGroupId;
	}

	@Column(name = "AdminPermissionGroupName", nullable = false, length = 50)
	public String getAdminPermissionGroupName() {
		return this.adminPermissionGroupName;
	}

	public void setAdminPermissionGroupName(String adminPermissionGroupName) {
		this.adminPermissionGroupName = adminPermissionGroupName;
	}

	@Column(name = "IsRequired", nullable = false)
	public Short getIsRequired() {
		return this.isRequired;
	}

	public void setIsRequired(Short isRequired) {
		this.isRequired = isRequired;
	}

	@Column(name = "IsSingleSelection", nullable = false)
	public Short getIsSingleSelection() {
		return this.isSingleSelection;
	}

	public void setIsSingleSelection(Short isSingleSelection) {
		this.isSingleSelection = isSingleSelection;
	}

	@Column(name = "Description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}