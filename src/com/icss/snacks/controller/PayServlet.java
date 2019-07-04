package com.icss.snacks.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.snacks.entity.Address;
import com.icss.snacks.entity.CartVo;
import com.icss.snacks.entity.User;
import com.icss.snacks.service.AddressService;
import com.icss.snacks.service.CartService;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
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
		// 接受页面传递的参数
		User user = (User) request.getSession().getAttribute("user");
		Double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));  //总金额
		String cartIds = request.getParameter("cartId"); //用户勾选的购物车编号

		List<Address> list = null;
		List<CartVo> cartVoList = null;
		//调用业务层方法进行处理
		AddressService addressService = new AddressService();
		CartService cartService = new CartService();
		try {
			list = addressService.findAddressByUid(user.getUid());
			cartVoList = cartService.findCartListByUidAndCartId(user.getUid(), cartIds);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		//根据处理结果跳转页面
		request.setAttribute("addressList", list);
		request.setAttribute("cartVoList", cartVoList);
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartIds", cartIds);
		request.getRequestDispatcher("pay.jsp").forward(request, response);
	}

}
