package com.icss.snacks.entity;

/**
 * 
 * @author zly
 *
 */

public class Category {

	private Integer category_id;
	private Integer category_parentid;
	private String name;
	
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getCategory_parentid() {
		return category_parentid;
	}
	public void setCategory_parentid(Integer category_parentid) {
		this.category_parentid = category_parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_parentid=" + category_parentid + ", name=" + name
				+ "]";
	}
	
}
