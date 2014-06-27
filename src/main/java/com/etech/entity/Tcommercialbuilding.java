package com.etech.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Tcommercialbuilding entity. @author MyEclipse Persistence Tools
 */

public class Tcommercialbuilding implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tbusinesscircles tbusinesscircles;
	private String name;
	private String address;
	private Double lng;
	private Double lat;
	private Integer floorCount;
	private Integer businessFloorCount;
	private Timestamp openingTimeStart;
	private Timestamp openingTimeEnding;
	private String introduction;
	private String photosUrl;
	private Set tfloors = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tcommercialbuilding() {
	}

	/** minimal constructor */
	public Tcommercialbuilding(Tbusinesscircles tbusinesscircles, String name,
			Double lng, Double lat) {
		this.tbusinesscircles = tbusinesscircles;
		this.name = name;
		this.lng = lng;
		this.lat = lat;
	}

	/** full constructor */
	public Tcommercialbuilding(Tbusinesscircles tbusinesscircles, String name,
			String address, Double lng, Double lat, Integer floorCount,
			Integer businessFloorCount, Timestamp openingTimeStart,
			Timestamp openingTimeEnding, String introduction, String photosUrl,
			Set tfloors) {
		this.tbusinesscircles = tbusinesscircles;
		this.name = name;
		this.address = address;
		this.lng = lng;
		this.lat = lat;
		this.floorCount = floorCount;
		this.businessFloorCount = businessFloorCount;
		this.openingTimeStart = openingTimeStart;
		this.openingTimeEnding = openingTimeEnding;
		this.introduction = introduction;
		this.photosUrl = photosUrl;
		this.tfloors = tfloors;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tbusinesscircles getTbusinesscircles() {
		return this.tbusinesscircles;
	}

	public void setTbusinesscircles(Tbusinesscircles tbusinesscircles) {
		this.tbusinesscircles = tbusinesscircles;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLng() {
		return this.lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return this.lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Integer getFloorCount() {
		return this.floorCount;
	}

	public void setFloorCount(Integer floorCount) {
		this.floorCount = floorCount;
	}

	public Integer getBusinessFloorCount() {
		return this.businessFloorCount;
	}

	public void setBusinessFloorCount(Integer businessFloorCount) {
		this.businessFloorCount = businessFloorCount;
	}

	public Timestamp getOpeningTimeStart() {
		return this.openingTimeStart;
	}

	public void setOpeningTimeStart(Timestamp openingTimeStart) {
		this.openingTimeStart = openingTimeStart;
	}

	public Timestamp getOpeningTimeEnding() {
		return this.openingTimeEnding;
	}

	public void setOpeningTimeEnding(Timestamp openingTimeEnding) {
		this.openingTimeEnding = openingTimeEnding;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getPhotosUrl() {
		return this.photosUrl;
	}

	public void setPhotosUrl(String photosUrl) {
		this.photosUrl = photosUrl;
	}

	public Set getTfloors() {
		return this.tfloors;
	}

	public void setTfloors(Set tfloors) {
		this.tfloors = tfloors;
	}

}