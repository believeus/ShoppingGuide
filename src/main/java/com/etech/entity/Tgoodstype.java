package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tgoodstype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tgoodstype", catalog = "dbshop")
public class Tgoodstype implements java.io.Serializable {

	// Fields

	private Integer goodsTypeId;
	private Integer parentId;
	private String goodsTypeName;
	private Short hasChild;
	private String remark;

	// Constructors

	/** default constructor */
	public Tgoodstype() {
	}

	/** minimal constructor */
	public Tgoodstype(Integer parentId, String goodsTypeName, Short hasChild) {
		this.parentId = parentId;
		this.goodsTypeName = goodsTypeName;
		this.hasChild = hasChild;
	}

	/** full constructor */
	public Tgoodstype(Integer parentId, String goodsTypeName, Short hasChild,
			String remark) {
		this.parentId = parentId;
		this.goodsTypeName = goodsTypeName;
		this.hasChild = hasChild;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "GoodsTypeID", nullable = false)
	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	@Column(name = "ParentID", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "GoodsTypeName", nullable = false, length = 50)
	public String getGoodsTypeName() {
		return this.goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

	@Column(name = "HasChild", nullable = false)
	public Short getHasChild() {
		return this.hasChild;
	}

	public void setHasChild(Short hasChild) {
		this.hasChild = hasChild;
	}

	@Column(name = "Remark", length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}