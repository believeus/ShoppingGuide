package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tfindpasswordforshopuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tfindpasswordforshopuser", catalog = "dbshop")
public class Tfindpasswordforshopuser implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -7032897331015497339L;
	private Integer findPasswordForShopUserId;
	private String userName;
	private String phoneNumber;
	private String licensePhoto;
	private String remark;
	private Short state;
	private Timestamp applyTime;
	private Timestamp stateChangeTime;

	// Constructors

	/** default constructor */
	public Tfindpasswordforshopuser() {
	}

	/** minimal constructor */
	public Tfindpasswordforshopuser(String userName, String phoneNumber,
			Short state, Timestamp applyTime, Integer phoneUserActiveCount,
			Timestamp stateChangeTime) {
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.state = state;
		this.applyTime = applyTime;
		this.stateChangeTime = stateChangeTime;
	}

	/** full constructor */
	public Tfindpasswordforshopuser(String userName, String phoneNumber,
			String licensePhoto, String remark, Short state,
			Timestamp applyTime, Integer phoneUserActiveCount,
			Timestamp stateChangeTime) {
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.licensePhoto = licensePhoto;
		this.remark = remark;
		this.state = state;
		this.applyTime = applyTime;
		this.stateChangeTime = stateChangeTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "FindPasswordForShopUserID", unique = true, nullable = false)
	public Integer getFindPasswordForShopUserId() {
		return this.findPasswordForShopUserId;
	}

	public void setFindPasswordForShopUserId(Integer findPasswordForShopUserId) {
		this.findPasswordForShopUserId = findPasswordForShopUserId;
	}

	@Column(name = "UserName", nullable = false, length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PhoneNumber", nullable = false, length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "LicensePhoto", length = 50)
	public String getLicensePhoto() {
		return this.licensePhoto;
	}

	public void setLicensePhoto(String licensePhoto) {
		this.licensePhoto = licensePhoto;
	}

	@Column(name = "Remark", length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "State", nullable = false)
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	@Column(name = "ApplyTime", nullable = false, length = 19)
	public Timestamp getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}


	@Column(name = "StateChangeTime", nullable = false, length = 19)
	public Timestamp getStateChangeTime() {
		return this.stateChangeTime;
	}

	public void setStateChangeTime(Timestamp stateChangeTime) {
		this.stateChangeTime = stateChangeTime;
	}

}