package com.etech.entity;

public class TCountFavourite implements java.io.Serializable{
	
	private String favouriteName;
	private Double percent;
	private Integer xLocation;
	private Integer yLocation;
	private Integer row;
	
	
	public Integer getxLocation() {
		return xLocation;
	}
	public void setxLocation(Integer xLocation) {
		this.xLocation = xLocation;
	}
	public Integer getyLocation() {
		return yLocation;
	}
	public void setyLocation(Integer yLocation) {
		this.yLocation = yLocation;
	}
	public String getFavouriteName() {
		return favouriteName;
	}
	public void setFavouriteName(String favouriteName) {
		this.favouriteName = favouriteName;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	
	
	
}
