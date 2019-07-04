package com.icss.snacks.service;

import com.icss.snacks.dao.CartDao;
import com.icss.snacks.dao.CommodityDao;
import com.icss.snacks.dao.OrdersDao;
import com.icss.snacks.dao.OrdersDetailDao;
import com.icss.snacks.entity.Commodity;
import com.icss.snacks.entity.Orders;
import com.icss.snacks.entity.OrdersDetail;
import com.icss.snacks.util.DbFactory;
import com.icss.snacks.util.PageUtil;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OrderService {

    public void addOrder(Integer address_id, String remark, Double total_price, Integer uid, String cartIds) throws Exception {
        Logger logger = Logger.getLogger(this.getClass().getName());
        CartDao cartDao = new CartDao();
        OrdersDao ordersDao = new OrdersDao();
        OrdersDetailDao ordersDetailDao = new OrdersDetailDao();
        CommodityDao commodityDao = new CommodityDao();
        try {
            DbFactory.beginTransaction(); // 开启事务-设置手动控制事务

            // 订单表的添加
            String oid = UUID.randomUUID().toString();
            Orders orders = new Orders();
            orders.setOid(oid);
            orders.setOrdertime(new Timestamp(System.currentTimeMillis()));
            orders.setState(1);
            orders.setAddress_id(address_id);
            orders.setRemark(remark);
            orders.setTotalprice(total_price);
            orders.setUid(uid);
            ordersDao.addOrders(orders);

            cartIds = cartIds.substring(0, cartIds.length() - 1);

            String[] idArray = cartIds.split(",");
            List<OrdersDetail> ordersDetailList = new ArrayList<OrdersDetail>();
            for (int i = 0; i < idArray.length; i ++){
                // 调方法-通过购物车编号查询
                Integer cart_id = Integer.parseInt(idArray[i]);
                Commodity commodity = commodityDao.findByCommodityByCartId(cart_id);
                // 订单表的添加
                OrdersDetail ordersDetail = new OrdersDetail();
                ordersDetail.setBrand_id(commodity.getBrand_id());
                ordersDetail.setCommodity_id(commodity.getCommodity_id());
                ordersDetail.setFid(commodity.getFid());
                ordersDetail.setOid(oid);
                ordersDetail.setPrice(commodity.getPromotional_price());
                ordersDetail.setQuantity(commodity.getQuantity());
                ordersDetailDao.addOrderDetail(ordersDetail);
                ordersDetailList.add(ordersDetail);
            }

            // 购物车表的删除
            cartDao.deleteCart(cartIds);
            orders.setOrdersDetailList(ordersDetailList);
            logger.info(orders);

            orders.setOrdersDetailList(ordersDetailList);
            logger.info(orders);

            DbFactory.commit(); // 事务提交
        } catch (Exception e) {
            DbFactory.rollback(); // 事务回滚
            e.printStackTrace();
        } finally {
            DbFactory.closeConnection();
        }
    }
    
    
    
	public PageUtil<Orders> findOrdersByPage(Integer currentPage, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
        OrdersDao ordersDao = new OrdersDao();
		PageUtil<Orders> pageUtil = new PageUtil<Orders>();
		List<Orders> list = null;
		Integer count = 0;
		
		try {
			count = ordersDao.findOrdersCount();
			list = ordersDao.findOrdersListByPage(currentPage, pageSize);
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
