package com.icss.snacks.controller;

import com.icss.snacks.entity.Brand;
import com.icss.snacks.entity.Category;
import com.icss.snacks.entity.Commodity;
import com.icss.snacks.service.BrandService;
import com.icss.snacks.service.CategoryService;
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
        BrandService brandService = new BrandService();
        CategoryService categoryService = new CategoryService();

        List<Commodity> commodityList = new ArrayList<Commodity>();
        List<Brand> brandList = new ArrayList<Brand>();
        List<Category> categoryList = new ArrayList<Category>();

        try {
            commodityList = commodityService.findAllCommodityList();
            brandList = brandService.findAllBrandList();
            categoryList = categoryService.findAllCategory();

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.setAttribute("commodityList", commodityList);
        request.setAttribute("brandList", brandList);
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
