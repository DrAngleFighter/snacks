package com.icss.snacks.service;

import java.sql.Timestamp;
import java.util.UUID;

import com.icss.snacks.dao.CartDao;
import com.icss.snacks.dao.CommodityDao;
import com.icss.snacks.dao.OrdersDao;
import com.icss.snacks.dao.OrdersDetailDao;
import com.icss.snacks.entity.Commodity;
import com.icss.snacks.entity.Orders;
import com.icss.snacks.entity.OrdersDetail;
import com.icss.snacks.util.DbFactory;

public class OrdersService {

	public void addOrder(int address_id,String remark,double totalprice,int uid,String cartIds) throws Exception {
		
		CartDao cartDao = new CartDao();
		OrdersDao ordersDao = new OrdersDao();
		OrdersDetailDao ordersDetailDao = new OrdersDetailDao ();
		try {
			DbFactory.beginTransaction();
			String oid = UUID.randomUUID().toString();
			Orders orders = new Orders();//订单表的添加
			ordersDao.addo(orders);	
			orders.setAddress_id(address_id);
			orders.setOid(oid);
			orders.setOrdertime(new Timestamp(System.currentTimeMillis()));
			orders.setRemark(remark);
			orders.setState(1);
			orders.setTotalprice(totalprice);
			orders.setUid(uid);
			cartIds = cartIds.substring(0,cartIds.length()-1);
					
			String[] idArray = cartIds.split(",");
			//订单详情表的添加
			CommodityDao commodityDao = new CommodityDao();
			for(int i=0;i<idArray.length;i++) {
				int cart_id = Integer.parseInt(idArray[1]);
			Commodity commodity = commodityDao.findCommodityByCartId(cart_id);
			OrdersDetail ordersDetail = new OrdersDetail();
			ordersDetail.setBrand_id(commodity.getBrand_id());
			ordersDetail.setCommodity_id(commodity.getCommodity_id());
			ordersDetail.setFid(commodity.getFid());
			ordersDetail.setOid(oid);
			ordersDetail.setPrice(commodity.getPromotional_price());
			ordersDetail.setQuantity(commodity.getQuantity());
			ordersDetailDao.addOrderDetail(ordersDetail);
			
			//购物车表的删除
			cartDao.deleteCart(cartIds);

			
			}
			DbFactory.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DbFactory.rollback();
			e.printStackTrace();
		}finally {
			DbFactory.closeConnection();
		}
	}
	
	
}
