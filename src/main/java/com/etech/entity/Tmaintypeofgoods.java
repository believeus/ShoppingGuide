package com.etech.entity;

/**
 * Tmaintypeofgoods entity. @author MyEclipse Persistence Tools
 */

public class Tmaintypeofgoods implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String remark;
	private Integer rootTypeId;

	// Constructors

	/** default constructor */
	public Tmaintypeofgoods() {
	}

	/** minimal constructor */
	public Tmaintypeofgoods(String name, Integer rootTypeId) {
		this.name = name;
		this.rootTypeId = rootTypeId;
	}

	/** full constructor */
	public Tmaintypeofgoods(String name, String remark, Integer rootTypeId) {
		this.name = name;
		this.remark = remark;
		this.rootTypeId = rootTypeId;
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

	public Integer getRootTypeId() {
		return this.rootTypeId;
	}

	public void setRootTypeId(Integer rootTypeId) {
		this.rootTypeId = rootTypeId;
	}

}