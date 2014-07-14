package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tshopsuser entity. @author MyEclipse Persistence Tools
 */

public class Tshopsuser implements java.io.Serializable {

	
	private static final long serialVersionUID = -1187526397440991285L;
	private Integer shopUserId;
	private String userName;
	private String password;
	private Integer shopId;
	private String phoneNumber;
	private String nickName;
	private String realName;
	private String gender;
	private String idnumber;
	private Timestamp addTime;
	private Timestamp lastLoginTime;
	private String profilePicture;
	private Short state;
	private Integer score;
	private String referee;
	private Integer grade;
	private Integer pageView;

	// Constructors

	/** default constructor */
	public Tshopsuser() {
	}

	/** minimal constructor */
	public Tshopsuser(String userName, String password, Integer shopId,
			String gender, Timestamp addTime, Short state, Integer score,
			Integer grade, Integer pageView) {
		this.userName = userName;
		this.password = password;
		this.shopId = shopId;
		this.gender = gender;
		this.addTime = addTime;
		this.state = state;
		this.score = score;
		this.grade = grade;
		this.pageView = pageView;
	}

	/** full constructor */
	public Tshopsuser(String userName, String password, Integer shopId,
			String phoneNumber, String nickName, String realName,
			String gender, String idnumber, Timestamp addTime,
			Timestamp lastLoginTime, String profilePicture, Short state,
			Integer score, String referee, Integer grade, Integer pageView) {
		this.userName = userName;
		this.password = password;
		this.shopId = shopId;
		this.phoneNumber = phoneNumber;
		this.nickName = nickName;
		this.realName = realName;
		this.gender = gender;
		this.idnumber = idnumber;
		this.addTime = addTime;
		this.lastLoginTime = lastLoginTime;
		this.profilePicture = profilePicture;
		this.state = state;
		this.score = score;
		this.referee = referee;
		this.grade = grade;
		this.pageView = pageView;
	}

	// Property accessors

	public Integer getShopUserId() {
		return this.shopUserId;
	}

	public void setShopUserId(Integer shopUserId) {
		this.shopUserId = shopUserId;
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

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
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

	public String getProfilePicture() {
		return this.profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getReferee() {
		return this.referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getPageView() {
		return this.pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}

}