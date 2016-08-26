package com.yijiajiao.rabbitmq.bean;

import java.util.List;

public class ApplyTeacherBean {
	private String userOpenId;
	private String name;
	private String sex;
	private String school;
	private String idCard;
	private String frontPic;
	private String backPic;
	private String idPic;
	private String phone;
	private String invite_code;
	private String subjectName;
	private String subjectCode;
	private String teachAge;
	private String teacher_grade;
	private String provinceCode;
	private String cityCode;
	private String areaCode;
	private List<GradeBean> grades;

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getUserOpenId() {
		return userOpenId;
	}

	public void setUserOpenId(String userOpenId) {
		this.userOpenId = userOpenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getFrontPic() {
		return frontPic;
	}

	public void setFrontPic(String frontPic) {
		this.frontPic = frontPic;
	}

	public String getBackPic() {
		return backPic;
	}

	public void setBackPic(String backPic) {
		this.backPic = backPic;
	}

	public String getIdPic() {
		return idPic;
	}

	public void setIdPic(String idPic) {
		this.idPic = idPic;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInvite_code() {
		return invite_code;
	}

	public void setInvite_code(String invite_code) {
		this.invite_code = invite_code;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getTeachAge() {
		return teachAge;
	}

	public void setTeachAge(String teachAge) {
		this.teachAge = teachAge;
	}

	public String getTeacher_grade() {
		return teacher_grade;
	}

	public void setTeacher_grade(String teacher_grade) {
		this.teacher_grade = teacher_grade;
	}

	public List<GradeBean> getGrades() {
		return grades;
	}

	public void setGrades(List<GradeBean> grades) {
		this.grades = grades;
	}

}
