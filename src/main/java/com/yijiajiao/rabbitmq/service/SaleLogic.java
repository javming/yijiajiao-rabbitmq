package com.yijiajiao.rabbitmq.service;

import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.*;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.RabbitmqUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaleLogic {
	private static Logger log =  LoggerFactory.getLogger(SaleLogic.class.getName());
	String sale_server = Config.getString("sale_server");

	public String updateAppraise(String tag, String cmd, JSONObject params) {
		String updateAppraise = Config.getString("updateAppraise");
		Gson gson = new Gson();
		UpdateAppraiseBean updateAppraiseBean = gson.fromJson(
				gson.toJson(params), UpdateAppraiseBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(sale_server, updateAppraise, null,
				updateAppraiseBean, "POST");
		log.info("updateAppraise return is " + res);
		return res;
	}

	/**
	 * 提交订单
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String createOrder(String tag, String cmd, JSONObject params) {
		String createOrder = Config.getString("createOrder");
		Gson gson = new Gson();
		log.info(params.toString());
		CreateOrderBean createOrderBean = gson.fromJson(gson.toJson(params),
				CreateOrderBean.class);
		Object o = new Object();
		if (createOrderBean.getSlaves() == null) {
			CreatevOrderBean v = new CreatevOrderBean();
			v.setCommodity_id(createOrderBean.getCommodity_id());
			v.setOpen_id(createOrderBean.getOpen_id());
			v.setOrder_price(createOrderBean.getOrder_price());
			v.setCommodityType(createOrderBean.getCommodityType());
			v.setDiagnosisGoodsDetailCode(createOrderBean.getDiagnosisGoodsDetailCode());
			v.setDiagnosisGoodsCode(createOrderBean.getDiagnosisGoodsCode());
			v.setDiagnosticRecordsName(createOrderBean.getDiagnosticRecordsName());
			v.setMultiPaperCode(createOrderBean.getMultiPaperCode());
			v.setUsed(createOrderBean.getUsed());
			v.setDiscountPrice(createOrderBean.getDiscountPrice());
			v.setExamStartDate(createOrderBean.getExamStartDate());
			v.setExamEndDate(createOrderBean.getExamEndDate());
			v.setDiscountYard(createOrderBean.getDiscountYard());
			o = v;
		} else {
			o = createOrderBean;
		}
		log.info("请求其他系统路径："+sale_server+createOrder);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(sale_server, createOrder, null, o,
				"POST");
		log.info("createOrder return is " + res);
		return res;
	}

	public String updateAppraiseReback(String tag, String cmd, JSONObject params) {
		String updateAppraise = Config.getString("updateAppraiseReback");
		Gson gson = new Gson();
		UpdateAppraiseRebackBean updateAppraiseRebackBean = gson.fromJson(
				gson.toJson(params), UpdateAppraiseRebackBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(sale_server, updateAppraise, null,
				updateAppraiseRebackBean, "PUT");
		log.info("updateAppraiseReback return is " + res);
		return res;
	}

	public String createRefund(String tag, String cmd, JSONObject params) {
		String updateAppraise = Config.getString("createRefund");
		Gson gson = new Gson();
		CreateRefundBean createRefundBean = gson.fromJson(gson.toJson(params),
				CreateRefundBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(sale_server, updateAppraise, null,
				createRefundBean, "POST");
		log.info("createRefund return is " + res);
		return res;
	}

}
