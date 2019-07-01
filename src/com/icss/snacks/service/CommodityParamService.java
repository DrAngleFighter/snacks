package com.icss.snacks.service;

import com.icss.snacks.dao.CommodityParamDao;
import com.icss.snacks.entity.CommodityParam;
import com.icss.snacks.util.DbFactory;

public class CommodityParamService {

    private CommodityParamDao commodityParamDao = new CommodityParamDao();

    public CommodityParam findAllCommodityParamById(int id) throws Exception {
        CommodityParam commodityParam = null;
        try {
            commodityParam = commodityParamDao.findCommodityParamByCommodityParam_id(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbFactory.closeConnection();
        }
        return commodityParam;
    }

}
