package com.etech.entity;

/**
 * Tsearchkeywords entity. @author MyEclipse Persistence Tools
 */

public class Tsearchkeywords implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String count;
	private String lastTime;
	private String index;
	private Short range;

	// Constructors

	/** default constructor */
	public Tsearchkeywords() {
	}

	/** minimal constructor */
	public Tsearchkeywords(String name, String count, String lastTime,
			Short range) {
		this.name = name;
		this.count = count;
		this.lastTime = lastTime;
		this.range = range;
	}

	/** full constructor */
	public Tsearchkeywords(String name, String count, String lastTime,
			String index, Short range) {
		this.name = name;
		this.count = count;
		this.lastTime = lastTime;
		this.index = index;
		this.range = range;
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

	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(String lastTime) {
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

}