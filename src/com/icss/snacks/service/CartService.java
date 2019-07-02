package com.icss.snacks.service;

import com.icss.snacks.dao.CartDao;
import com.icss.snacks.entity.Cart;
import com.icss.snacks.util.DbFactory;

public class CartService {

	private CartDao cartDao = new CartDao();
	
	public Integer addCart(Cart cart) throws Exception {
		Integer row = 0;
		
		try {
			row = cartDao.add(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}
		
		return row;
	}
	
	
}
