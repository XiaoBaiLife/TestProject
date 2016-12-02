package com.chinasoft.entity;

import java.io.Serializable;

public class Goods implements Serializable {
	
	private int gid;
	private String gname;
	private float price;
	private String  type;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Goods(int gid, String gname, float price, String type) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.price = price;
		this.type = type;
	}
	public Goods() {
		super();
	}
	
	
}
