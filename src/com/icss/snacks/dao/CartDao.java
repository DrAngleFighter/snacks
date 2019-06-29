package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Cart;
import com.icss.snacks.util.DbFactory;

/**
 * 
 * @author zly
 *
 */
public class CartDao {

	/**
	 * 
	 * @param Cart
	 * @return row
	 * @throws Exception
	 */
	public Integer add(Cart cart) throws Exception {
		Integer row = 0;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL��� ������ "INSERT "
		String sql = "INSERT INTO tb_cart(uid, quantity, fid, commodity_id) VALUE(?, ?, ?, ?)";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, cart.getUid());
		ps.setInt(2, cart.getQuantity());
		ps.setInt(3, cart.getFid());
		ps.setInt(4, cart.getCommodity_id());
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "DELETE FROM tb_cart WHERE cart_id = ?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, cart_id);
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "UPDATE tb_cart SET uid = ?, quantity = ?, fid = ?, commodity_id = ? WHERE cart_id = ?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, cart.getUid());
		ps.setInt(2, cart.getQuantity());
		ps.setInt(3, cart.getFid());
		ps.setInt(4, cart.getCommodity_id());
		ps.setInt(5, cart.getCart_id());
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT * FROM tb_cart WHERE cart_id=?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, cart_id);
		// 5. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 6. ���������������ȡ������������
		if(rs.next()) {
			cart = new Cart();
			cart.setCart_id(rs.getInt("cart_id"));
			cart.setUid(rs.getInt("uid"));
			cart.setQuantity(rs.getInt("quantity"));
			cart.setFid(rs.getInt("fid"));
			cart.setCommodity_id(rs.getInt("commodity_id"));
		}
		// 7. �ͷ���Դ
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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT * FROM tb_cart";
		// 3. ����ִ��SQL������ӵ�������
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 5. ѭ����ȥ�û�������ӵ�������
		while (rs.next()) {
			Cart cart = new Cart();
			cart.setCart_id(rs.getInt("cart_id"));
			cart.setUid(rs.getInt("uid"));
			cart.setQuantity(rs.getInt("quantity"));
			cart.setFid(rs.getInt("fid"));
			cart.setCommodity_id(rs.getInt("commodity_id"));
			cartList.add(cart);
		}
		// 6. �ͷ���Դ
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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT COUNT(*) FROM tb_cart";
		// 3. ����ִ��SQL������ӵ�������
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 5. ѭ����ȥ�û�������ӵ�������
		if (rs.next()) {
			count = rs.getInt(1);
		}
		// 6. �ͷ���Դ
		rs.close();
		ps.close();
		return count;
	}
	
	public static void main (String[] args) throws Exception {
		Cart cart = new Cart();
		cart.setFid(12);
		cart.setCommodity_id(15);
		cart.setQuantity(134);
		cart.setUid(1);
		System.out.println(new CartDao().add(cart));
	}
	
}
