package com.imooc.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Message;
import com.imooc.service.MaintainService;

/**
 * 单条删除Servlet
 *
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//中文乱码
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");

		MaintainService maintainService = new MaintainService();
		boolean flag = maintainService.deleteOne(id);
		//是否删除成功
		req.setAttribute("deleteStatus",String.valueOf(flag));
		
		//跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
