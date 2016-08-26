package com.yijiajiao.rabbitmq.bean;

import java.util.List;

public class CreateOrderBean {
	private int commodity_id;
	private double order_price;
	private String open_id;
	private int commodityType;// 商品类型:(1课程2答疑3诊断4密卷
	private List<Slave4OrderBean> slaves;

	public int getCommodity_id() {
		return commodity_id;
	}

	public void setCommodity_id(int commodity_id) {
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

}
