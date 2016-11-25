package com.yijiajiao.rabbitmq.bean;

import java.util.List;

public class WareLiveBean {
	private int id;
	private String teacherId;
	private String curriculumName;// 课程名称
	private int curriculumType;
	private String curriculumInfo;// 课程详情
	private String subjectCode;
	private String gradeCode;
	private String bookTypeCode;
	private String cover;
	private String goal;
	private double price;
	private String trialCrowd;
	private String describeInfo;
	private String homework;
	private String smallCourseware;
	private String isYjj;
	private String moduleId;
	private String yjjCode;
	private String yjjName;
	private String curriculumInfoAudio;
	private String curriculumInfoVideo;
	private String curriculumInfoPic;

	public String getCurriculumInfoAudio() {
		return curriculumInfoAudio;
	}

	public void setCurriculumInfoAudio(String curriculumInfoAudio) {
		this.curriculumInfoAudio = curriculumInfoAudio;
	}

	public String getCurriculumInfoVideo() {
		return curriculumInfoVideo;
	}

	public void setCurriculumInfoVideo(String curriculumInfoVideo) {
		this.curriculumInfoVideo = curriculumInfoVideo;
	}

	public String getCurriculumInfoPic() {
		return curriculumInfoPic;
	}

	public void setCurriculumInfoPic(String curriculumInfoPic) {
		this.curriculumInfoPic = curriculumInfoPic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsYjj() {
		return isYjj;
	}

	public void setIsYjj(String isYjj) {
		this.isYjj = isYjj;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getYjjCode() {
		return yjjCode;
	}

	public void setYjjCode(String yjjCode) {
		this.yjjCode = yjjCode;
	}

	public String getYjjName() {
		return yjjName;
	}

	public void setYjjName(String yjjName) {
		this.yjjName = yjjName;
	}

	public String getSmallCourseware() {
		return smallCourseware;
	}

	public void setSmallCourseware(String smallCourseware) {
		this.smallCourseware = smallCourseware;
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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTrialCrowd() {
		return trialCrowd;
	}

	public void setTrialCrowd(String trialCrowd) {
		this.trialCrowd = trialCrowd;
	}

	public String getDescribeInfo() {
		return describeInfo;
	}

	public void setDescribeInfo(String describeInfo) {
		this.describeInfo = describeInfo;
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

	public int getIsInsert() {
		return isInsert;
	}

	public void setIsInsert(int isInsert) {
		this.isInsert = isInsert;
	}

	public int getInsertSupplement() {
		return insertSupplement;
	}

	public void setInsertSupplement(int insertSupplement) {
		this.insertSupplement = insertSupplement;
	}

	public double getInsertPrice() {
		return insertPrice;
	}

	public void setInsertPrice(double insertPrice) {
		this.insertPrice = insertPrice;
	}

	public List<SlaveBean> getSlaves() {
		return slaves;
	}

	public void setSlaves(List<SlaveBean> slaves) {
		this.slaves = slaves;
	}

	private int isQuit;
	private int quitSupplement;
	private int isInsert;
	private int insertSupplement;
	private double insertPrice;
	private List<SlaveBean> slaves;
	private int maxNumber;

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

}
