package com.etech.entity;

/**
 * Tuserrolepermissionsown entity. @author MyEclipse Persistence Tools
 */

public class Tuserrolepermissionsown implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tuserpermissionvalue tuserpermissionvalue;
	private Tuserrole tuserrole;

	// Constructors

	/** default constructor */
	public Tuserrolepermissionsown() {
	}

	/** full constructor */
	public Tuserrolepermissionsown(Tuserpermissionvalue tuserpermissionvalue,
			Tuserrole tuserrole) {
		this.tuserpermissionvalue = tuserpermissionvalue;
		this.tuserrole = tuserrole;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tuserpermissionvalue getTuserpermissionvalue() {
		return this.tuserpermissionvalue;
	}

	public void setTuserpermissionvalue(
			Tuserpermissionvalue tuserpermissionvalue) {
		this.tuserpermissionvalue = tuserpermissionvalue;
	}

	public Tuserrole getTuserrole() {
		return this.tuserrole;
	}

	public void setTuserrole(Tuserrole tuserrole) {
		this.tuserrole = tuserrole;
	}

}