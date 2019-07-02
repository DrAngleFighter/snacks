package com.icss.snacks.service;

import java.util.List;

import com.icss.snacks.dao.CartDao;
import com.icss.snacks.entity.Cart;
import com.icss.snacks.entity.CartVo;
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
	
	
	public List<CartVo> findCartListByUid(Integer uid) throws Exception {
		
		List<CartVo> list = null;
		try {
			list = cartDao.findCartListByUid(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}
		return list;
		
	}
	
	
}
