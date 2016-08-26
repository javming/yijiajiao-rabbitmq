package com.yijiajiao.rabbitmq.bean;

import java.util.List;

public class AddDoubtBean {

	private List<GradeAndBookTypeBean> gradesAndSubject;
	private String id;// 答疑
	private String goodRange;// 擅长范围
	private String onlineTime;// 在线时间
	private String limitNumber;// 人数限制
	private String provinceCode;// 地区code
	private String provinceName;//地区名称
	private String openId;//　　教师openid
	
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public List<GradeAndBookTypeBean> getGradesAndSubject() {
		return gradesAndSubject;
	}
	public void setGradesAndSubject(List<GradeAndBookTypeBean> gradesAndSubject) {
		this.gradesAndSubject = gradesAndSubject;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getGoodRange() {
		return goodRange;
	}
	public void setGoodRange(String goodRange) {
		this.goodRange = goodRange;
	}
	public String getOnlineTime() {
		return onlineTime;
	}
	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}
	public String getLimitNumber() {
		return limitNumber;
	}
	public void setLimitNumber(String limitNumber) {
		this.limitNumber = limitNumber;
	}

	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}



}
