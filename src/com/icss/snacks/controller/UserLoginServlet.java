package com.icss.snacks.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.snacks.entity.User;
import com.icss.snacks.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserLoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		UserService userService = new UserService();
		User user;
		try {
			user = userService.login(username, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		
		if(user == null) {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (user.getUsername().equals("admin")) {
			request.getSession().setAttribute("user", user);  // 一次会话多次请求多次响应
			request.getRequestDispatcher("back/index.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("user", user);  // 一次会话多次请求多次响应
			request.getRequestDispatcher("LatestCommdityServlet").forward(request, response);
		}
		
	}

}
