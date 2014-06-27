package com.etech.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Troottypeofgoods entity. @author MyEclipse Persistence Tools
 */

public class Troottypeofgoods implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String remark;
	private Set tshopses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Troottypeofgoods() {
	}

	/** minimal constructor */
	public Troottypeofgoods(String name) {
		this.name = name;
	}

	/** full constructor */
	public Troottypeofgoods(String name, String remark, Set tshopses) {
		this.name = name;
		this.remark = remark;
		this.tshopses = tshopses;
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

	public Set getTshopses() {
		return this.tshopses;
	}

	public void setTshopses(Set tshopses) {
		this.tshopses = tshopses;
	}

}