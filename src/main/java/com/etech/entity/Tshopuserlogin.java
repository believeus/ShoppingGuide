package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tshopuserlogin entity. @author MyEclipse Persistence Tools
 */

public class Tshopuserlogin implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer shopUserId;
	private Integer loginType;
	private Timestamp loginTime;
	private String ipaddress;

	// Constructors

	/** default constructor */
	public Tshopuserlogin() {
	}

	/** minimal constructor */
	public Tshopuserlogin(Integer shopUserId, Integer loginType,
			Timestamp loginTime) {
		this.shopUserId = shopUserId;
		this.loginType = loginType;
		this.loginTime = loginTime;
	}

	/** full constructor */
	public Tshopuserlogin(Integer shopUserId, Integer loginType,
			Timestamp loginTime, String ipaddress) {
		this.shopUserId = shopUserId;
		this.loginType = loginType;
		this.loginTime = loginTime;
		this.ipaddress = ipaddress;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShopUserId() {
		return this.shopUserId;
	}

	public void setShopUserId(Integer shopUserId) {
		this.shopUserId = shopUserId;
	}

	public Integer getLoginType() {
		return this.loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

}