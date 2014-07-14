package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tphoneuserlogin entity. @author MyEclipse Persistence Tools
 */

public class Tphoneuserlogin implements java.io.Serializable {

	// Fields

	private Integer phoneUserLoginId;
	private Integer phoneUserId;
	private Short loginType;
	private Timestamp loginTime;
	private String ipaddress;

	// Constructors

	/** default constructor */
	public Tphoneuserlogin() {
	}

	/** minimal constructor */
	public Tphoneuserlogin(Integer phoneUserId, Short loginType,
			Timestamp loginTime) {
		this.phoneUserId = phoneUserId;
		this.loginType = loginType;
		this.loginTime = loginTime;
	}

	/** full constructor */
	public Tphoneuserlogin(Integer phoneUserId, Short loginType,
			Timestamp loginTime, String ipaddress) {
		this.phoneUserId = phoneUserId;
		this.loginType = loginType;
		this.loginTime = loginTime;
		this.ipaddress = ipaddress;
	}

	// Property accessors

	public Integer getPhoneUserLoginId() {
		return this.phoneUserLoginId;
	}

	public void setPhoneUserLoginId(Integer phoneUserLoginId) {
		this.phoneUserLoginId = phoneUserLoginId;
	}

	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	public Short getLoginType() {
		return this.loginType;
	}

	public void setLoginType(Short loginType) {
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