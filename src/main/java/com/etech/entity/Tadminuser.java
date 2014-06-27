package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tadminuser entity. @author MyEclipse Persistence Tools
 */

public class Tadminuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String password;
	private String phoneNumber;
	private String realName;
	private Integer roleId;
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
	public Tadminuser(String userName, String password, String phoneNumber,
			Integer roleId, Timestamp creatTime, Short state) {
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.roleId = roleId;
		this.creatTime = creatTime;
		this.state = state;
	}

	/** full constructor */
	public Tadminuser(String userName, String password, String phoneNumber,
			String realName, Integer roleId, Timestamp creatTime,
			Timestamp firstLoginTime, Timestamp lastLoginTime,
			String lastLoginIp, Short state) {
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.realName = realName;
		this.roleId = roleId;
		this.creatTime = creatTime;
		this.firstLoginTime = firstLoginTime;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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