package com.etech.entity;

/**
 * Ttabletrace entity. @author MyEclipse Persistence Tools
 */

public class Ttabletrace implements java.io.Serializable {

	// Fields

	private TtabletraceId id;

	// Constructors

	/** default constructor */
	public Ttabletrace() {
	}

	/** full constructor */
	public Ttabletrace(TtabletraceId id) {
		this.id = id;
	}

	// Property accessors

	public TtabletraceId getId() {
		return this.id;
	}

	public void setId(TtabletraceId id) {
		this.id = id;
	}

}