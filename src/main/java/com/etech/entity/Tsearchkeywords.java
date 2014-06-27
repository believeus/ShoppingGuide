package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tsearchkeywords entity. @author MyEclipse Persistence Tools
 */

public class Tsearchkeywords implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer count;
	private Timestamp lastTime;
	private String index;
	private Short range;
	private Short type;

	// Constructors

	/** default constructor */
	public Tsearchkeywords() {
	}

	/** minimal constructor */
	public Tsearchkeywords(String name, Integer count, Timestamp lastTime,
			Short range, Short type) {
		this.name = name;
		this.count = count;
		this.lastTime = lastTime;
		this.range = range;
		this.type = type;
	}

	/** full constructor */
	public Tsearchkeywords(String name, Integer count, Timestamp lastTime,
			String index, Short range, Short type) {
		this.name = name;
		this.count = count;
		this.lastTime = lastTime;
		this.index = index;
		this.range = range;
		this.type = type;
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

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	public String getIndex() {
		return this.index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public Short getRange() {
		return this.range;
	}

	public void setRange(Short range) {
		this.range = range;
	}

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

}