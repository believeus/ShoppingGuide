package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tphoneuser entity. @author MyEclipse Persistence Tools
 */

public class Tphoneuser implements java.io.Serializable {

	// Fields

	private Integer phoneUserId;
	private Short userType;
	private String phoneNumber;
	private String imei;
	private String password;
	private String nickName;
	private String realName;
	private String gender;
	private String qq;
	private Timestamp birthday;
	private String zodiac;
	private String constellation;
	private Integer professionId;
	private String fancy;
	private Timestamp addTime;
	private Timestamp lastLoginTime;
	private Integer loginCount;
	private String profilePhoto;
	private String openId;
	private Double longitude;
	private Double latitude;
	private String sign;
	private Integer areaId;
	private Short state;

	// Constructors

	/** default constructor */
	public Tphoneuser() {
	}

	/** minimal constructor */
	public Tphoneuser(Short userType, Timestamp addTime, Integer loginCount,
			Double longitude, Double latitude, Short state) {
		this.userType = userType;
		this.addTime = addTime;
		this.loginCount = loginCount;
		this.longitude = longitude;
		this.latitude = latitude;
		this.state = state;
	}

	/** full constructor */
	public Tphoneuser(Short userType, String phoneNumber, String imei,
			String password, String nickName, String realName, String gender,
			String qq, Timestamp birthday, String zodiac, String constellation,
			Integer professionId, String fancy, Timestamp addTime,
			Timestamp lastLoginTime, Integer loginCount, String profilePhoto,
			String openId, Double longitude, Double latitude, String sign,
			Integer areaId, Short state) {
		this.userType = userType;
		this.phoneNumber = phoneNumber;
		this.imei = imei;
		this.password = password;
		this.nickName = nickName;
		this.realName = realName;
		this.gender = gender;
		this.qq = qq;
		this.birthday = birthday;
		this.zodiac = zodiac;
		this.constellation = constellation;
		this.professionId = professionId;
		this.fancy = fancy;
		this.addTime = addTime;
		this.lastLoginTime = lastLoginTime;
		this.loginCount = loginCount;
		this.profilePhoto = profilePhoto;
		this.openId = openId;
		this.longitude = longitude;
		this.latitude = latitude;
		this.sign = sign;
		this.areaId = areaId;
		this.state = state;
	}

	// Property accessors

	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	public Short getUserType() {
		return this.userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getZodiac() {
		return this.zodiac;
	}

	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}

	public String getConstellation() {
		return this.constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public Integer getProfessionId() {
		return this.professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	public String getFancy() {
		return this.fancy;
	}

	public void setFancy(String fancy) {
		this.fancy = fancy;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
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

	public String getProfilePhoto() {
		return this.profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
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

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

}