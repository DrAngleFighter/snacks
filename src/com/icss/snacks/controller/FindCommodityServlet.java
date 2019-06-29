package com.icss.snacks.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.snacks.entity.Commodity;
import com.icss.snacks.service.CommodityService;

/**
 * Servlet implementation class FindCommodityServlet
 */
@WebServlet("/FindCommodityServlet")
public class FindCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCommodityServlet() {
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
		// ����ҳ���ύ�Ĳ���
		String commodity_id = request.getParameter("commodity_id");
		Integer id = 0;
		if (commodity_id != null && !"".equals(commodity_id)) {
			id = Integer.parseInt(commodity_id);
		}
		// ����ҵ��㷽�����д���		
		CommodityService commodityService = new CommodityService();
		Commodity commodity = null; 
		try {
			commodity = commodityService.findCommodityid(id);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		// ���ݴ���
		request.setAttribute("commodity", commodity);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

}
