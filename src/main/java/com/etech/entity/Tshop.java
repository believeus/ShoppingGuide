package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tshop entity. @author MyEclipse Persistence Tools
 */

public class Tshop implements java.io.Serializable {

	// Fields

	private Integer shopId;
	private Integer marketId;
	private String shopName;
	private String shopOwnerName;
	private String phoneNumber;
	private String address;
	private String qq;
	private String priceRange;
	private String businessLicensePhoto;
	private String logo;
	private String qrcode;
	private Short isRecommend;
	private Short state;
	private Timestamp addTime;
	private Integer viewCount;
	private Integer bePraisedCount;
	private String shopFeature;
	private Integer fansCount;
	private Double latitude;
	private Double longitude;
	private String shopPhotoUrl;
	private String shopPhotoDefaultUrl;
	private String businessLicenseNo;

	// Constructors

	/** default constructor */
	public Tshop() {
	}

	/** minimal constructor */
	public Tshop(Integer marketId, String shopName, String shopOwnerName,
			String address, Short isRecommend, Short state, Timestamp addTime,
			Integer viewCount, Integer bePraisedCount, Integer fansCount,
			Double latitude, Double longitude) {
		this.marketId = marketId;
		this.shopName = shopName;
		this.shopOwnerName = shopOwnerName;
		this.address = address;
		this.isRecommend = isRecommend;
		this.state = state;
		this.addTime = addTime;
		this.viewCount = viewCount;
		this.bePraisedCount = bePraisedCount;
		this.fansCount = fansCount;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/** full constructor */
	public Tshop(Integer marketId, String shopName, String shopOwnerName,
			String phoneNumber, String address, String qq, String priceRange,
			String businessLicensePhoto, String logo, String qrcode,
			Short isRecommend, Short state, Timestamp addTime,
			Integer viewCount, Integer bePraisedCount, String shopFeature,
			Integer fansCount, Double latitude, Double longitude,
			String shopPhotoUrl, String shopPhotoDefaultUrl,
			String businessLicenseNo) {
		this.marketId = marketId;
		this.shopName = shopName;
		this.shopOwnerName = shopOwnerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.qq = qq;
		this.priceRange = priceRange;
		this.businessLicensePhoto = businessLicensePhoto;
		this.logo = logo;
		this.qrcode = qrcode;
		this.isRecommend = isRecommend;
		this.state = state;
		this.addTime = addTime;
		this.viewCount = viewCount;
		this.bePraisedCount = bePraisedCount;
		this.shopFeature = shopFeature;
		this.fansCount = fansCount;
		this.latitude = latitude;
		this.longitude = longitude;
		this.shopPhotoUrl = shopPhotoUrl;
		this.shopPhotoDefaultUrl = shopPhotoDefaultUrl;
		this.businessLicenseNo = businessLicenseNo;
	}

	// Property accessors

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getMarketId() {
		return this.marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopOwnerName() {
		return this.shopOwnerName;
	}

	public void setShopOwnerName(String shopOwnerName) {
		this.shopOwnerName = shopOwnerName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPriceRange() {
		return this.priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public String getBusinessLicensePhoto() {
		return this.businessLicensePhoto;
	}

	public void setBusinessLicensePhoto(String businessLicensePhoto) {
		this.businessLicensePhoto = businessLicensePhoto;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getQrcode() {
		return this.qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public Short getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(Short isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getBePraisedCount() {
		return this.bePraisedCount;
	}

	public void setBePraisedCount(Integer bePraisedCount) {
		this.bePraisedCount = bePraisedCount;
	}

	public String getShopFeature() {
		return this.shopFeature;
	}

	public void setShopFeature(String shopFeature) {
		this.shopFeature = shopFeature;
	}

	public Integer getFansCount() {
		return this.fansCount;
	}

	public void setFansCount(Integer fansCount) {
		this.fansCount = fansCount;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getShopPhotoUrl() {
		return this.shopPhotoUrl;
	}

	public void setShopPhotoUrl(String shopPhotoUrl) {
		this.shopPhotoUrl = shopPhotoUrl;
	}

	public String getShopPhotoDefaultUrl() {
		return this.shopPhotoDefaultUrl;
	}

	public void setShopPhotoDefaultUrl(String shopPhotoDefaultUrl) {
		this.shopPhotoDefaultUrl = shopPhotoDefaultUrl;
	}

	public String getBusinessLicenseNo() {
		return this.businessLicenseNo;
	}

	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}

}