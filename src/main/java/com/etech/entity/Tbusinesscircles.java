package com.etech.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tbusinesscircles entity. @author MyEclipse Persistence Tools
 */

public class Tbusinesscircles implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String address;
	private Integer areaId;
	private Double lng;
	private Double lat;
	private String introduction;
	private String photosUrl;
	private Set tcommercialbuildings = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tbusinesscircles() {
	}

	/** minimal constructor */
	public Tbusinesscircles(String name, Integer areaId, Double lng, Double lat) {
		this.name = name;
		this.areaId = areaId;
		this.lng = lng;
		this.lat = lat;
	}

	/** full constructor */
	public Tbusinesscircles(String name, String address, Integer areaId,
			Double lng, Double lat, String introduction, String photosUrl,
			Set tcommercialbuildings) {
		this.name = name;
		this.address = address;
		this.areaId = areaId;
		this.lng = lng;
		this.lat = lat;
		this.introduction = introduction;
		this.photosUrl = photosUrl;
		this.tcommercialbuildings = tcommercialbuildings;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
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

	public Set getTcommercialbuildings() {
		return this.tcommercialbuildings;
	}

	public void setTcommercialbuildings(Set tcommercialbuildings) {
		this.tcommercialbuildings = tcommercialbuildings;
	}

}