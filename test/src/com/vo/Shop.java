package com.vo;

public class Shop {
  private int shopid; 
  private String sellerid;
  private String shopname;  
  private String shopcreated;
public int getShopid() {
	return shopid;
}
public void setShopid(int shopid) {
	this.shopid = shopid;
}
public String getSellerid() {
	return sellerid;
}
public void setSellerid(String sellerid) {
	this.sellerid = sellerid;
}
public String getShopname() {
	return shopname;
}
public void setShopname(String shopname) {
	this.shopname = shopname;
}
public String getShopcreated() {
	return shopcreated;
}
public void setShopcreated(String shopcreated) {
	this.shopcreated = shopcreated;
}
public Shop(int shopid, String sellerid, String shopname, String shopcreated) {
	super();
	this.shopid = shopid;
	this.sellerid = sellerid;
	this.shopname = shopname;
	this.shopcreated = shopcreated;
}
public Shop() {
	super();
	// TODO Auto-generated constructor stub
}
 
}
