package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Flavor;
import com.icss.snacks.util.DbFactory;

/**
 * 
 * @author zly
 *
 */
public class FlavorDao {

	/**
	 * 
	 * @param flavor
	 * @return row
	 * @throws Exception
	 */
	public Integer add(Flavor flavor) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句 添加语句 "INSERT "
		String sql = "INSERT INTO tb_flavor(fname) VALUE(?)";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setString(1, flavor.getFname());
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}
	
	/**
	 * 
	 * @param fid
	 * @return row
	 * @throws Exception
	 */
	public Integer delete(Integer fid) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "DELETE FROM tb_flavor WHERE fid = ?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, fid);
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;		
	}
	
	
	/**
	 * 
	 * @param flavor
	 * @return row
	 * @throws Exception
	 */
	public Integer update(Flavor flavor) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "UPDATE tb_flavor SET fname = ? WHERE fid = ?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setString(1, flavor.getFname());
		ps.setInt(2, flavor.getFid());
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}
	
	
	/**
	 * 
	 * @param fid
	 * @return flavor
	 * @throws Exception
	 */
	public Flavor findByFlavorid(Integer fid) throws Exception {
		Flavor flavor = null;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_flavor WHERE fid=?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, fid);
		// 5. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 6. 将结果集中数据提取到对象属性中
		if(rs.next()) {
			flavor = new Flavor();
			flavor.setFid(rs.getInt("fid"));
			flavor.setFname(rs.getString("fname"));
		}
		// 7. 释放资源
		rs.close();
		ps.close();
		return flavor;
	}
	
	/**
	 * 
	 * @return flavorList
	 * @throws Exception
	 */
	public List<Flavor> findAll() throws Exception {
		List<Flavor> flavorList = new ArrayList<Flavor>();
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_flavor";
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 5. 循环后去用户对象，添加到集合中
		while (rs.next()) {
			Flavor flavor = new Flavor();
			flavor.setFid(rs.getInt("fid"));
			flavor.setFname(rs.getString("fname"));
			flavorList.add(flavor);
		}
		// 6. 释放资源
		rs.close();
		ps.close();
		return flavorList;
	}
	
	/**
	 * 
	 * @return count
	 * @throws Exception
	 */
	public Integer findCount() throws Exception {
		Integer count = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT COUNT(*) FROM tb_flavor";
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
	

	public List<Flavor> findFlavorListByCid(int cid) throws Exception {
		List<Flavor> flavorList = new ArrayList<Flavor>();
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_flavor INNER JOIN tb_flavor_commodity ON tb_flavor.fid = tb_flavor_commodity.fid AND tb_flavor_commodity.commodity_id=?";
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, cid);
		// 4. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 5. 循环后去用户对象，添加到集合中
		while (rs.next()) {
			Flavor flavor = new Flavor();
			flavor.setFid(rs.getInt("fid"));
			flavor.setFname(rs.getString("fname"));
			flavorList.add(flavor);
		}
		// 6. 释放资源
		rs.close();
		ps.close();
		return flavorList;
	}
	
public static void main (String[] args) throws Exception {
//		
//		Flavor flavor = new Flavor();
//		flavor.setFname("苦");
//		
		
//		FlavorDao flavorDao = new FlavorDao();
//		System.out.println(flavorDao.add(flavor));
//		System.out.println(flavorDao.delete(16));
//		flavor = flavorDao.findByFlavorid(2);
//		System.out.println(flavor);
//		flavor.setFid(15);
//		flavor.setFname("update");
//		System.out.println(flavor);
//		System.out.println(flavorDao.update(flavor));
//		System.out.println(flavorDao.findAll());
//		System.out.println(flavorDao.findByFlavorid(2));
//		System.out.println(flavorDao.findCount());
		
	}
	
}
