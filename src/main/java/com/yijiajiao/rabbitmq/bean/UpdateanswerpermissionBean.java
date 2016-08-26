package com.yijiajiao.rabbitmq.bean;

import java.util.List;

public class UpdateanswerpermissionBean {
	private String answerUrl;
	private String answerInfo;
	private String userAnswerUrl;
	private String userAnswerInfo;
	private String userOpenId;
	private int type;
	private String subjectCode;
	private String subjectName;
	private String stageCode;
	private String stageName;
	private List<Knowledge> userKnowledge;

	public String getUserAnswerUrl() {
		return userAnswerUrl;
	}

	public void setUserAnswerUrl(String userAnswerUrl) {
		this.userAnswerUrl = userAnswerUrl;
	}

	public String getUserAnswerInfo() {
		return userAnswerInfo;
	}

	public void setUserAnswerInfo(String userAnswerInfo) {
		this.userAnswerInfo = userAnswerInfo;
	}

	public String getUserOpenId() {
		return userOpenId;
	}

	public void setUserOpenId(String userOpenId) {
		this.userOpenId = userOpenId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Knowledge> getUserKnowledge() {
		return userKnowledge;
	}

	public void setUserKnowledge(List<Knowledge> userKnowledge) {
		this.userKnowledge = userKnowledge;
	}

	public String getAnswerUrl() {
		return answerUrl;
	}

	public void setAnswerUrl(String answerUrl) {
		this.answerUrl = answerUrl;
	}

	public String getAnswerInfo() {
		return answerInfo;
	}

	public void setAnswerInfo(String answerInfo) {
		this.answerInfo = answerInfo;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getStageCode() {
		return stageCode;
	}

	public void setStageCode(String stageCode) {
		this.stageCode = stageCode;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

}
