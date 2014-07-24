package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tphoneuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tphoneuser", catalog = "dbshop")
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
	private String userName;

	// Constructors

	/** default constructor */
	public Tphoneuser() {
	}

	/** minimal constructor */
	public Tphoneuser(Short userType, Integer professionId, Timestamp addTime,
			Integer loginCount, Double longitude, Double latitude,
			Integer areaId, Short state, String userName) {
		this.userType = userType;
		this.professionId = professionId;
		this.addTime = addTime;
		this.loginCount = loginCount;
		this.longitude = longitude;
		this.latitude = latitude;
		this.areaId = areaId;
		this.state = state;
		this.userName = userName;
	}

	/** full constructor */
	public Tphoneuser(Short userType, String phoneNumber, String imei,
			String password, String nickName, String realName, String gender,
			String qq, Timestamp birthday, String zodiac, String constellation,
			Integer professionId, String fancy, Timestamp addTime,
			Timestamp lastLoginTime, Integer loginCount, String profilePhoto,
			String openId, Double longitude, Double latitude, String sign,
			Integer areaId, Short state, String userName) {
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
		this.userName = userName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "PhoneUserID", unique = true, nullable = false)
	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	@Column(name = "UserType", nullable = false)
	public Short getUserType() {
		return this.userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	@Column(name = "PhoneNumber", length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "IMEI", length = 50)
	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	@Column(name = "Password", length = 200)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "NickName", length = 30)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "RealName", length = 20)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "Gender", length = 2)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "QQ", length = 12)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "Birthday", length = 19)
	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "Zodiac", length = 2)
	public String getZodiac() {
		return this.zodiac;
	}

	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}

	@Column(name = "Constellation", length = 6)
	public String getConstellation() {
		return this.constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	@Column(name = "ProfessionID", nullable = false)
	public Integer getProfessionId() {
		return this.professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	@Column(name = "Fancy", length = 65535)
	public String getFancy() {
		return this.fancy;
	}

	public void setFancy(String fancy) {
		this.fancy = fancy;
	}

	@Column(name = "AddTime", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "LastLoginTime", length = 19)
	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "LoginCount", nullable = false)
	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	@Column(name = "ProfilePhoto", length = 50)
	public String getProfilePhoto() {
		return this.profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	@Column(name = "OpenID", length = 32)
	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Column(name = "Longitude", nullable = false, precision = 22, scale = 0)
	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Column(name = "Latitude", nullable = false, precision = 22, scale = 0)
	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "Sign", length = 65535)
	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Column(name = "AreaId", nullable = false)
	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	@Column(name = "State", nullable = false)
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	@Column(name = "UserName", nullable = false, length = 30)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}