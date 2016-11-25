package com.yijiajiao.rabbitmq.bean;

public class SlaveBean {
	private int id;
	private int seq;
	private String startTime;
	private String endTime;
	private String content;
	private String homework;
	private String yjjCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYjjCode() {
		return yjjCode;
	}

	public void setYjjCode(String yjjCode) {
		this.yjjCode = yjjCode;
	}

	public String getHomework() {
		return homework;
	}

	public void setHomework(String homework) {
		this.homework = homework;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
