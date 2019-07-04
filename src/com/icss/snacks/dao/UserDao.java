package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Commodity;
import com.icss.snacks.entity.User;
import com.icss.snacks.util.DbFactory;

/**
 * 
 * @author zly
 *
 */
public class UserDao {

	/**
	 * @param user
	 * @return row
	 * @throws Exception
	 */
	public Integer register(User user) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句 添加语句 "INSERT "
		String sql = "INSERT INTO tb_user(username, password, regtime) VALUE(?, ?, ?)";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setTimestamp(3, user.getRegtime());
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}
	
	/**
	 * 
	 * @param uid
	 * @return row
	 * @throws Exception
	 */
	public Integer deleteUser(Integer uid) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "DELETE FROM tb_user WHERE uid=?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, uid);
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;		
	}
	
	/**
	 * 
	 * @param user
	 * @return row
	 * @throws Exception
	 */
	public Integer updateUser(User user) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "UPDATE tb_user SET username = ? , password = ?, phone = ?, sex = ?, email = ? WHERE uid = ?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getPhone());
		ps.setString(4, user.getGender());
		ps.setString(5, user.getEmail());
		ps.setInt(6, user.getUid());
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}
	
	/**
	 * 
	 * @param uid
	 * @return user
	 * @throws Exception
	 */
	public User findUserByUid(Integer uid) throws Exception {
		User user = null;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_user WHERE uid=?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, uid);
		// 5. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 6. 将结果集中数据提取到对象属性中
		if(rs.next()) {
			user = new User();
			user.setUid(rs.getInt("uid"));
			user.setAccount_id(rs.getInt("account_id"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setRegtime(rs.getTimestamp("regtime"));
			user.setGender(rs.getString("sex"));
			user.setUsername(rs.getString("username"));
		}
		// 7. 释放资源
		rs.close();
		ps.close();
		return user;
		
	}
	
	
	/**
	 * 
	 * @return userList
	 * @throws Exception
	 */
	public List<User> findAllUserList() throws Exception {
		List<User> userList = new ArrayList<User>();
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_user";
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 5. 循环后去用户对象，添加到集合中
		while (rs.next()) {
			User user = new User();
			user.setUid(rs.getInt("uid"));
			user.setAccount_id(rs.getInt("account_id"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setRegtime(rs.getTimestamp("regtime"));
			user.setGender(rs.getString("sex"));
			user.setUsername(rs.getString("username"));
			userList.add(user);
		}
		// 6. 释放资源
		rs.close();
		ps.close();
		return userList;
	}

	
	/**
	 * 
	 * @return count
	 * @throws Exception
	 */
	public Integer findUserCount() throws Exception {
		Integer count = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT COUNT(*) FROM tb_user";
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 5. 循环后去用户对象，添加到集合中
		if (rs.next()) {
			count = rs.getInt(1);
		}
		// 6. 释放资源
		rs.close();
		ps.close();
		return count;
	}
	
	
	public User login(String username, String pwd) throws Exception {
		User user = null;
		Connection connection = DbFactory.openConnection();
		String sql = "SELECT * FROM tb_user WHERE username = ? AND password = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new User();
			user.setUid(rs.getInt("uid"));
			user.setAccount_id(rs.getInt("account_id"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setRegtime(rs.getTimestamp("regtime"));
			user.setGender(rs.getString("sex"));
			user.setUsername(rs.getString("username"));
		}
		rs.close();
		ps.close();
		return user;
	}

	public User checkName(String name) throws Exception {
		User user = null;
		Connection connection = DbFactory.openConnection();
		String sql = "SELECT * FROM tb_user WHERE username = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new User();
			user.setUid(rs.getInt("uid"));
			user.setAccount_id(rs.getInt("account_id"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setRegtime(rs.getTimestamp("regtime"));
			user.setGender(rs.getString("sex"));
			user.setUsername(rs.getString("username"));
		}
		rs.close();
		ps.close();
		return user;
	}


	public static void main(String[] args) {
		try {
			User user = new UserDao().login("whn", "123456");
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<User> findAllUserListByPage(Integer currentPage, Integer pageSize) throws Exception {
		List<User> userList = new ArrayList<User>();
		Connection connection = DbFactory.openConnection();
		String sql = "select u.regtime,u.phone,u.username,u.sex from tb_user u limit ?,?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, (currentPage - 1) * pageSize);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setPhone(rs.getString("phone"));
			user.setRegtime(rs.getTimestamp("regtime"));
			user.setGender(rs.getString("sex"));
			user.setUsername(rs.getString("username"));
			userList.add(user);
		}
		rs.close();
		ps.close();
		return userList;
	}
	
	public List<User> findAdminListByPage(Integer currentPage, Integer pageSize) throws Exception {
		List<User> userList = new ArrayList<User>();
		Connection connection = DbFactory.openConnection();
		String sql = "select u.password,u.phone,u.username,u.sex from tb_user u where u.username='admin' limit ?,?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, (currentPage - 1) * pageSize);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setPhone(rs.getString("phone"));
			user.setPassword(rs.getString("password"));
			user.setGender(rs.getString("sex"));
			user.setUsername(rs.getString("username"));
			userList.add(user);
		}
		rs.close();
		ps.close();
		return userList;
	}

}
