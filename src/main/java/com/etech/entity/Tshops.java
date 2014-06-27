package com.etech.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Tshops entity. @author MyEclipse Persistence Tools
 */

public class Tshops implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tfloor tfloor;
	private Troottypeofgoods troottypeofgoods;
	private String number;
	private String name;
	private String phoneNumber;
	private String goodsBrand;
	private String licenseId;
	private String introduction;
	private Integer level;
	private Integer totalScore;
	private Integer voteCount;
	private Integer positionX;
	private Integer positionY;
	private Timestamp addTime;
	private Integer state;
	private Integer pageView;
	private String logo;
	private Integer validGoodsCount;
	private Integer validActivityCount;
	private String licensePhoto;
	private String qrcode;
	private Set tshopsusers = new HashSet(0);
	private Set tgoodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tshops() {
	}

	/** minimal constructor */
	public Tshops(Tfloor tfloor, Troottypeofgoods troottypeofgoods,
			String name, Integer level, Integer totalScore, Integer voteCount,
			Timestamp addTime, Integer state) {
		this.tfloor = tfloor;
		this.troottypeofgoods = troottypeofgoods;
		this.name = name;
		this.level = level;
		this.totalScore = totalScore;
		this.voteCount = voteCount;
		this.addTime = addTime;
		this.state = state;
	}

	/** full constructor */
	public Tshops(Tfloor tfloor, Troottypeofgoods troottypeofgoods,
			String number, String name, String phoneNumber, String goodsBrand,
			String licenseId, String introduction, Integer level,
			Integer totalScore, Integer voteCount, Integer positionX,
			Integer positionY, Timestamp addTime, Integer state,
			Integer pageView, String logo, Integer validGoodsCount,
			Integer validActivityCount, String licensePhoto, String qrcode,
			Set tshopsusers, Set tgoodses) {
		this.tfloor = tfloor;
		this.troottypeofgoods = troottypeofgoods;
		this.number = number;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.goodsBrand = goodsBrand;
		this.licenseId = licenseId;
		this.introduction = introduction;
		this.level = level;
		this.totalScore = totalScore;
		this.voteCount = voteCount;
		this.positionX = positionX;
		this.positionY = positionY;
		this.addTime = addTime;
		this.state = state;
		this.pageView = pageView;
		this.logo = logo;
		this.validGoodsCount = validGoodsCount;
		this.validActivityCount = validActivityCount;
		this.licensePhoto = licensePhoto;
		this.qrcode = qrcode;
		this.tshopsusers = tshopsusers;
		this.tgoodses = tgoodses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tfloor getTfloor() {
		return this.tfloor;
	}

	public void setTfloor(Tfloor tfloor) {
		this.tfloor = tfloor;
	}

	public Troottypeofgoods getTroottypeofgoods() {
		return this.troottypeofgoods;
	}

	public void setTroottypeofgoods(Troottypeofgoods troottypeofgoods) {
		this.troottypeofgoods = troottypeofgoods;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGoodsBrand() {
		return this.goodsBrand;
	}

	public void setGoodsBrand(String goodsBrand) {
		this.goodsBrand = goodsBrand;
	}

	public String getLicenseId() {
		return this.licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getVoteCount() {
		return this.voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

	public Integer getPositionX() {
		return this.positionX;
	}

	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}

	public Integer getPositionY() {
		return this.positionY;
	}

	public void setPositionY(Integer positionY) {
		this.positionY = positionY;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getPageView() {
		return this.pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getValidGoodsCount() {
		return this.validGoodsCount;
	}

	public void setValidGoodsCount(Integer validGoodsCount) {
		this.validGoodsCount = validGoodsCount;
	}

	public Integer getValidActivityCount() {
		return this.validActivityCount;
	}

	public void setValidActivityCount(Integer validActivityCount) {
		this.validActivityCount = validActivityCount;
	}

	public String getLicensePhoto() {
		return this.licensePhoto;
	}

	public void setLicensePhoto(String licensePhoto) {
		this.licensePhoto = licensePhoto;
	}

	public String getQrcode() {
		return this.qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public Set getTshopsusers() {
		return this.tshopsusers;
	}

	public void setTshopsusers(Set tshopsusers) {
		this.tshopsusers = tshopsusers;
	}

	public Set getTgoodses() {
		return this.tgoodses;
	}

	public void setTgoodses(Set tgoodses) {
		this.tgoodses = tgoodses;
	}

}