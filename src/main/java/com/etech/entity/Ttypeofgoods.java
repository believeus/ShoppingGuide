package com.etech.entity;

/**
 * Ttypeofgoods entity. @author MyEclipse Persistence Tools
 */

public class Ttypeofgoods implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String remark;
	private Integer mainTypeId;

	// Constructors

	/** default constructor */
	public Ttypeofgoods() {
	}

	/** minimal constructor */
	public Ttypeofgoods(Integer mainTypeId) {
		this.mainTypeId = mainTypeId;
	}

	/** full constructor */
	public Ttypeofgoods(String name, String remark, Integer mainTypeId) {
		this.name = name;
		this.remark = remark;
		this.mainTypeId = mainTypeId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getMainTypeId() {
		return this.mainTypeId;
	}

	public void setMainTypeId(Integer mainTypeId) {
		this.mainTypeId = mainTypeId;
	}

}