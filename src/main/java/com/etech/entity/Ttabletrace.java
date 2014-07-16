package com.etech.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ttabletrace entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ttabletrace", catalog = "dbshop")
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
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tableName", column = @Column(name = "TableName", nullable = false, length = 50)),
			@AttributeOverride(name = "stampId", column = @Column(name = "StampID", nullable = false)),
			@AttributeOverride(name = "lastChangeTime", column = @Column(name = "LastChangeTime", nullable = false, length = 19)) })
	public TtabletraceId getId() {
		return this.id;
	}

	public void setId(TtabletraceId id) {
		this.id = id;
	}

}