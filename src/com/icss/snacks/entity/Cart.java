package com.icss.snacks.entity;

/**
 * 
 * @author zly
 *
 */
public class Cart {

	private Integer cart_id;
	private Integer uid;
	private Integer quantity;
	private Integer fid;
	private Integer commodity_id;
	
	public Integer getCart_id() {
		return cart_id;
	}
	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Integer getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(Integer commodity_id) {
		this.commodity_id = commodity_id;
	}
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", uid=" + uid + ", quantity=" + quantity + ", fid=" + fid
				+ ", commodity_id=" + commodity_id + "]";
	}
	
}
