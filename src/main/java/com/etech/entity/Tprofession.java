package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tprofession entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tprofession", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "ProfessionID", unique = true, nullable = false)
	public Integer getProfessionId() {
		return this.professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	@Column(name = "ProfessionName", nullable = false, length = 30)
	public String getProfessionName() {
		return this.professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

}