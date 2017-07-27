package com.jiudianlianxian.domain;

import java.io.Serializable;


/**
 * 
 * Title: Book
 * Description: 书
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: MyCart
 * @author fupengpeng
 * @date 2017年7月26日 下午5:05:05
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
