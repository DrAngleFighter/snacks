package com.icss.snacks.entity;

/**
 * 
 * @author zly
 *
 */
public class CommodityParam {

	private Integer param_id;
	private String type;
	private String product_area;
	private String product_place;
	private String product_specification;
	private String expiration_date;
	private String usage;
	private String storage_method;
	private String standard_number;
	private String license_number;
	private String ingredients;

	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public Integer getParam_id() {
		return param_id;
	}
	public void setParam_id(Integer param_id) {
		this.param_id = param_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProduct_area() {
		return product_area;
	}
	public void setProduct_area(String product_area) {
		this.product_area = product_area;
	}
	public String getProduct_place() {
		return product_place;
	}
	public void setProduct_place(String product_place) {
		this.product_place = product_place;
	}
	public String getProduct_specification() {
		return product_specification;
	}
	public void setProduct_specification(String product_specification) {
		this.product_specification = product_specification;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getStorage_method() {
		return storage_method;
	}
	public void setStorage_method(String storage_method) {
		this.storage_method = storage_method;
	}
	public String getStandard_number() {
		return standard_number;
	}
	public void setStandard_number(String standard_number) {
		this.standard_number = standard_number;
	}
	public String getLicense_number() {
		return license_number;
	}
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}

	@Override
	public String toString() {
		return "CommodityParam[" +
				"param_id=" + param_id +
				", type='" + type + '\'' +
				", product_area='" + product_area + '\'' +
				", product_place='" + product_place + '\'' +
				", product_specification='" + product_specification + '\'' +
				", expiration_date='" + expiration_date + '\'' +
				", usage='" + usage + '\'' +
				", storage_method='" + storage_method + '\'' +
				", standard_number='" + standard_number + '\'' +
				", license_number='" + license_number + '\'' +
				", ingredients='" + ingredients + '\'' +
				']';
	}
}
