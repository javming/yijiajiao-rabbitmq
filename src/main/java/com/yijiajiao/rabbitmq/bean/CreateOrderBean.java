package com.yijiajiao.rabbitmq.bean;

import java.util.List;

public class CreateOrderBean {
	private String commodity_id;
	private double order_price;
	private String open_id;
	private int commodityType;// 商品类型:(1课程2答疑3诊断4保分计划诊断）
	private String diagnosisGoodsDetailCode;//诊断商品code
	private String diagnosisGoodsCode;//诊断商品code
	private String multiPaperCode;//综合试卷code
	private String diagnosticRecordsName;//诊断商品名称
	private List<Slave4OrderBean> slaves;
	private String used;//(保分计划诊断)
	private double discountPrice;
	private String examStartDate;
	private String examEndDate;
	private String discountYard;// 优惠码

	public String getDiscountYard() {
		return discountYard;
	}

	public void setDiscountYard(String discountYard) {
		this.discountYard = discountYard;
	}

	public String getExamStartDate() {
		return examStartDate;
	}

	public void setExamStartDate(String examStartDate) {
		this.examStartDate = examStartDate;
	}

	public String getExamEndDate() {
		return examEndDate;
	}

	public void setExamEndDate(String examEndDate) {
		this.examEndDate = examEndDate;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	public String getDiagnosisGoodsDetailCode() {
		return diagnosisGoodsDetailCode;
	}

	public void setDiagnosisGoodsDetailCode(String diagnosisGoodsDetailCode) {
		this.diagnosisGoodsDetailCode = diagnosisGoodsDetailCode;
	}

	public String getMultiPaperCode() {
		return multiPaperCode;
	}

	public void setMultiPaperCode(String multiPaperCode) {
		this.multiPaperCode = multiPaperCode;
	}

	public String getDiagnosticRecordsName() {
		return diagnosticRecordsName;
	}

	public void setDiagnosticRecordsName(String diagnosticRecordsName) {
		this.diagnosticRecordsName = diagnosticRecordsName;
	}

	public String getCommodity_id() {
		return commodity_id;
	}

	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}

	public double getOrder_price() {
		return order_price;
	}

	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}

	public String getOpen_id() {
		return open_id;
	}

	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}

	public List<Slave4OrderBean> getSlaves() {
		return slaves;
	}

	public void setSlaves(List<Slave4OrderBean> slaves) {
		this.slaves = slaves;
	}

	public int getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(int commodityType) {
		this.commodityType = commodityType;
	}

	public String getDiagnosisGoodsCode() {
		return diagnosisGoodsCode;
	}

	public void setDiagnosisGoodsCode(String diagnosisGoodsCode) {
		this.diagnosisGoodsCode = diagnosisGoodsCode;
	}

	
}
