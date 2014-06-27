package com.etech.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tuserrole entity. @author MyEclipse Persistence Tools
 */

public class Tuserrole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;
	private String remark;
	private Set tuserrolepermissionsowns = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tuserrole() {
	}

	/** minimal constructor */
	public Tuserrole(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public Tuserrole(String roleName, String remark,
			Set tuserrolepermissionsowns) {
		this.roleName = roleName;
		this.remark = remark;
		this.tuserrolepermissionsowns = tuserrolepermissionsowns;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getTuserrolepermissionsowns() {
		return this.tuserrolepermissionsowns;
	}

	public void setTuserrolepermissionsowns(Set tuserrolepermissionsowns) {
		this.tuserrolepermissionsowns = tuserrolepermissionsowns;
	}

}