package com.icss.snacks.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.snacks.entity.Category;
import com.icss.snacks.entity.Commodity;
import com.icss.snacks.service.CategoryService;
import com.icss.snacks.service.CommodityService;

/**
 * Servlet implementation class LatestCommdityServelet
 */
@WebServlet("/LatestCommdityServelet")
public class LatestCommdityServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LatestCommdityServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CommodityService commodityService = new CommodityService();
		List<Commodity> commodityList = null;
		CategoryService categoryService = new CategoryService();
		List<Category> categoryList = null;
		
		try {
			commodityList = commodityService.findLatestCommodityList();
			categoryList = categoryService.findAllCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		} 
		
		request.setAttribute("commodityList", commodityList);
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
