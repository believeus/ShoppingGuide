package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tadminuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tadminuser", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "AdminUserID", nullable = false)
	public Integer getAdminUserId() {
		return this.adminUserId;
	}

	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
	}

	@Column(name = "AdminUserName", nullable = false, length = 50)
	public String getAdminUserName() {
		return this.adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	@Column(name = "Password", nullable = false, length = 200)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "PhoneNumber", nullable = false, length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "RealName", length = 30)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "AdminRoleID", nullable = false)
	public Integer getAdminRoleId() {
		return this.adminRoleId;
	}

	public void setAdminRoleId(Integer adminRoleId) {
		this.adminRoleId = adminRoleId;
	}

	@Column(name = "CreatTime", nullable = false, length = 19)
	public Timestamp getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

	@Column(name = "FirstLoginTime", length = 19)
	public Timestamp getFirstLoginTime() {
		return this.firstLoginTime;
	}

	public void setFirstLoginTime(Timestamp firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}

	@Column(name = "LastLoginTime", length = 19)
	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "LastLoginIP", length = 16)
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "State", nullable = false)
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

}