package com.etech.entity;

/**
 * Tgoodstype entity. @author MyEclipse Persistence Tools
 */

public class Tgoodstype implements java.io.Serializable {

	// Fields

	private Integer goodsTypeId;
	private Integer parentId;
	private String goodsTypeName;
	private String remark;

	// Constructors

	/** default constructor */
	public Tgoodstype() {
	}

	/** minimal constructor */
	public Tgoodstype(Integer parentId, String goodsTypeName) {
		this.parentId = parentId;
		this.goodsTypeName = goodsTypeName;
	}

	/** full constructor */
	public Tgoodstype(Integer parentId, String goodsTypeName, String remark) {
		this.parentId = parentId;
		this.goodsTypeName = goodsTypeName;
		this.remark = remark;
	}

	// Property accessors

	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getGoodsTypeName() {
		return this.goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}