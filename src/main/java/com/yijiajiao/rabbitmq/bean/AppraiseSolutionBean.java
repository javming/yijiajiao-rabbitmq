package com.yijiajiao.rabbitmq.bean;

public class AppraiseSolutionBean {
	private int solId;// 答疑id
	private int communicating;// 沟通互动
	private int enlighten;// 启发引导
	private int solveEffect;// 解答效果
	private String content="";// 评价内容
	private int anonymity;// 0不是匿名，1是匿名
	public int getSolId() {
		return solId;
	}
	public void setSolId(int solId) {
		this.solId = solId;
	}
	public int getCommunicating() {
		return communicating;
	}
	public void setCommunicating(int communicating) {
		this.communicating = communicating;
	}
	public int getEnlighten() {
		return enlighten;
	}
	public void setEnlighten(int enlighten) {
		this.enlighten = enlighten;
	}
	public int getSolveEffect() {
		return solveEffect;
	}
	public void setSolveEffect(int solveEffect) {
		this.solveEffect = solveEffect;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAnonymity() {
		return anonymity;
	}
	public void setAnonymity(int anonymity) {
		this.anonymity = anonymity;
	}
	
}
