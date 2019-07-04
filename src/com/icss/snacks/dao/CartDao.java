package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Cart;
import com.icss.snacks.entity.CartVo;
import com.icss.snacks.util.DbFactory;

/**
 * 
 * @author zly
 *
 */
public class CartDao {

	/**
	 *
	 * @return row
	 * @throws Exception
	 */
	public Integer add(Cart cart) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句 添加语句 "INSERT "
		String sql = "INSERT INTO tb_cart(uid, quantity, fid, commodity_id) VALUE(?, ?, ?, ?)";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, cart.getUid());
		ps.setInt(2, cart.getQuantity());
		ps.setInt(3, cart.getFid());
		ps.setInt(4, cart.getCommodity_id());
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}
	
	
	/**
	 * 
	 * @param cart_id
	 * @return row
	 * @throws Exception
	 */
	public Integer delete(Integer cart_id) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "DELETE FROM tb_cart WHERE cart_id = ?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, cart_id);
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}


	public Integer deleteCart(String cartIds) throws Exception {

		Integer row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "DELETE FROM tb_cart WHERE cart_id IN("+ cartIds +") ";
		PreparedStatement ps = connection.prepareStatement(sql);
		row = ps.executeUpdate();
		ps.close();
		return row;

	}
	
	
	/**
	 * 
	 * @param cart
	 * @return row
	 * @throws Exception
	 */
	public Integer update(Cart cart) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "UPDATE tb_cart SET uid = ?, quantity = ?, fid = ?, commodity_id = ? WHERE cart_id = ?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, cart.getUid());
		ps.setInt(2, cart.getQuantity());
		ps.setInt(3, cart.getFid());
		ps.setInt(4, cart.getCommodity_id());
		ps.setInt(5, cart.getCart_id());
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}
	
	
	public Integer updateQuantity(Cart cart) throws Exception {
		Integer row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "UPDATE tb_cart SET quantity = quantity+? WHERE fid = ? and commodity_id = ? and uid = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, cart.getQuantity());
		ps.setInt(2, cart.getFid());
		ps.setInt(3, cart.getCommodity_id());
		ps.setInt(4, cart.getUid());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	
	
	/**
	 * 
	 * @param cart_id
	 * @return cart
	 * @throws Exception
	 */
	public Cart findByCartid(Integer cart_id) throws Exception {
		Cart cart = null;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_cart WHERE cart_id=?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, cart_id);
		// 5. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 6. 将结果集中数据提取到对象属性中
		if(rs.next()) {
			cart = new Cart();
			cart.setCart_id(rs.getInt("cart_id"));
			cart.setUid(rs.getInt("uid"));
			cart.setQuantity(rs.getInt("quantity"));
			cart.setFid(rs.getInt("fid"));
			cart.setCommodity_id(rs.getInt("commodity_id"));
		}
		// 7. 释放资源
		rs.close();
		ps.close();
		return cart;
	}
	
	/**
	 * 
	 * @return cartList
	 * @throws Exception
	 */
	public List<Cart> findAll() throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_cart";
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 5. 循环后去用户对象，添加到集合中
		while (rs.next()) {
			Cart cart = new Cart();
			cart.setCart_id(rs.getInt("cart_id"));
			cart.setUid(rs.getInt("uid"));
			cart.setQuantity(rs.getInt("quantity"));
			cart.setFid(rs.getInt("fid"));
			cart.setCommodity_id(rs.getInt("commodity_id"));
			cartList.add(cart);
		}
		// 6. 释放资源
		rs.close();
		ps.close();
		return cartList;
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
		String sql = "SELECT COUNT(*) FROM tb_cart";
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
	
	
	public List<CartVo> findCartListByUid(Integer uid) throws Exception {
		List<CartVo> cartVoList = new ArrayList<CartVo>();
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
<<<<<<< HEAD
		// 2. 编写SQL语句
=======
		// 2. ��дSQL���
>>>>>>> 3a9ce3c4781ab9423d4c2b7ca3f236c5bf41ddee
		String sql = "SELECT cart.cart_id, c.cname, c.img, c.promotional_price, f.fname, cart.quantity FROM tb_cart cart " +
					"INNER JOIN tb_commodity c ON c.commodity_id = cart.commodity_id " + 
					"INNER JOIN tb_flavor f ON f.fid = cart.fid " + 
					"WHERE cart.uid = ?";
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, uid);
		// 5. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 6. 循环后去用户对象，添加到集合中
		while (rs.next()) {
			CartVo cartVo = new CartVo();
			cartVo.setCname(rs.getString("cname"));
			cartVo.setFname(rs.getString("fname"));
			cartVo.setQuantity(rs.getInt("quantity"));
			cartVo.setImg(rs.getString("img"));
			cartVo.setPromotional_price(rs.getDouble("promotional_price"));
			cartVo.setCart_id(rs.getInt("cart_id"));
			cartVoList.add(cartVo);
		}
		// 7. 释放资源
		rs.close();
		ps.close();
		return cartVoList;
	}


	public List<CartVo> findCartListByUidAndCartId(Integer uid, String cartIds) throws Exception {
		List<CartVo> cartVoList = new ArrayList<CartVo>();
<<<<<<< HEAD
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
=======
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
>>>>>>> 3a9ce3c4781ab9423d4c2b7ca3f236c5bf41ddee
		String sql = "SELECT cart.cart_id, c.cname, c.img, c.promotional_price, f.fname, cart.quantity FROM tb_cart cart " +
					"INNER JOIN tb_commodity c ON c.commodity_id = cart.commodity_id " +
					"INNER JOIN tb_flavor f ON f.fid = cart.fid " +
					"WHERE cart.uid = ? AND cart.cart_id in (";

		String[] cartIdArray = cartIds.split(",");
		for (int i = 0; i < cartIdArray.length; i ++) {
			Integer cart_id = Integer.parseInt(cartIdArray[i]);
			sql += cart_id;
			if (i != cartIdArray.length - 1) {
				sql += ", ";
			}
		}
		sql += ")";
<<<<<<< HEAD
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, uid);
		// 5. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 6. 循环后去用户对象，添加到集合中
=======
		// 3. ����ִ��SQL�������ӵ�������
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, uid);
		// 5. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 6. ѭ����ȥ�û��������ӵ�������
>>>>>>> 3a9ce3c4781ab9423d4c2b7ca3f236c5bf41ddee
		while (rs.next()) {
			CartVo cartVo = new CartVo();
			cartVo.setCname(rs.getString("cname"));
			cartVo.setFname(rs.getString("fname"));
			cartVo.setQuantity(rs.getInt("quantity"));
			cartVo.setImg(rs.getString("img"));
			cartVo.setPromotional_price(rs.getDouble("promotional_price"));
			cartVo.setCart_id(rs.getInt("cart_id"));
			cartVoList.add(cartVo);
		}
<<<<<<< HEAD
		// 7. 释放资源
=======
		// 7. �ͷ���Դ
>>>>>>> 3a9ce3c4781ab9423d4c2b7ca3f236c5bf41ddee
		rs.close();
		ps.close();
		return cartVoList;
	}


	
	public Integer findQuantity(Cart cart) throws Exception {
		Integer count = 0;		
		Connection connection = DbFactory.openConnection();
		String sql = "select COUNT(*) from tb_cart cart where uid = ? and fid = ? and commodity_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, cart.getUid());
		ps.setInt(2, cart.getFid());
		ps.setInt(3, cart.getCommodity_id());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}
		rs.close();
		ps.close();
		return count;
	}
	
//	public static void main (String[] args) throws Exception {
//		Cart cart = new Cart();
//		cart.setFid(12);
//		cart.setCommodity_id(15);
//		cart.setQuantity(134);
//		cart.setUid(1);
//		System.out.println(new CartDao().add(cart));
//	}
//	
}
