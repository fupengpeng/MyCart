package com.jiudianlianxian.database;

import java.util.ArrayList;

import com.jiudianlianxian.domain.Book;

/**
 * 
 * Title: DB
 * Description: ģ���ڴ����ݿ�
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: MyCart
 * @author fupengpeng
 * @date 2017��7��26�� ����5:04:36
 *
 */
public class DB {
	
	private static ArrayList al = null;
	private DB(){}
	static {
		al = new ArrayList<Book>();
		Book bookJava = new Book();
		bookJava.setId("1");
		bookJava.setName("java");
		
		Book bookOracle = new Book();
		bookOracle.setId("2");
		bookOracle.setName("oracle");
		
		Book bookC = new Book();
		bookC.setId("3");
		bookC.setName("C");
		
		al.add(bookJava);
		al.add(bookOracle);
		al.add(bookC);
	}
	
	public static ArrayList getDB(){
		return al;
	}
	public static Book getBookById(String id){
		
		Book book = null;
		boolean b = false;
		for (int i = 0; i < al.size(); i++) {
			book = (Book) al.get(i);
			if (book.getId().equals(id)) {
				b = true;
				break;
			}
			
		}
		if (b) {
			return book;
		}else {
			return null;
		}
		
		
	}
	

}
