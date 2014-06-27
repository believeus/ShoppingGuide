package com.etech.entity;

/**
 * Tpermissionsofshopusers entity. @author MyEclipse Persistence Tools
 */

public class Tpermissionsofshopusers implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String value;
	private String description;
	private Integer gradeId;

	// Constructors

	/** default constructor */
	public Tpermissionsofshopusers() {
	}

	/** minimal constructor */
	public Tpermissionsofshopusers(String name, String value, Integer gradeId) {
		this.name = name;
		this.value = value;
		this.gradeId = gradeId;
	}

	/** full constructor */
	public Tpermissionsofshopusers(String name, String value,
			String description, Integer gradeId) {
		this.name = name;
		this.value = value;
		this.description = description;
		this.gradeId = gradeId;
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

}