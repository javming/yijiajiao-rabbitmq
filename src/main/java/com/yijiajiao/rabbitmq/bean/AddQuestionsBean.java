package com.yijiajiao.rabbitmq.bean;

import java.util.ArrayList;
import java.util.List;

public class AddQuestionsBean {
	private String paperId;
	private List<BigQuestionBean> bigQuestions = new ArrayList<BigQuestionBean>();
	public String getPaperId() {
		return paperId;
	}
	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	public List<BigQuestionBean> getBigQuestions() {
		return bigQuestions;
	}
	public void setBigQuestions(List<BigQuestionBean> bigQuestions) {
		this.bigQuestions = bigQuestions;
	}
	
}
