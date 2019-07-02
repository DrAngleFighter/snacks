package com.icss.snacks.service;

import java.util.List;

import com.icss.snacks.dao.AddressDao;
import com.icss.snacks.entity.Address;
import com.icss.snacks.util.DbFactory;

public class AddressService {

	
	private AddressDao addressDao = new AddressDao();
	
	
	/**
	 * 
	 * @param uid
	 * @return list
	 * @throws Exception
	 */
	public List<Address> findAddressByUid(int uid) throws Exception{
		
		List<Address> list = null;
		
		try {
			list = addressDao.findAddressByUid(uid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}
		
		return list;
		
	}
	
	
}
