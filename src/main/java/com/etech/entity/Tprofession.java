package com.etech.entity;

/**
 * Tprofession entity. @author MyEclipse Persistence Tools
 */

public class Tprofession implements java.io.Serializable {

	// Fields

	private Integer professionId;
	private String professionName;

	// Constructors

	/** default constructor */
	public Tprofession() {
	}

	/** full constructor */
	public Tprofession(String professionName) {
		this.professionName = professionName;
	}

	// Property accessors

	public Integer getProfessionId() {
		return this.professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	public String getProfessionName() {
		return this.professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

}