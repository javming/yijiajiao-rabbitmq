package com.yijiajiao.rabbitmq.bean;

import java.util.List;

public class WareOne2OneBean {
	private String teacherId;
	private String curriculumName;
	private int curriculumType;
	private String curriculumInfo;
	private String subjectCode;
	private String gradeCode;
	private String bookTypeCode;
	private String cover;
	private int teachMode;
	private double price121Online;
	private double price121Offline;
	private int isQuit;// 退班
	private int quitSupplement;
	private String location;// 地图坐标
	private double scope;// 上门服务范围
	private String homework;

	private String slaveTimeId;
	private List<SlaveOne2OneBean> slaves;

	public String getHomework() {
		return homework;
	}

	public void setHomework(String homework) {
		this.homework = homework;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public List<SlaveOne2OneBean> getSlaves() {
		return slaves;
	}

	public void setSlaves(List<SlaveOne2OneBean> slaves) {
		this.slaves = slaves;
	}

	public String getCurriculumName() {
		return curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}

	public int getCurriculumType() {
		return curriculumType;
	}

	public void setCurriculumType(int curriculumType) {
		this.curriculumType = curriculumType;
	}

	public String getCurriculumInfo() {
		return curriculumInfo;
	}

	public void setCurriculumInfo(String curriculumInfo) {
		this.curriculumInfo = curriculumInfo;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getBookTypeCode() {
		return bookTypeCode;
	}

	public void setBookTypeCode(String bookTypeCode) {
		this.bookTypeCode = bookTypeCode;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public double getPrice121Online() {
		return price121Online;
	}

	public void setPrice121Online(double price121Online) {
		this.price121Online = price121Online;
	}

	public double getPrice121Offline() {
		return price121Offline;
	}

	public void setPrice121Offline(double price121Offline) {
		this.price121Offline = price121Offline;
	}

	public int getIsQuit() {
		return isQuit;
	}

	public void setIsQuit(int isQuit) {
		this.isQuit = isQuit;
	}

	public int getQuitSupplement() {
		return quitSupplement;
	}

	public void setQuitSupplement(int quitSupplement) {
		this.quitSupplement = quitSupplement;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getScope() {
		return scope;
	}

	public void setScope(double scope) {
		this.scope = scope;
	}

	public String getSlaveTimeId() {
		return slaveTimeId;
	}

	public void setSlaveTimeId(String slaveTimeId) {
		this.slaveTimeId = slaveTimeId;
	}

	public int getTeachMode() {
		return teachMode;
	}

	public void setTeachMode(int teachMode) {
		this.teachMode = teachMode;
	}

}
