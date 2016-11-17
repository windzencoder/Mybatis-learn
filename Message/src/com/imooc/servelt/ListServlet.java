package com.imooc.servelt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Message;
import com.imooc.service.ListService;

/**
 * 列表页面初始化控制
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//中文乱码
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//查询消息列表并传给页面
		ListService listService = new ListService();
		List<Message> messageList = listService.queryMessageList(command, description);
		req.setAttribute("messageList", messageList);
		//跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
