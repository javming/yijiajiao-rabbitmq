package com.yijiajiao.rabbitmq.bean;

import java.util.ArrayList;
import java.util.List;

public class CreateExamDetailBean {
	private String examCode;
	private List<ExamDetail> slaves = new ArrayList<ExamDetail>();

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public List<ExamDetail> getSlaves() {
		return slaves;
	}

	public void setSlaves(List<ExamDetail> slaves) {
		this.slaves = slaves;
	}

}
