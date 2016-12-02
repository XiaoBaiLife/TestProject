package com.chinasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.dao.GoodsDAO;
import com.chinasoft.entity.Goods;

public class PageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		//得到页面传递过来的页数
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		
		GoodsDAO dao = new GoodsDAO();
		//得到总行数
		int total = dao.getTotal();
		//求总页数
		//公式    每页显示3行  
		// 总页数 = (总行数+(每页显示的行数-1))/每页显示的行数
		int totalPage = (total+3-1)/3;
		

		//判断 传递过来的页数 不能大于最大页数 不能小于1
		if(pageNum <= totalPage && pageNum >=1 ){
			//查询对应页数的数据
			ArrayList<Goods> list = dao.getPage(pageNum);
			//session
			request.getSession().setAttribute("list", list);
			//将当前的页数放入session
			request.getSession().setAttribute("pageNum", pageNum);
			request.getSession().setAttribute("totalPage", totalPage);
		}
		
		response.sendRedirect("show.jsp");
		
	}

}
