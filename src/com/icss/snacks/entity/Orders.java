package com.icss.snacks.entity;

import java.sql.Timestamp;

/**
 * 
 * @author zly
 *
 */
public class Orders {

	private String oid;
	private Integer uid;
	private Double totalprice;
	private String remark;
	private Timestamp ordertime;
	private Integer state;
	private Integer address_id;
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", uid=" + uid + ", totalprice=" + totalprice + ", remark=" + remark
				+ ", ordertime=" + ordertime + ", state=" + state + ", address_id=" + address_id + "]";
	}
	
	
}
