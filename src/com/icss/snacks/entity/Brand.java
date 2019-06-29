package com.icss.snacks.entity;

/**
 * 
 * @author zly
 *
 */
public class Brand {

	private Integer brand_id;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String state;
	
	@Override
	public String toString() {
		return "Brand [brand_id=" + brand_id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", state=" + state + "]";
	}
	
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
