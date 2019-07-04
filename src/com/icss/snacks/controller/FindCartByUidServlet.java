package com.icss.snacks.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.snacks.entity.CartVo;
import com.icss.snacks.entity.User;
import com.icss.snacks.service.CartService;

/**
 * Servlet implementation class FindCartByUidServlet
 */
@WebServlet("/FindCartByUidServlet")
public class FindCartByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCartByUidServlet() {
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
		
		User user = (User) request.getSession().getAttribute("user");
		
		CartService cartService = new CartService();
		List<CartVo> list = null;
		
		try {
			list = cartService.findCartListByUid(user.getUid());
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		// 根据结果处理视图
		request.setAttribute("cartVoList", list);
		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
	}

}
