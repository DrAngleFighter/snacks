package com.icss.snacks.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
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
		//设置请求参数编码格式（解决post请求乱码问题）
		request.setCharacterEncoding("GBK");
		try {
			//实例化组件
			SmartUpload smartUpload = new SmartUpload();
			//初始化
			smartUpload.initialize(getServletConfig(), request, response);
			//上传
			smartUpload.upload();
			//获取上传的文件列表
			Files files = smartUpload.getFiles();
			//获取上传的图片文件
			File file = files.getFile(0);
			//保存文件
			file.saveAs("d:/img/"+file.getFileName());
			
			
			String name = smartUpload.getRequest().getParameter("name");
			System.out.println(name);
			
			String brandid = smartUpload.getRequest().getParameter("brand_id");
			System.out.println(brandid);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
	}

}
