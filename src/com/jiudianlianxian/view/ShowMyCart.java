package com.jiudianlianxian.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiudianlianxian.domain.Book;

/**
 * 
 * Title: ShowMyCart
 * Description: ������һ������
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: MyCart
 * @author fupengpeng
 * @date 2017��7��26�� ����3:39:41
 *
 */
@WebServlet("/ShowMyCart")
public class ShowMyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMyCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//��session��ȡ�������������
		HashMap<String,Book> myBooks = (HashMap<String, Book>) request.getSession().getAttribute("mybooks");
		
		out.println("���ُ��܇��һ������<br/>");
		
		//����hashMap
		Iterator iterator = myBooks.keySet().iterator();
		while (iterator.hasNext()) {
			String  key = (String) iterator.next();
			Book book = myBooks.get(key);
			out.println(book.getName()+"    "+book.getNum()+"<br/>");
			
		}
		//url��ַ��д
		String url = response.encodeURL("/MyCart/ShowBook");
		out.println("<a href='"+url+"'>���ع����̳Ǽ�������</a><br/>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
