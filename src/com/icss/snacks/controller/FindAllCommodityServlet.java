package com.icss.snacks.controller;

import com.icss.snacks.entity.Commodity;
import com.icss.snacks.service.CommodityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/FindAllCommodityServlet")
public class FindAllCommodityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommodityService commodityService = new CommodityService();
        List<Commodity> commodityList = new ArrayList<Commodity>();
        try {
            commodityList = commodityService.findAllCommodityList();
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.setAttribute("commodityList", commodityList);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
