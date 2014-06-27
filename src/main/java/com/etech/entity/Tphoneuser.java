package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tphoneuser entity. @author MyEclipse Persistence Tools
 */

public class Tphoneuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String phoneNumber;
	private String userName;
	private String password;
	private String nickName;
	private Integer score;
	private String gender;
	private Timestamp birthday;
	private Integer areaId;
	private Timestamp registeTime;
	private Timestamp lastLoginTime;
	private Integer loginCount;
	private Integer state;
	private String realName;
	private String picture;
	private String imei;
	private String openId;
	private Double longitude;
	private Double latitude;

	// Constructors

	/** default constructor */
	public Tphoneuser() {
	}

	/** minimal constructor */
	public Tphoneuser(Integer score, Timestamp registeTime, Integer loginCount,
			Integer state, Double longitude, Double latitude) {
		this.score = score;
		this.registeTime = registeTime;
		this.loginCount = loginCount;
		this.state = state;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	/** full constructor */
	public Tphoneuser(String phoneNumber, String userName, String password,
			String nickName, Integer score, String gender, Timestamp birthday,
			Integer areaId, Timestamp registeTime, Timestamp lastLoginTime,
			Integer loginCount, Integer state, String realName, String picture,
			String imei, String openId, Double longitude, Double latitude) {
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.score = score;
		this.gender = gender;
		this.birthday = birthday;
		this.areaId = areaId;
		this.registeTime = registeTime;
		this.lastLoginTime = lastLoginTime;
		this.loginCount = loginCount;
		this.state = state;
		this.realName = realName;
		this.picture = picture;
		this.imei = imei;
		this.openId = openId;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Timestamp getRegisteTime() {
		return this.registeTime;
	}

	public void setRegisteTime(Timestamp registeTime) {
		this.registeTime = registeTime;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}