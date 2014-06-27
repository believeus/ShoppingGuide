package com.etech.entity;

/**
 * Tuserlogin entity. @author MyEclipse Persistence Tools
 */

public class Tuserlogin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userType;
	private String userId;
	private String loginType;
	private String loginTime;
	private String ipaddress;

	// Constructors

	/** default constructor */
	public Tuserlogin() {
	}

	/** minimal constructor */
	public Tuserlogin(String userType, String userId, String loginType,
			String loginTime) {
		this.userType = userType;
		this.userId = userId;
		this.loginType = loginType;
		this.loginTime = loginTime;
	}

	/** full constructor */
	public Tuserlogin(String userType, String userId, String loginType,
			String loginTime, String ipaddress) {
		this.userType = userType;
		this.userId = userId;
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

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginType() {
		return this.loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

}