package com.icss.snacks.service;

import java.util.List;

import com.icss.snacks.dao.CommodityDao;
import com.icss.snacks.entity.Commodity;
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
