package com.jiudianlianxian.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiudianlianxian.database.DB;
import com.jiudianlianxian.domain.Book;

/**
 * 
 * Title: BuyBookCL
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: MyCart
 * @author fupengpeng
 * @date 2017年7月26日 下午3:38:38
 *
 */
@WebServlet("/BuyBookCL")
public class BuyBookCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyBookCL() {
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
		
		//接收用戶購買書的名字
		String id = request.getParameter("id");
		Book bookinfo = DB.getBookById(id);
		HttpSession session = request.getSession();
		
		//从session中获取mybooks
		
		HashMap<String,Book> hm =  (HashMap<String, Book>) session.getAttribute("mybooks");
		//如果是第一次购物   al = null
		if (hm == null) {
			hm = new LinkedHashMap<String,Book>();
			Book book = new Book();
			book.setId(id);
			book.setName(bookinfo.getName());
			book.setNum(1);
			hm.put(id, book);
			session.setAttribute("mybooks", hm);
		}else{
			//判断hm中是否有该书
			if (hm.containsKey(id)) {
				//表示购买过一次
				//取出id对应的book对象
				Book book = hm.get(id);
				int bookNum = book.getNum();
				book.setNum(bookNum+1);
			}else{
				Book book = new Book();
				book.setId(id);
				book.setName(bookinfo.getName());
				book.setNum(1);
				hm.put(id, book);
				
			}
			session.setAttribute("mybooks", hm);
		}
		
		
		
		//跳转到购物车显示界面
		request.getRequestDispatcher("/ShowMyCart").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
