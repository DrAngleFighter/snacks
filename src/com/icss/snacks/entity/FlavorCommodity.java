package com.icss.snacks.entity;

/**
 * 
 * @author zly
 *
 */
public class FlavorCommodity {

	private Integer id;
	private Integer fid;
	private Integer commodity_id;
	private Integer stock;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "FlavorCommodity [id=" + id + ", fid=" + fid + ", commodity_id=" + commodity_id + ", stock=" + stock
				+ "]";
	}
	
}
