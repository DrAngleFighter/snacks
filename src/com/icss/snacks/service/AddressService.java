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
	public List<Address> findAddressByUid(Integer uid) throws Exception{
		
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
	

	public Address findAddressByAddressId(Integer address_id) throws Exception {

		Address address = null;

		try {
			address = addressDao.findAddressByAddress_id(address_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}

		return address;

	}


}
