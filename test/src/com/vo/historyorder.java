package com.vo;

public class historyorder {
	private int historyid;
	private int waresid;
	private int shopid;
	private String buyerid;
	private int waresnumber;
	private String finishtime;
	private String buyeraddress;
	private String buyerphone;
	private String result;
	public int getHistoryid() {
		return historyid;
	}
	public void setHistoryid(int historyid) {
		this.historyid = historyid;
	}
	public int getWaresid() {
		return waresid;
	}
	public void setWaresid(int waresid) {
		this.waresid = waresid;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}
	public int getWaresnumber() {
		return waresnumber;
	}
	public void setWaresnumber(int waresnumber) {
		this.waresnumber = waresnumber;
	}
	public String getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "historyorder [historyid=" + historyid + ", waresid=" + waresid
				+ ", shopid=" + shopid + ", buyerid=" + buyerid
				+ ", waresnumber=" + waresnumber + ", finishtime=" + finishtime
				+ ", buyeraddress=" + buyeraddress + ", buyerphone="
				+ buyerphone + ", result=" + result + "]";
	}

	
}
