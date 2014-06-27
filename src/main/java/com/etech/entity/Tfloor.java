package com.etech.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tfloor entity. @author MyEclipse Persistence Tools
 */

public class Tfloor implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tcommercialbuilding tcommercialbuilding;
	private String name;
	private Integer floorNumber;
	private String introduction;
	private String photosUrl;
	private String mapPhotoUrl;
	private Set tshopses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tfloor() {
	}

	/** minimal constructor */
	public Tfloor(Tcommercialbuilding tcommercialbuilding, String name,
			Integer floorNumber) {
		this.tcommercialbuilding = tcommercialbuilding;
		this.name = name;
		this.floorNumber = floorNumber;
	}

	/** full constructor */
	public Tfloor(Tcommercialbuilding tcommercialbuilding, String name,
			Integer floorNumber, String introduction, String photosUrl,
			String mapPhotoUrl, Set tshopses) {
		this.tcommercialbuilding = tcommercialbuilding;
		this.name = name;
		this.floorNumber = floorNumber;
		this.introduction = introduction;
		this.photosUrl = photosUrl;
		this.mapPhotoUrl = mapPhotoUrl;
		this.tshopses = tshopses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tcommercialbuilding getTcommercialbuilding() {
		return this.tcommercialbuilding;
	}

	public void setTcommercialbuilding(Tcommercialbuilding tcommercialbuilding) {
		this.tcommercialbuilding = tcommercialbuilding;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFloorNumber() {
		return this.floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
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

	public String getMapPhotoUrl() {
		return this.mapPhotoUrl;
	}

	public void setMapPhotoUrl(String mapPhotoUrl) {
		this.mapPhotoUrl = mapPhotoUrl;
	}

	public Set getTshopses() {
		return this.tshopses;
	}

	public void setTshopses(Set tshopses) {
		this.tshopses = tshopses;
	}

}