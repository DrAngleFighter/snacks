package com.icss.snacks.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.snacks.entity.Commodity;
import com.icss.snacks.service.CommodityService;
import com.icss.snacks.util.PageUtil;

/**
 * Servlet implementation class FindCommodityByPageServlet
 */
@WebServlet("/FindCommodityByPageServlet")
public class FindCommodityByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCommodityByPageServlet() {
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
		
		// 接受页面提交参数
		String currentPage = request.getParameter("currentPage");
		Integer pageSize = 6;
		Integer page = 0;
		if (currentPage == null) {
			page = 1;
		} else {
			page = Integer.parseInt(currentPage);
		}
		
		
		// 调用业务层方法进行处理
		CommodityService commodityService = new CommodityService();
		PageUtil<Commodity> pageUtil = null; 
		try {
			pageUtil = commodityService.findAllCommodityByPage(page, pageSize);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		
		// 根据方法处理结果进行跳转
		request.setAttribute("pageUtil", pageUtil);
		request.getRequestDispatcher("back/foodlist.jsp").forward(request, response);
		
		
	}

}
