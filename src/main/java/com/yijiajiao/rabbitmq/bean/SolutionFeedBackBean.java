package com.yijiajiao.rabbitmq.bean;

public class SolutionFeedBackBean {
	private int solId;// 答疑id
	private int refuseId;// 反馈基础信息id
	private String description;// 反馈理由描述
	private String openId; //教师openid
	public int getSolId() {
		return solId;
	}
	public void setSolId(int solId) {
		this.solId = solId;
	}
	public int getRefuseId() {
		return refuseId;
	}
	public void setRefuseId(int refuseId) {
		this.refuseId = refuseId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
