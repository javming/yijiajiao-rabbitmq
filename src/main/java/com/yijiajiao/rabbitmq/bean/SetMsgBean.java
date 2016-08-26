package com.yijiajiao.rabbitmq.bean;

public class SetMsgBean {

	private String openId;
	private int isTeacher;
	private int isSend;
	private int isSendSystem;
	private int isSendStation;
	private int isSendCourse;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public int getIsTeacher() {
		return isTeacher;
	}

	public void setIsTeacher(int isTeacher) {
		this.isTeacher = isTeacher;
	}

	public int getIsSend() {
		return isSend;
	}

	public void setIsSend(int isSend) {
		this.isSend = isSend;
	}

	public int getIsSendSystem() {
		return isSendSystem;
	}

	public void setIsSendSystem(int isSendSystem) {
		this.isSendSystem = isSendSystem;
	}

	public int getIsSendStation() {
		return isSendStation;
	}

	public void setIsSendStation(int isSendStation) {
		this.isSendStation = isSendStation;
	}

	public int getIsSendCourse() {
		return isSendCourse;
	}

	public void setIsSendCourse(int isSendCourse) {
		this.isSendCourse = isSendCourse;
	}

}
