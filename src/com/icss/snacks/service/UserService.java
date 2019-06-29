package com.icss.snacks.service;

import com.icss.snacks.dao.UserDao;
import com.icss.snacks.entity.User;
import com.icss.snacks.util.DbFactory;

public class UserService {

	UserDao userDao = new UserDao();
	
	
	/**
	 * 	�û���¼
	 * @param username
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public User login(String username, String pwd) throws Exception {
		User user = null;
		try {
			user = userDao.login(username, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}
		return user;
	}
	
	
	/**
	 *	�û�ע��
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer register(User user) throws Exception{
		Integer row = 0;
		
		try {
			row = userDao.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}
		
		return row;
	}
}
