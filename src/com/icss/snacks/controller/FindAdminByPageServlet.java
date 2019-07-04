package com.icss.snacks.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.snacks.entity.User;
import com.icss.snacks.service.UserService;
import com.icss.snacks.util.PageUtil;

/**
 * Servlet implementation class FindAdminByPageServlet
 */
@WebServlet("/FindAdminByPageServlet")
public class FindAdminByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAdminByPageServlet() {
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
		String currentPage = null;
		currentPage = request.getParameter("currentPage");
		Integer pageSize = 6;
		Integer page = 0;
		if (currentPage == null) {
			page = 1;
		} else {
			page = Integer.parseInt(currentPage);
		}
		
		
		// 调用业务层方法进行处理
		UserService userService = new UserService();
		PageUtil<User> pageUtil = null; 
		try {
			pageUtil = userService.findAdminByPage(page, pageSize);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		
		// 根据方法处理结果进行跳转

		request.setAttribute("pageUtil", pageUtil);
		request.getRequestDispatcher("back/accountlist.jsp").forward(request, response);
		}

}
