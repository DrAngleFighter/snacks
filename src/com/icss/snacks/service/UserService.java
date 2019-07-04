package com.icss.snacks.service;

import java.util.List;

import com.icss.snacks.dao.UserDao;
import com.icss.snacks.entity.Commodity;
import com.icss.snacks.entity.User;
import com.icss.snacks.util.DbFactory;
import com.icss.snacks.util.PageUtil;

public class UserService {

	UserDao userDao = new UserDao();
	
	
	/**
	 * 	用户登录
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
	 *	用户注册
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

	public User checkName(String name) throws Exception {
		User user = null;
		try {
			user = userDao.checkName(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbFactory.closeConnection();
		}
		return user;
	}


	public PageUtil<User> findAllUserByPage(Integer currentPage, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageUtil<User> pageUtil = new PageUtil<User>();
		List<User> list = null;
		Integer count = 0;
		
		try {
			count = userDao.findUserCount();
			list = userDao.findAllUserListByPage(currentPage, pageSize);
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
	
	public PageUtil<User> findAdminByPage(Integer currentPage, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageUtil<User> pageUtil = new PageUtil<User>();
		List<User> list = null;
		Integer count = 0;
		
		try {
			count = userDao.findUserCount();
			list = userDao.findAdminListByPage(currentPage, pageSize);
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
	

}
