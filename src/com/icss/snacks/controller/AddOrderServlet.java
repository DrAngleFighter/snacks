package com.icss.snacks.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.snacks.entity.User;
import com.icss.snacks.service.CartService;
import com.icss.snacks.service.OrdersService;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
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
		 request.setCharacterEncoding("utf-8");
         User user = (User) request.getSession().getAttribute("user");
         Integer uid = user.getUid();
         Integer address_id = Integer.parseInt(request.getParameter("address_id"));
         String remark = request.getParameter("remark");
         Double total_price = Double.parseDouble(request.getParameter("total_price"));
         String cardIds = request.getParameter("cardIds");

          OrdersService orderService = new OrdersService();

          try {
             orderService.addOrder(address_id, remark, total_price, uid, cardIds);
         } catch (Exception e) {
             e.printStackTrace();
         }

          request.getRequestDispatcher("success.jsp").forward(request, response);
	}

}
