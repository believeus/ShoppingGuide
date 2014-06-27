package com.etech.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tuserpermissionvalue entity. @author MyEclipse Persistence Tools
 */

public class Tuserpermissionvalue implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tuserpermissions tuserpermissions;
	private String value;
	private String remark;
	private Set tuserrolepermissionsowns = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tuserpermissionvalue() {
	}

	/** minimal constructor */
	public Tuserpermissionvalue(Tuserpermissions tuserpermissions, String value) {
		this.tuserpermissions = tuserpermissions;
		this.value = value;
	}

	/** full constructor */
	public Tuserpermissionvalue(Tuserpermissions tuserpermissions,
			String value, String remark, Set tuserrolepermissionsowns) {
		this.tuserpermissions = tuserpermissions;
		this.value = value;
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

	public Tuserpermissions getTuserpermissions() {
		return this.tuserpermissions;
	}

	public void setTuserpermissions(Tuserpermissions tuserpermissions) {
		this.tuserpermissions = tuserpermissions;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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