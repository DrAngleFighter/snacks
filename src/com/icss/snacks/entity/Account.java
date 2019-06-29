package com.icss.snacks.entity;

/**
 * 
 * @author zly
 *
 */

public class Account {

	private Integer account_id;
	private Integer uid;
	private Double money;
	
	@Override
	public String toString() {
		return "account [account_id=" + account_id + ", uid=" + uid + ", money=" + money + "]";
	}
	
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
	
	
}
