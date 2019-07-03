package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Orders;
import com.icss.snacks.util.DbFactory;

/**
 * 
 * @author phr
 *
 */
public class OrdersDao {

	/**
	 * Ìí¼Ó¶©µ¥
	 * @param orders
	 * @return row
	 * @throws Exception
	 */
	public int addOrders(Orders orders) throws Exception{
		int row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "INSERT INTO tb_orders(oid, uid, totalprice, ordertime, state, address_id, remark) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setString(1, orders.getOid());
        ps.setInt(2, orders.getUid());
        ps.setDouble(3, orders.getTotalprice());
        ps.setTimestamp(4, orders.getOrdertime());
        ps.setInt(5, orders.getState());
        ps.setInt(6, orders.getAddress_id());
        ps.setString(7, orders.getRemark());
        row = ps.executeUpdate();
        ps.close();
		return row;
	}
	
	
		
	public int deleteo(Orders orders) throws Exception{
		int row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "delete from tb_orders where oid=?";
	    PreparedStatement ps = connection.prepareStatement(sql)	;
	    ps.setString(1, orders.getOid());
	    row = ps.executeUpdate();
	    ps.close();		
	    return row;
		}
		
	public int updatao(Orders orders) throws Exception{
		int row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "update tb_orders set uid=?,totalprice=?,state=?,address_id=? where oid=?";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setInt(1, orders.getUid());
        ps.setDouble(2, orders.getTotalprice());
        ps.setInt(3, orders.getState());
        ps.setInt(4, orders.getAddress_id());
        ps.setString(5, orders.getOid());
        row = ps.executeUpdate();
        ps.close();
		return row;
	}
		
	public Orders findOrdersByOid(int oid) throws Exception{
		Orders orders = null;
		Connection connection = DbFactory.openConnection();
		String sql = "select * from tb_orders where oid=?";
	        PreparedStatement ps = connection.prepareStatement(sql)	;
	        ps.setInt(1, oid);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	        	orders = new Orders();
	        	orders.setOid(rs.getString("oid"));
	        	orders.setUid(rs.getInt("uid"));
	        	orders.setTotalprice(rs.getDouble("totalprice"));
	        	orders.setState(rs.getInt("state"));
	        	orders.setAddress_id(rs.getInt("address_id"));
	        	orders.setRemark(rs.getString("remark"));

	        }
	        ps.close();		
	        rs.close();	
	        return orders;
		}
		
	public List<Orders> findAllList() throws Exception{
		List<Orders> orderList =new ArrayList<Orders>();
		Connection connection = DbFactory.openConnection();
		String sql = "select * from tb_orders";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
        	Orders orders = new Orders();
        	orders = new Orders();
        	orders.setOid(rs.getString("oid"));
        	orders.setUid(rs.getInt("uid"));
        	orders.setTotalprice(rs.getDouble("totalprice"));
        	orders.setState(rs.getInt("state"));
        	orders.setAddress_id(rs.getInt("address_id"));
        	orders.setRemark(rs.getString("remark"));
        	orderList.add(orders);
        }
        ps.close();		
        rs.close();		
		return orderList;
	}
		

	}
	

