package com.icss.snacks.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.snacks.entity.Cart;
import com.icss.snacks.entity.User;
import com.icss.snacks.service.CartService;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 接收页面传递参数
		String cid = request.getParameter("cid");
		// 口味编号
		String fid = request.getParameter("fid");
		// 数量
		String qua = request.getParameter("quantity");
		
		User user = (User) request.getSession().getAttribute("user");
		
		Integer commodity_id = cid != null && "".equals(cid) ? Integer.parseInt(cid) : 0;
		Integer flavor_id = fid != null && "".equals(fid) ? Integer.parseInt(fid) : 0;
		Integer quantity = qua != null && "".equals(qua) ? Integer.parseInt(qua) : 0;
		
		CartService cartService = new CartService();
		Cart cart = new Cart();
		cart.setCommodity_id(commodity_id);
		cart.setQuantity(quantity);
		cart.setFid(flavor_id);
		cart.setUid(user.getUid());
		
		try {
			cartService.addCart(cart);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		// TODO 自己购物车的Servlet
		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
		
	}

}
