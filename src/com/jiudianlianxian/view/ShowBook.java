package com.jiudianlianxian.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiudianlianxian.database.DB;
import com.jiudianlianxian.domain.Book;

/**
 * 
 * Title: ShowBook
 * Description: ������һ������
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: MyCart
 * @author fupengpeng
 * @date 2017��7��26�� ����3:39:16
 *
 */
@WebServlet("/ShowBook")
public class ShowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBook() {
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
		
		out.println("<h1>��ӭ����</h1>");
		
		//ȡ��
		ArrayList<Book> mydb = DB.getDB();
		
		//����session
		request.getSession();
		for (Book book : mydb) {
			String url = response.encodeURL("/Mycart/BuyBookCL?id="+book.getId());
			//href='"/Mycart/BuyBookCL?JSESSID=45454545&id="+book.getId()'>�������</a>
			out.println(book.getName()+"<a href='"+url+"'>�������</a><br/>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
