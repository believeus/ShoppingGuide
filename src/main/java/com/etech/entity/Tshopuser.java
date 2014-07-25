package com.etech.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tshopuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tshopuser", catalog = "dbshop")
public class Tshopuser implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 7380039072436914130L;
	private Integer shopUserId;
	private String userName;
	private String password;
	private String phoneNumber;
	private String nickName;
	private String realName;
	private String gender;
	private String idnumber;
	private Timestamp addTime;
	private Timestamp lastLoginTime;
	private Integer loginCount;
	private String profilePhoto;
	private Short state;
	private Integer score;
	private Short grade;
	private Integer defaultShopId;
	private List<Tshop> shops=new ArrayList<Tshop>(0);
	private List<Tshopuserlogin> shopuserLogins=new ArrayList<Tshopuserlogin>(0);
	// Constructors

	/** default constructor */
	public Tshopuser() {
	}


	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ShopUserID", nullable = false)
	public Integer getShopUserId() {
		return this.shopUserId;
	}

	public void setShopUserId(Integer shopUserId) {
		this.shopUserId = shopUserId;
	}

	@Column(name = "UserName", nullable = false, length = 30)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Password", nullable = false, length = 200)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "PhoneNumber", length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "NickName", length = 30)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "RealName", length = 30)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "Gender", nullable = false, length = 4)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "IDNumber", length = 20)
	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
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

	@Column(name = "State", nullable = false)
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	@Column(name = "Score", nullable = false)
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}


	@Column(name = "Grade", nullable = false)
	public Short getGrade() {
		return this.grade;
	}

	public void setGrade(Short grade) {
		this.grade = grade;
	}


	@Column(name = "DefaultShopID", nullable = false)
	public Integer getDefaultShopId() {
		return this.defaultShopId;
	}

	public void setDefaultShopId(Integer defaultShopId) {
		this.defaultShopId = defaultShopId;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },mappedBy="shopusers")
	public List<Tshop> getShops() {
		return shops;
	}

	public void setShops(List<Tshop> shops) {
		this.shops = shops;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="shopuser")
	public List<Tshopuserlogin> getShopuserLogins() {
		return shopuserLogins;
	}

	public void setShopuserLogins(List<Tshopuserlogin> shopuserLogins) {
		this.shopuserLogins = shopuserLogins;
	}

}