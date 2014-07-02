package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tshopsuser entity. @author MyEclipse Persistence Tools
 */

public class Tshopsuser implements java.io.Serializable {

	private static final long serialVersionUID = -719584894502951602L;
	private Integer id;
	private Tshops tshops;
	private String userName;
	private String password;
	private String phoneNumber;
	private String nickName;
	private String realName;
	private String gender;
	private String idnumber;
	private Timestamp userCreatTime;
	private Timestamp firstLoginTime;
	private Timestamp lastLoginTime;
	private String lastLoginIp;
	private Integer state;
	private Integer score;
	private Integer gradeId;
	private Integer pageView;
	private String picture;
	private String referee;

	// Constructors

	/** default constructor */
	public Tshopsuser() {
	}

	/** minimal constructor */
	public Tshopsuser(Tshops tshops, String userName, String password,
			String gender, Timestamp userCreatTime, Integer state,
			Integer score, Integer gradeId) {
		this.tshops = tshops;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.userCreatTime = userCreatTime;
		this.state = state;
		this.score = score;
		this.gradeId = gradeId;
	}

	/** full constructor */
	public Tshopsuser(Tshops tshops, String userName, String password,
			String phoneNumber, String nickName, String realName,
			String gender, String idnumber, Timestamp userCreatTime,
			Timestamp firstLoginTime, Timestamp lastLoginTime,
			String lastLoginIp, Integer state, Integer score, Integer gradeId,
			Integer pageView, String picture, String referee) {
		this.tshops = tshops;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.nickName = nickName;
		this.realName = realName;
		this.gender = gender;
		this.idnumber = idnumber;
		this.userCreatTime = userCreatTime;
		this.firstLoginTime = firstLoginTime;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.state = state;
		this.score = score;
		this.gradeId = gradeId;
		this.pageView = pageView;
		this.picture = picture;
		this.referee = referee;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tshops getTshops() {
		return this.tshops;
	}

	public void setTshops(Tshops tshops) {
		this.tshops = tshops;
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

	public Timestamp getUserCreatTime() {
		return this.userCreatTime;
	}

	public void setUserCreatTime(Timestamp userCreatTime) {
		this.userCreatTime = userCreatTime;
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

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public Integer getPageView() {
		return this.pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getReferee() {
		return this.referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

}