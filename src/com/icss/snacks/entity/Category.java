package com.icss.snacks.entity;

import java.util.List;

/**
 * 
 * @author zly
 *
 */

public class Category {

	private Integer category_id;
	private Integer category_parentid;
	private String name;
	private List<Category> subCategoryList; // 父类别和子类别一对多

	@Override
	public String toString() {
		return "Category[" +
				"category_id=" + category_id +
				", category_parentid=" + category_parentid +
				", name='" + name + '\'' +
				", subCategoryList=" + subCategoryList +
				']';
	}

	public List<Category> getSubCategoryList() {
		return subCategoryList;
	}
	public void setSubCategoryList(List<Category> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}
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

	
}
