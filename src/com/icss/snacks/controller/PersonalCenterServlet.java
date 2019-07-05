package com.icss.snacks.controller;

import com.icss.snacks.entity.Account;
import com.icss.snacks.entity.Address;
import com.icss.snacks.entity.Orders;
import com.icss.snacks.entity.User;
import com.icss.snacks.service.AddressService;
import com.icss.snacks.service.PersonalCenterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PersonalCenterServlet")
public class PersonalCenterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        Account account = null;
        List<Orders> ordersList = null;
        PersonalCenterService personalCenterService = new PersonalCenterService();
        try {
            account = personalCenterService.findAccuoutByUid(user.getUid());
            ordersList = personalCenterService.findOrdersListByUid(user.getUid());
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        request.setAttribute("account", account);
        request.setAttribute("ordersList", ordersList);
        request.getRequestDispatcher("/person/index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
