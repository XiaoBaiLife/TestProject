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
		
		//�õ�ҳ�洫�ݹ�����ҳ��
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		
		GoodsDAO dao = new GoodsDAO();
		//�õ�������
		int total = dao.getTotal();
		//����ҳ��
		//��ʽ    ÿҳ��ʾ3��  
		// ��ҳ�� = (������+(ÿҳ��ʾ������-1))/ÿҳ��ʾ������
		int totalPage = (total+3-1)/3;
		

		//�ж� ���ݹ�����ҳ�� ���ܴ������ҳ�� ����С��1
		if(pageNum <= totalPage && pageNum >=1 ){
			//��ѯ��Ӧҳ��������
			ArrayList<Goods> list = dao.getPage(pageNum);
			//session
			request.getSession().setAttribute("list", list);
			//����ǰ��ҳ������session
			request.getSession().setAttribute("pageNum", pageNum);
			request.getSession().setAttribute("totalPage", totalPage);
		}
		
		response.sendRedirect("show.jsp");
		
	}

}
