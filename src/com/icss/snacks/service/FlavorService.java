package com.icss.snacks.service;

import java.util.List;


import com.icss.snacks.dao.FlavorDao;
import com.icss.snacks.entity.Flavor;
import com.icss.snacks.util.DbFactory;

public class FlavorService {

		FlavorDao flavorDao = new FlavorDao();

		public List<Flavor> findFlavorList(int cid) throws Exception {
			
			List<Flavor> list = null;
			
			try {
				list = flavorDao.findFlavorListByCid(cid);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbFactory.closeConnection();
			}
			
			return list;
		}
	
}
