package com.icss.snacks.entity;

import java.sql.Timestamp;

/**
 * 
 * @author zly
 *
 */
public class Commodity {

	private Integer commodity_id;
	private Integer category_id;
	private Integer brand_id;
	private String cname;
	private Double promotional_price;
	private Double original_price;
	private String description;
	private String img;
	private Timestamp createtime;
	private String brand_name;
	private String category_name;
	private Integer param_id;
	private Integer quantity;
	private Integer fid;
	private CommodityParam commodityParam; // 产品参数 产品和产品参数：一对一（实体）

	@Override
	public String toString() {
		return "Commodity[" +
				"commodity_id=" + commodity_id +
				", category_id=" + category_id +
				", brand_id=" + brand_id +
				", cname='" + cname + '\'' +
				", promotional_price=" + promotional_price +
				", original_price=" + original_price +
				", description='" + description + '\'' +
				", img='" + img + '\'' +
				", createtime=" + createtime +
				", brand_name='" + brand_name + '\'' +
				", category_name='" + category_name + '\'' +
				", param_id=" + param_id +
				", quantity=" + quantity +
				", fid=" + fid +
				", commodityParam=" + commodityParam +
				']';
	}

	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getParam_id() {
		return param_id;
	}
	public void setParam_id(Integer praram_id) {
		this.param_id = praram_id;
	}
	public CommodityParam getCommodityParam() {
		return commodityParam;
	}
	public void setCommodityParam(CommodityParam commodityParam) {
		this.commodityParam = commodityParam;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Integer getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(Integer commodity_id) {
		this.commodity_id = commodity_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Double getPromotional_price() {
		return promotional_price;
	}
	public void setPromotional_price(Double promotional_price) {
		this.promotional_price = promotional_price;
	}
	public Double getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(Double original_price) {
		this.original_price = original_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	
	
	
	
}
