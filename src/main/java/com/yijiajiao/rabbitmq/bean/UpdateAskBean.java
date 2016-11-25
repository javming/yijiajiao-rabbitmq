package com.yijiajiao.rabbitmq.bean;

import java.util.List;

public class UpdateAskBean {

	private String solSubject;
	private String solSubjectCode;
	private String solGrades;
	private String solGradesCode;
	private String solDescription;
	private String solPicture;
	private String openId;
	private String teaOpenId;
	private List<Picture> pictureList;
	private String bookTypeName;// 教材版本
	private String bookTypeCode;// 教材编码
	
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeCode() {
		return bookTypeCode;
	}
	public void setBookTypeCode(String bookTypeCode) {
		this.bookTypeCode = bookTypeCode;
	}
	public String getSolSubject() {
		return solSubject;
	}
	public void setSolSubject(String solSubject) {
		this.solSubject = solSubject;
	}
	public String getSolSubjectCode() {
		return solSubjectCode;
	}
	public void setSolSubjectCode(String solSubjectCode) {
		this.solSubjectCode = solSubjectCode;
	}
	public String getSolGrades() {
		return solGrades;
	}
	public void setSolGrades(String solGrades) {
		this.solGrades = solGrades;
	}
	public String getSolGradesCode() {
		return solGradesCode;
	}
	public void setSolGradesCode(String solGradesCode) {
		this.solGradesCode = solGradesCode;
	}
	public String getSolDescription() {
		return solDescription;
	}
	public void setSolDescription(String solDescription) {
		this.solDescription = solDescription;
	}
	public String getSolPicture() {
		return solPicture;
	}
	public void setSolPicture(String solPicture) {
		this.solPicture = solPicture;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getTeaOpenId() {
		return teaOpenId;
	}
	public void setTeaOpenId(String teaOpenId) {
		this.teaOpenId = teaOpenId;
	}
	public List<Picture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}

}
