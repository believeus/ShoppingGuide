package com.etech.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tuserpermissions entity. @author MyEclipse Persistence Tools
 */

public class Tuserpermissions implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private Set tuserpermissionvalues = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tuserpermissions() {
	}

	/** full constructor */
	public Tuserpermissions(String name, String description,
			Set tuserpermissionvalues) {
		this.name = name;
		this.description = description;
		this.tuserpermissionvalues = tuserpermissionvalues;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getTuserpermissionvalues() {
		return this.tuserpermissionvalues;
	}

	public void setTuserpermissionvalues(Set tuserpermissionvalues) {
		this.tuserpermissionvalues = tuserpermissionvalues;
	}

}