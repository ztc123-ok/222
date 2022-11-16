package com.vo;

public class Order {
  private int orderid;
  private int waresid; 
  private String buyerid;  
  private int shopid; 
  private int waresnumber;  
  private String ordertime; 
  private String buyeraddress; 
  private String buyerphone;
  private String orderstate;

public int getOrderid() {
	return orderid;
}

public void setOrderid(int orderid) {
	this.orderid = orderid;
}

public int getWaresid() {
	return waresid;
}

public void setWaresid(int waresid) {
	this.waresid = waresid;
}

public String getBuyerid() {
	return buyerid;
}

public void setBuyerid(String buyerid) {
	this.buyerid = buyerid;
}

public int getShopid() {
	return shopid;
}

public void setShopid(int shopid) {
	this.shopid = shopid;
}

public int getWaresnumber() {
	return waresnumber;
}

public void setWaresnumber(int waresnumber) {
	this.waresnumber = waresnumber;
}

public String getOrdertime() {
	return ordertime;
}

public void setOrdertime(String ordertime) {
	this.ordertime = ordertime;
}

public String getBuyeraddress() {
	return buyeraddress;
}

public void setBuyeraddress(String buyeraddress) {
	this.buyeraddress = buyeraddress;
}

public String getBuyerphone() {
	return buyerphone;
}

public void setBuyerphone(String buyerphone) {
	this.buyerphone = buyerphone;
}

public String getOrderstate() {
	return orderstate;
}

public void setOrderstate(String orderstate) {
	this.orderstate = orderstate;
}

@Override
public String toString() {
	return "Order [orderid=" + orderid + ", waresid=" + waresid + ", buyerid="
			+ buyerid + ", shopid=" + shopid + ", waresnumber=" + waresnumber
			+ ", ordertime=" + ordertime + ", buyeraddress=" + buyeraddress
			+ ", buyerphone=" + buyerphone + ", orderstate=" + orderstate + "]";
}

public Order() {
	super();
	// TODO Auto-generated constructor stub
}
  
}
