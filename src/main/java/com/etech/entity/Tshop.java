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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Tshop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tshop", catalog = "dbshop")
public class Tshop implements java.io.Serializable {


	private static final long serialVersionUID = -15115199236039315L;
	private Integer shopId;
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
	private String ShopDefaultPhotoURL;
	private Integer ShopDefaultPhotoWidth;
	private Integer ShopDefaultPhotoHeight;
	private String businessLicenseNo;
	private String referee;
	private Integer validGoodsCount;
	private String remark;
	private String shopFeatureIds;
	private String shopBusinessScopeIds;
	private List<Tshopuser> shopusers=new ArrayList<Tshopuser>(0);
	private List<Tgoodstype> goodsTypes=new ArrayList<Tgoodstype>(0);
	private List<Tfeature> features=new ArrayList<Tfeature>(0);
	private Tmarket market;
	// Constructors

	/** default constructor */
	public Tshop() {
	}
	
	/**
	 * 店铺默认图片的宽度
	 * @return
	 */
	@Column(name = "ShopDefaultPhotoWidth", nullable = false)
	public Integer getShopDefaultPhotoWidth() {
		return ShopDefaultPhotoWidth;
	}

	public void setShopDefaultPhotoWidth(Integer shopDefaultPhotoWidth) {
		ShopDefaultPhotoWidth = shopDefaultPhotoWidth;
	}

	/**
	 * 店铺默认图片的高度
	 * @return
	 */
	@Column(name = "ShopDefaultPhotoHeight", nullable = false)
	public Integer getShopDefaultPhotoHeight() {
		return ShopDefaultPhotoHeight;
	}

	public void setShopDefaultPhotoHeight(Integer shopDefaultPhotoHeight) {
		ShopDefaultPhotoHeight = shopDefaultPhotoHeight;
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

	@Column(name = "ShopDefaultPhotoURL", length = 65535)
	public String getShopDefaultPhotoURL() {
		return ShopDefaultPhotoURL;
	}

	public void setShopDefaultPhotoURL(String shopDefaultPhotoURL) {
		ShopDefaultPhotoURL = shopDefaultPhotoURL;
	}

	@Column(name = "BusinessLicenseNo", length = 50)
	public String getBusinessLicenseNo() {
		return this.businessLicenseNo;
	}

	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tshopusershoprelation",
    joinColumns = { @JoinColumn(name = "ShopId", referencedColumnName = "ShopId") }, 
    inverseJoinColumns = { @JoinColumn(name = "ShopUserID", referencedColumnName = "ShopUserID") })
	public List<Tshopuser> getShopusers() {
		return shopusers;
	}

	public void setShopusers(List<Tshopuser> shopusers) {
		this.shopusers = shopusers;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tshopbusinessscope",
    joinColumns = { @JoinColumn(name = "shopId", referencedColumnName = "shopId") }, 
    inverseJoinColumns = { @JoinColumn(name = "GoodsTypeID", referencedColumnName = "GoodsTypeID") })
	public List<Tgoodstype> getGoodsTypes() {
		return goodsTypes;
	}


	public void setGoodsTypes(List<Tgoodstype> goodsTypes) {
		this.goodsTypes = goodsTypes;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="MarketID",referencedColumnName="marketId")
	public Tmarket getMarket() {
		return market;
	}

	public void setMarket(Tmarket market) {
		this.market = market;
	}
	
	@ManyToMany(cascade = { CascadeType.ALL})
	@JoinTable(name = "tshopfeature",
    joinColumns = { @JoinColumn(name = "ShopID", referencedColumnName = "ShopID") }, 
    inverseJoinColumns = { @JoinColumn(name = "FeatureID", referencedColumnName = "FeatureID") })
	public List<Tfeature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Tfeature> features) {
		this.features = features;
	}

	/**
	 * @return the referee
	 */
	public String getReferee() {
		return referee;
	}

	/**
	 * @param referee the referee to set
	 */
	public void setReferee(String referee) {
		this.referee = referee;
	}

	/**
	 * @return the validGoodsCount
	 */
	public Integer getValidGoodsCount() {
		return validGoodsCount;
	}

	/**
	 * @param validGoodsCount the validGoodsCount to set
	 */
	public void setValidGoodsCount(Integer validGoodsCount) {
		this.validGoodsCount = validGoodsCount;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the shopFeatureIds
	 */
	public String getShopFeatureIds() {
		return shopFeatureIds;
	}

	/**
	 * @param shopFeatureIds the shopFeatureIds to set
	 */
	public void setShopFeatureIds(String shopFeatureIds) {
		this.shopFeatureIds = shopFeatureIds;
	}

	/**
	 * @return the shopBusinessScopeIds
	 */
	public String getShopBusinessScopeIds() {
		return shopBusinessScopeIds;
	}

	/**
	 * @param shopBusinessScopeIds the shopBusinessScopeIds to set
	 */
	public void setShopBusinessScopeIds(String shopBusinessScopeIds) {
		this.shopBusinessScopeIds = shopBusinessScopeIds;
	}
	
}