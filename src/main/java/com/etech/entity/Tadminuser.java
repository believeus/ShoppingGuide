package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tadminuser entity. @author MyEclipse Persistence Tools
 */

public class Tadminuser implements java.io.Serializable {

	// Fields

	private Integer adminUserId;
	private String adminUserName;
	private String password;
	private String phoneNumber;
	private String realName;
	private Integer adminRoleId;
	private Timestamp creatTime;
	private Timestamp firstLoginTime;
	private Timestamp lastLoginTime;
	private String lastLoginIp;
	private Short state;

	// Constructors

	/** default constructor */
	public Tadminuser() {
	}

	/** minimal constructor */
	public Tadminuser(String adminUserName, String password,
			String phoneNumber, Integer adminRoleId, Timestamp creatTime,
			Short state) {
		this.adminUserName = adminUserName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.adminRoleId = adminRoleId;
		this.creatTime = creatTime;
		this.state = state;
	}

	/** full constructor */
	public Tadminuser(String adminUserName, String password,
			String phoneNumber, String realName, Integer adminRoleId,
			Timestamp creatTime, Timestamp firstLoginTime,
			Timestamp lastLoginTime, String lastLoginIp, Short state) {
		this.adminUserName = adminUserName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.realName = realName;
		this.adminRoleId = adminRoleId;
		this.creatTime = creatTime;
		this.firstLoginTime = firstLoginTime;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.state = state;
	}

	// Property accessors

	public Integer getAdminUserId() {
		return this.adminUserId;
	}

	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getAdminUserName() {
		return this.adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getAdminRoleId() {
		return this.adminRoleId;
	}

	public void setAdminRoleId(Integer adminRoleId) {
		this.adminRoleId = adminRoleId;
	}

	public Timestamp getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

	public Timestamp getFirstLoginTime() {
		return this.firstLoginTime;
	}

	public void setFirstLoginTime(Timestamp firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

}