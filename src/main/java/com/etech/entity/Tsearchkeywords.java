package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tsearchkeywords entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tsearchkeywords", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Name", nullable = false, length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Count", nullable = false, length = 65535)
	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Column(name = "LastTime", nullable = false, length = 65535)
	public String getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	@Column(name = "Index", length = 4)
	public String getIndex() {
		return this.index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@Column(name = "Range", nullable = false)
	public Short getRange() {
		return this.range;
	}

	public void setRange(Short range) {
		this.range = range;
	}

}