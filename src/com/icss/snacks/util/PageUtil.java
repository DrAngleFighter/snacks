package com.icss.snacks.util;

import java.util.List;
/**
 * @author whn
 * ��ҳ������
 */
public class PageUtil<T> {
	
	private Integer currentPage;//��ǰҳ��
	private Integer totalPage;//��ҳ�� ���ܼ�¼��%ÿҳ��ʾ==0?�ܼ�¼��/ÿҳ��ʾ:�ܼ�¼��/ÿҳ��ʾ+1
	private Integer count;//�ܼ�¼��
	private List<T> list;//���ݼ���
	
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
