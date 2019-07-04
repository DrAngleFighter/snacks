package com.icss.snacks.service;

import com.icss.snacks.dao.CartDao;
import com.icss.snacks.dao.CommodityDao;
import com.icss.snacks.dao.OrdersDao;
import com.icss.snacks.dao.OrdersDetailDao;
import com.icss.snacks.entity.Commodity;
import com.icss.snacks.entity.Orders;
import com.icss.snacks.entity.OrdersDetail;
import com.icss.snacks.util.DbFactory;
import org.apache.log4j.Logger;

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
            DbFactory.beginTransaction(); // ��������-�����ֶ���������

            // ������������
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
                // ������-ͨ�����ﳵ��Ų�ѯ
                Integer cart_id = Integer.parseInt(idArray[i]);
                Commodity commodity = commodityDao.findByCommodityByCartId(cart_id);
                // ������������
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

            // ���ﳵ����ɾ��
            cartDao.deleteCart(cartIds);
            orders.setOrdersDetailList(ordersDetailList);
            logger.info(orders);

            orders.setOrdersDetailList(ordersDetailList);
            logger.info(orders);

            DbFactory.commit(); // �����ύ
        } catch (Exception e) {
            DbFactory.rollback(); // ����ع�
            e.printStackTrace();
        } finally {
            DbFactory.closeConnection();
        }
    }

}
