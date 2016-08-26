package com.yijiajiao.rabbitmq.bean;

import java.util.List;

public class WareVideoBean {
	private String teacherId;
	private String curriculumName;
	private int curriculumType;// 商品类型，1.直播课，2.视频课，3.一对一课
	private String curriculumInfo;
	private String subjectCode;
	private String gradeCode;
	private String bookTypeCode;
	private double price;
	private String cover;
	private int lookedTime;
	private int trialLookTime;
	private String homework;
	private int tryVideoId;
	private List<videoSalveBean> slaves;
	
	
	public int getTryVideoId() {
		return tryVideoId;
	}

	public void setTryVideoId(int tryVideoId) {
		this.tryVideoId = tryVideoId;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getLookedTime() {
		return lookedTime;
	}

	public void setLookedTime(int lookedTime) {
		this.lookedTime = lookedTime;
	}

	public int getTrialLookTime() {
		return trialLookTime;
	}

	public void setTrialLookTime(int trialLookTime) {
		this.trialLookTime = trialLookTime;
	}

	public List<videoSalveBean> getSlaves() {
		return slaves;
	}

	public void setSlaves(List<videoSalveBean> slaves) {
		this.slaves = slaves;
	}

	class videoSalveBean {
		private long vedioId;
		private String homework;
		
		public String getHomework(){
			return this.homework;
		}
		public void setHomework(String homework){
			this.homework = homework;
		}
		public long getVedioId() {
			return vedioId;
		}

		public void setVedioId(long vedioId) {
			this.vedioId = vedioId;
		}

	}

}
