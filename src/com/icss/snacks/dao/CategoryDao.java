package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Category;
import com.icss.snacks.util.DbFactory;

/**
 * 
 * @author zly
 *
 */
public class CategoryDao {

	/**
	 * 
	 * @param category
	 * @return row
	 * @throws Exception
	 */
	public Integer add(Category category) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句 添加语句 "INSERT "
		String sql = "INSERT INTO tb_category(category_parentid, name) VALUE(?, ?)";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, category.getCategory_parentid());
		ps.setString(2, category.getName());
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}
	
	/**
	 * 
	 * @param category_id
	 * @return row
	 * @throws Exception
	 */
	public Integer delete(Integer category_id) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "DELETE FROM tb_category WHERE category_id = ?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, category_id);
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;		
	}
	
	/**
	 * 
	 * @param category
	 * @return row
	 * @throws Exception
	 */
	public Integer update(Category category) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "UPDATE tb_category SET category_parentid = ?, name = ? WHERE category_id = ?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, category.getCategory_parentid());
		ps.setString(2, category.getName());
		ps.setInt(3, category.getCategory_id());
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}
	
	
	/**
	 * 
	 * @param category_id
	 * @return category
	 * @throws Exception
	 */
	public Category findByCategoryid(Integer category_id) throws Exception {
		Category category = null;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_category WHERE category_id=?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, category_id);
		// 5. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 6. 将结果集中数据提取到对象属性中
		if(rs.next()) {
			category = new Category();
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_parentid(rs.getInt("category_parentid"));
			category.setName(rs.getString("name"));
		}
		// 7. 释放资源
		rs.close();
		ps.close();
		return category;
	}
	
	/**
	 * 
	 * @return categoryList
	 * @throws Exception
	 */
	public List<Category> findAll() throws Exception {
		List<Category> categoryList = new ArrayList<Category>();
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_category";
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 5. 循环后去用户对象，添加到集合中
		while (rs.next()) {
			Category category = new Category();
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_parentid(rs.getInt("category_parentid"));
			category.setName(rs.getString("name"));
			categoryList.add(category);
		}
		// 6. 释放资源
		rs.close();
		ps.close();
		return categoryList;
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
		String sql = "SELECT COUNT(*) FROM tb_category";
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

	public List<Category> findByParentId(Integer parent_id) throws Exception {
		List<Category> categoryList = new ArrayList<Category>();
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_category WHERE category_parentid = ?";
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, parent_id);
		// 5. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 6. 循环后去用户对象，添加到集合中
		while (rs.next()) {
			Category category = new Category();
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_parentid(rs.getInt("category_parentid"));
			category.setName(rs.getString("name"));
			categoryList.add(category);
		}

		rs.close();
		ps.close();
		return categoryList;
	}
	public List<Category> findCategoryListByBrandId(int brand_id) throws Exception {
		List<Category> categoryList = new ArrayList<Category>();
		Connection connection = DbFactory.openConnection();
		String sql = "SELECT DISTINCT" +
				" category.*" +
				" FROM" +
				" `tb_brand` b" +
				" INNER JOIN `tb_commodity` commodity ON commodity.brand_id = b.brand_id" +
				" INNER JOIN `tb_category` category ON category.category_id = commodity.category_id AND category.category_parentid = 0" +
				" WHERE" +
				" b.brand_id = ?;";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, brand_id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Category category = new Category();
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_parentid(rs.getInt("category_parentid"));
			category.setName(rs.getString("name"));
			categoryList.add(category);
		}
		
		rs.close();
		ps.close();
		return categoryList;
	}

}
