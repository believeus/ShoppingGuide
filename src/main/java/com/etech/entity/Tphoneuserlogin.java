package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tphoneuserlogin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tphoneuserlogin", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "PhoneUserLoginID", unique = true, nullable = false)
	public Integer getPhoneUserLoginId() {
		return this.phoneUserLoginId;
	}

	public void setPhoneUserLoginId(Integer phoneUserLoginId) {
		this.phoneUserLoginId = phoneUserLoginId;
	}

	@Column(name = "PhoneUserID", nullable = false)
	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	@Column(name = "LoginType", nullable = false)
	public Short getLoginType() {
		return this.loginType;
	}

	public void setLoginType(Short loginType) {
		this.loginType = loginType;
	}

	@Column(name = "LoginTime", nullable = false, length = 19)
	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "IPAddress", length = 16)
	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

}