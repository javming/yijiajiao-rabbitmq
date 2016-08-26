package com.yijiajiao.rabbitmq.bean;

public class UpdateAppraiseBean {

	private int orderId;
	private String openId;
	private double appraiseCause1;
	private double appraiseCause2;
	private double appraiseCause3;
	private String appraiseContent;
	private int isAnonymity;// 是否匿名 0不是匿名1是匿名;
	
	public int getIsAnonymity() {
		return isAnonymity;
	}

	public void setIsAnonymity(int isAnonymity) {
		this.isAnonymity = isAnonymity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public double getAppraiseCause1() {
		return appraiseCause1;
	}

	public void setAppraiseCause1(double appraiseCause1) {
		this.appraiseCause1 = appraiseCause1;
	}

	public double getAppraiseCause2() {
		return appraiseCause2;
	}

	public void setAppraiseCause2(double appraiseCause2) {
		this.appraiseCause2 = appraiseCause2;
	}

	public double getAppraiseCause3() {
		return appraiseCause3;
	}

	public void setAppraiseCause3(double appraiseCause3) {
		this.appraiseCause3 = appraiseCause3;
	}

	public String getAppraiseContent() {
		return appraiseContent;
	}

	public void setAppraiseContent(String appraiseContent) {
		this.appraiseContent = appraiseContent;
	}

}
