package com.etech.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Tgoodstype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tgoodstype", catalog = "dbshop")
public class Tgoodstype implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -6327949680933534713L;
	private Integer goodsTypeId;
	private Integer parentId;
	private String goodsTypeName;
	private Short hasChild;
	private String remark;
	private Short sortOrderNo;
	private List<Tshop> shops=new ArrayList<Tshop>(0);
	private List<Tgoods> goodses=new ArrayList<Tgoods>(0);

	// Constructors

	/** default constructor */
	public Tgoodstype() {
	}

	/** minimal constructor */
	public Tgoodstype(Integer parentId, String goodsTypeName, Short hasChild,
			Short sortOrderNo) {
		this.parentId = parentId;
		this.goodsTypeName = goodsTypeName;
		this.hasChild = hasChild;
		this.sortOrderNo = sortOrderNo;
	}

	/** full constructor */
	public Tgoodstype(Integer parentId, String goodsTypeName, Short hasChild,
			String remark, Short sortOrderNo) {
		this.parentId = parentId;
		this.goodsTypeName = goodsTypeName;
		this.hasChild = hasChild;
		this.remark = remark;
		this.sortOrderNo = sortOrderNo;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "GoodsTypeID", unique = true, nullable = false)
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

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },mappedBy="goodsTypes")
	public List<Tshop> getShops() {
		return shops;
	}

	public void setShops(List<Tshop> shops) {
		this.shops = shops;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },mappedBy="goodsTypes")
	public List<Tgoods> getGoodses() {
		return goodses;
	}

	public void setGoodses(List<Tgoods> goodses) {
		this.goodses = goodses;
	}
	
	@Column(name = "SortOrderNo", nullable = false)
	public Short getSortOrderNo() {
		return this.sortOrderNo;
	}

	public void setSortOrderNo(Short sortOrderNo) {
		this.sortOrderNo = sortOrderNo;
	}
}