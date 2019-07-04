package com.icss.snacks.entity;

/**
 * 
 * @author zly
 *
 */

public class Address {

	private Integer address_id;
	private Integer uid; // 用户编号
	private String full_address;
	private String phone;
	private String zip_code;
	private String name;
	private Integer state;
	
	
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", uid=" + uid + ", full_address=" + full_address + ", phone="
				+ phone + ", zip_code=" + zip_code + ", name=" + name + ", state=" + state + "]";
	}
	
	
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getFull_address() {
		return full_address;
	}
	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
