package com.icss.snacks.service;

import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.dao.CommodityDao;
import com.icss.snacks.dao.CommodityParamDao;
import com.icss.snacks.entity.Commodity;
import com.icss.snacks.entity.CommodityParam;
import com.icss.snacks.util.DbFactory;
import com.icss.snacks.util.PageUtil;

public class CommodityService {

	CommodityDao commodityDao = new CommodityDao();

	public List<Commodity> findLatestCommodityList() throws Exception {
		
		List<Commodity> list = null;
		
		try {
			list = commodityDao.findLatestCommodityList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}
		
		return list;
		
	}

	
	public Commodity findCommodityid(Integer cid) throws Exception {
		Commodity commodity = null;
		try {
			commodity = commodityDao.findByCommodityid(cid);
			CommodityParam commodityParam = new CommodityParamDao().findCommodityParamByCommodityParam_id(commodity.getParam_id()); //通过主键（commodity 外键）查询产品参数详情
			commodity.setCommodityParam(commodityParam);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}
		return commodity;
		
	}
	
	
	public PageUtil<Commodity> findAllCommodityByPage(Integer currentPage, Integer pageSize) throws Exception {
		
		PageUtil<Commodity> pageUtil = new PageUtil<Commodity>();
		List<Commodity> list = null;
		Integer count = 0;
		
		try {
			count = commodityDao.findCommodityCount();
			list = commodityDao.findAllCommodityListByPage(currentPage, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}
		
		Integer totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize +  1;
		
		pageUtil.setCount(count);
		pageUtil.setCurrentPage(currentPage);
		pageUtil.setList(list);
		pageUtil.setTotalPage(totalPage);
		return pageUtil;
		
	}

	public List<Commodity> findAllCommodityList() throws Exception {
		List<Commodity> commodityList = new ArrayList<Commodity>();
		try {
			commodityList = commodityDao.findAllCommodityList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbFactory.closeConnection();
		}
		return commodityList;
	}
	
	
	public Integer deleteCommodityById(Integer id) throws Exception {
		Integer row = 0;
		
		try {
			row = commodityDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}
		
		return row;
	}
	
//  // Pass
//	public static void main(String[] args) throws Exception {
//		System.out.println(new CommodityService().findCommodityid(1));
//	}
	
}
