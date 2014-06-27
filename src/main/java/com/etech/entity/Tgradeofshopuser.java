package com.etech.entity;

/**
 * Tgradeofshopuser entity. @author MyEclipse Persistence Tools
 */

public class Tgradeofshopuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer level;
	private String remark;

	// Constructors

	/** default constructor */
	public Tgradeofshopuser() {
	}

	/** minimal constructor */
	public Tgradeofshopuser(String name, Integer level) {
		this.name = name;
		this.level = level;
	}

	/** full constructor */
	public Tgradeofshopuser(String name, Integer level, String remark) {
		this.name = name;
		this.level = level;
		this.remark = remark;
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

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}