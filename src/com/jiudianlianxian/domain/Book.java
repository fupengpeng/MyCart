package com.jiudianlianxian.domain;

import java.io.Serializable;


/**
 * 
 * Title: Book
 * Description: ��
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: MyCart
 * @author fupengpeng
 * @date 2017��7��26�� ����5:05:05
 *
 */
public class Book implements Serializable{
	
	private String id;
	private String name;
	private int num;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	

}
