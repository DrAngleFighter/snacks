package com.icss.snacks.entity;

/**
 * 
 * @author zly
 *
 */
public class OrdersDetail {

	private Integer detail_id;
	private Integer commodity_id;
	private Integer quantity;
	private Double price;
	private Integer fid;
	private Integer brand_id;
	private String oid;
	
	public Integer getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(Integer detail_id) {
		this.detail_id = detail_id;
	}
	public Integer getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(Integer commodity_id) {
		this.commodity_id = commodity_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}

	@Override
	public String toString() {
		return "OrdersDetail[" +
				"detail_id=" + detail_id +
				", commodity_id=" + commodity_id +
				", quantity=" + quantity +
				", price=" + price +
				", fid=" + fid +
				", brand_id=" + brand_id +
				", oid='" + oid + '\'' +
				']';
	}
}
