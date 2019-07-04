package com.icss.snacks.util;

import java.util.List;
/**
 * @author whn
 * 分页工具类
 */
public class PageUtil<T> {
	
	private Integer currentPage;//当前页码
	private Integer totalPage;//总页数 ：总记录数%每页显示==0?总记录数/每页显示:总记录数/每页显示+1
	private Integer count;//总记录数
	private List<T> list;//数据集合
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
