package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tshopuserlogin", catalog = "dbshop")
public class Tshopuserlogin implements java.io.Serializable {


	private static final long serialVersionUID = -8841437889194632827L;
	private Integer shopUserLoginId;
	private Short loginType;
	private Timestamp loginTime;
	private String ipaddress;
	private Tshopuser shopuser;

	// Constructors

	/** default constructor */
	public Tshopuserlogin() {
	}


	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ShopUserLoginID", unique = true, nullable = false)
	public Integer getShopUserLoginId() {
		return this.shopUserLoginId;
	}

	public void setShopUserLoginId(Integer shopUserLoginId) {
		this.shopUserLoginId = shopUserLoginId;
	}


	@Column(name = "LoginType", nullable = false)
	public Short getLoginType() {
		return this.loginType;
	}

	public void setLoginType(Short loginType) {
		this.loginType = loginType;
	}

	@Column(name = "LoginTime", nullable = false, length = 19)
	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "IPAddress", length = 16)
	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shopUserId",referencedColumnName="shopUserId")
	public Tshopuser getShopuser() {
		return shopuser;
	}

	public void setShopuser(Tshopuser shopuser) {
		this.shopuser = shopuser;
	}
	
}