package com.etech.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tmarket entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tmarket", catalog = "dbshop")
public class Tmarket implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 5698669623289145689L;
	private Integer marketId;
	private Integer areaId;
	private String marketName;
	private String address;
	private Double latitude;
	private Double longitude;
	private Short floorCount;
	private Timestamp openingTimeStart;
	private Timestamp openingTimeEnding;
	private String introduction;
	private String photoUrl;
	private List<Tshop> shops=new ArrayList<Tshop>();

	// Constructors

	/** default constructor */
	public Tmarket() {
	}

	/** minimal constructor */
	public Tmarket(Integer areaId, String marketName, Double latitude,
			Double longitude, Short floorCount) {
		this.areaId = areaId;
		this.marketName = marketName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.floorCount = floorCount;
	}

	/** full constructor */
	public Tmarket(Integer areaId, String marketName, String address,
			Double latitude, Double longitude, Short floorCount,
			Timestamp openingTimeStart, Timestamp openingTimeEnding,
			String introduction, String photoUrl) {
		this.areaId = areaId;
		this.marketName = marketName;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.floorCount = floorCount;
		this.openingTimeStart = openingTimeStart;
		this.openingTimeEnding = openingTimeEnding;
		this.introduction = introduction;
		this.photoUrl = photoUrl;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "MarketID", nullable = false)
	public Integer getMarketId() {
		return this.marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	@Column(name = "AreaID", nullable = false)
	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	@Column(name = "MarketName", nullable = false, length = 50)
	public String getMarketName() {
		return this.marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	@Column(name = "Address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Column(name = "FloorCount", nullable = false)
	public Short getFloorCount() {
		return this.floorCount;
	}

	public void setFloorCount(Short floorCount) {
		this.floorCount = floorCount;
	}

	@Column(name = "OpeningTimeStart", length = 19)
	public Timestamp getOpeningTimeStart() {
		return this.openingTimeStart;
	}

	public void setOpeningTimeStart(Timestamp openingTimeStart) {
		this.openingTimeStart = openingTimeStart;
	}

	@Column(name = "OpeningTimeEnding", length = 19)
	public Timestamp getOpeningTimeEnding() {
		return this.openingTimeEnding;
	}

	public void setOpeningTimeEnding(Timestamp openingTimeEnding) {
		this.openingTimeEnding = openingTimeEnding;
	}

	@Column(name = "Introduction", length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "PhotoURL", length = 65535)
	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="market")
	public List<Tshop> getShops() {
		return shops;
	}

	public void setShops(List<Tshop> shops) {
		this.shops = shops;
	}

}