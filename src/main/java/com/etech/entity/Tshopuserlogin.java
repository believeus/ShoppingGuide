package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tshopuserlogin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tshopuserlogin", catalog = "dbshop")
public class Tshopuserlogin implements java.io.Serializable {

	// Fields

	private Integer shopUserLoginId;
	private Integer shopUserId;
	private Short loginType;
	private Timestamp loginTime;
	private String ipaddress;

	// Constructors

	/** default constructor */
	public Tshopuserlogin() {
	}

	/** minimal constructor */
	public Tshopuserlogin(Integer shopUserId, Short loginType,
			Timestamp loginTime) {
		this.shopUserId = shopUserId;
		this.loginType = loginType;
		this.loginTime = loginTime;
	}

	/** full constructor */
	public Tshopuserlogin(Integer shopUserId, Short loginType,
			Timestamp loginTime, String ipaddress) {
		this.shopUserId = shopUserId;
		this.loginType = loginType;
		this.loginTime = loginTime;
		this.ipaddress = ipaddress;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ShopUserLoginID", nullable = false)
	public Integer getShopUserLoginId() {
		return this.shopUserLoginId;
	}

	public void setShopUserLoginId(Integer shopUserLoginId) {
		this.shopUserLoginId = shopUserLoginId;
	}

	@Column(name = "ShopUserID", nullable = false)
	public Integer getShopUserId() {
		return this.shopUserId;
	}

	public void setShopUserId(Integer shopUserId) {
		this.shopUserId = shopUserId;
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