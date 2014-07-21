package com.etech.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Tshop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tshop", catalog = "dbshop")
public class Tshop implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -15115199236039315L;
	private Integer shopId;
	private Integer marketId;
	private String shopName;
	private String shopOwnerName;
	private String phoneNumber;
	private String address;
	private String qq;
	private String priceRange;
	private String businessLicensePhotoUrl;
	private String logo;
	private String qrcode;
	private Short isRecommend;
	private Short state;
	private Timestamp addTime;
	private Integer viewCount;
	private Integer bePraisedCount;
	private String shopFeature;
	private String shopBusinessScope;
	private Integer fansCount;
	private Double latitude;
	private Double longitude;
	private String shopPhotoUrl;
	private String shopPhotoDefaultUrl;
	private String businessLicenseNo;
	private List<Tshopsuser> shopusers=new ArrayList<Tshopsuser>();
	private List<Tgoodstype> goodsTypes=new ArrayList<Tgoodstype>();
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
			String businessLicensePhotoUrl, String logo, String qrcode,
			Short isRecommend, Short state, Timestamp addTime,
			Integer viewCount, Integer bePraisedCount, String shopFeature,
			String shopBusinessScope, Integer fansCount, Double latitude,
			Double longitude, String shopPhotoUrl, String shopPhotoDefaultUrl,
			String businessLicenseNo) {
		this.marketId = marketId;
		this.shopName = shopName;
		this.shopOwnerName = shopOwnerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.qq = qq;
		this.priceRange = priceRange;
		this.businessLicensePhotoUrl = businessLicensePhotoUrl;
		this.logo = logo;
		this.qrcode = qrcode;
		this.isRecommend = isRecommend;
		this.state = state;
		this.addTime = addTime;
		this.viewCount = viewCount;
		this.bePraisedCount = bePraisedCount;
		this.shopFeature = shopFeature;
		this.shopBusinessScope = shopBusinessScope;
		this.fansCount = fansCount;
		this.latitude = latitude;
		this.longitude = longitude;
		this.shopPhotoUrl = shopPhotoUrl;
		this.shopPhotoDefaultUrl = shopPhotoDefaultUrl;
		this.businessLicenseNo = businessLicenseNo;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ShopID", nullable = false)
	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Column(name = "MarketID", nullable = false)
	public Integer getMarketId() {
		return this.marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	@Column(name = "ShopName", nullable = false, length = 50)
	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Column(name = "ShopOwnerName", nullable = false, length = 50)
	public String getShopOwnerName() {
		return this.shopOwnerName;
	}

	public void setShopOwnerName(String shopOwnerName) {
		this.shopOwnerName = shopOwnerName;
	}

	@Column(name = "PhoneNumber", length = 50)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "Address", nullable = false, length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "QQ", length = 50)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "PriceRange", length = 50)
	public String getPriceRange() {
		return this.priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	@Column(name = "BusinessLicensePhotoURL", length = 50)
	public String getBusinessLicensePhotoUrl() {
		return this.businessLicensePhotoUrl;
	}

	public void setBusinessLicensePhotoUrl(String businessLicensePhotoUrl) {
		this.businessLicensePhotoUrl = businessLicensePhotoUrl;
	}

	@Column(name = "Logo", length = 50)
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "QRCode", length = 50)
	public String getQrcode() {
		return this.qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	@Column(name = "IsRecommend", nullable = false)
	public Short getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(Short isRecommend) {
		this.isRecommend = isRecommend;
	}

	@Column(name = "State", nullable = false)
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	@Column(name = "AddTime", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "ViewCount", nullable = false)
	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Column(name = "BePraisedCount", nullable = false)
	public Integer getBePraisedCount() {
		return this.bePraisedCount;
	}

	public void setBePraisedCount(Integer bePraisedCount) {
		this.bePraisedCount = bePraisedCount;
	}

	@Column(name = "ShopFeature", length = 65535)
	public String getShopFeature() {
		return this.shopFeature;
	}

	public void setShopFeature(String shopFeature) {
		this.shopFeature = shopFeature;
	}

	@Column(name = "ShopBusinessScope", length = 65535)
	public String getShopBusinessScope() {
		return this.shopBusinessScope;
	}

	public void setShopBusinessScope(String shopBusinessScope) {
		this.shopBusinessScope = shopBusinessScope;
	}

	@Column(name = "FansCount", nullable = false)
	public Integer getFansCount() {
		return this.fansCount;
	}

	public void setFansCount(Integer fansCount) {
		this.fansCount = fansCount;
	}

	@Column(name = "Latitude", nullable = false, precision = 22, scale = 0)
	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "Longitude", nullable = false, precision = 22, scale = 0)
	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Column(name = "ShopPhotoURL", length = 65535)
	public String getShopPhotoUrl() {
		return this.shopPhotoUrl;
	}

	public void setShopPhotoUrl(String shopPhotoUrl) {
		this.shopPhotoUrl = shopPhotoUrl;
	}

	@Column(name = "ShopPhotoDefaultURL", length = 65535)
	public String getShopPhotoDefaultUrl() {
		return this.shopPhotoDefaultUrl;
	}

	public void setShopPhotoDefaultUrl(String shopPhotoDefaultUrl) {
		this.shopPhotoDefaultUrl = shopPhotoDefaultUrl;
	}

	@Column(name = "BusinessLicenseNo", length = 50)
	public String getBusinessLicenseNo() {
		return this.businessLicenseNo;
	}

	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },mappedBy="shops")
	public List<Tshopsuser> getShopusers() {
		return shopusers;
	}

	public void setShopusers(List<Tshopsuser> shopusers) {
		this.shopusers = shopusers;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tbusinessscope",
    joinColumns = { @JoinColumn(name = "shopId", referencedColumnName = "shopId") }, 
    inverseJoinColumns = { @JoinColumn(name = "goodsTypeId", referencedColumnName = "goodsTypeId") })
	public List<Tgoodstype> getGoodsTypes() {
		return goodsTypes;
	}

	public void setGoodsTypes(List<Tgoodstype> goodsTypes) {
		this.goodsTypes = goodsTypes;
	}
	
}