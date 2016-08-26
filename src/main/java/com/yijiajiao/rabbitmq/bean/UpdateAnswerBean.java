package com.yijiajiao.rabbitmq.bean;

import java.util.List;

public class UpdateAnswerBean {

	private int stuId;
	private List<Knowledge> knowledgelist;
	private List<analysisProcessBean> analysisProcess;
	private String description;
	private String openId;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public List<Knowledge> getKnowledgelist() {
		return knowledgelist;
	}

	public void setKnowledgelist(List<Knowledge> knowledgelist) {
		this.knowledgelist = knowledgelist;
	}

	public List<analysisProcessBean> getAnalysisProcess() {
		return analysisProcess;
	}

	public void setAnalysisProcess(List<analysisProcessBean> analysisProcess) {
		this.analysisProcess = analysisProcess;
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
