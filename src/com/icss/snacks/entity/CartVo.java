package com.icss.snacks.entity;

public class CartVo {
	
	private Integer quantity;
	private String fname;
	private String cname;
	private double promotional_price;
	private String img;
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getPromotional_price() {
		return promotional_price;
	}
	public void setPromotional_price(double promotional_price) {
		this.promotional_price = promotional_price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "CartVo [quantity=" + quantity + ", fname=" + fname + ", cname=" + cname + ", promotional_price="
				+ promotional_price + ", img=" + img + "]";
	}
	
}
