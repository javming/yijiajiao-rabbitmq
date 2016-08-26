package com.yijiajiao.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.CreateExamBean;
import com.yijiajiao.rabbitmq.bean.CreateExamDetailBean;
import com.yijiajiao.rabbitmq.bean.SmartCreateExamBean;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.RabbitmqUtil;

import net.sf.json.JSONObject;

public class BaseDataLogic {

	private static Logger log = LoggerFactory.getLogger(BaseDataLogic.class.getName());
	String wares_server = Config.getString("wares_server");

	/**
	 * 手动组卷添加卷头
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String CreateExam(String tag, String cmd, JSONObject params) {
		String createExam = Config.getString("createExam");
		Gson gson = new Gson();
		CreateExamBean createExamBean = gson.fromJson(gson.toJson(params),
				CreateExamBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(wares_server, createExam, null,
				createExamBean, "POST");
		log.info("createExam return is " + res);
		return res;
	}

	/**
	 * 手动组卷添加试题
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String CreateExamDetail(String tag, String cmd, JSONObject params) {
		String createExamDetail = Config.getString("CreateExamDetail");
		Gson gson = new Gson();
		CreateExamDetailBean createExamDetailBean = gson.fromJson(
				gson.toJson(params), CreateExamDetailBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(wares_server, createExamDetail, null,
				createExamDetailBean, "POST");
		log.info("CreateExamDetail return is " + res);
		return res;
	}

	/**
	 * @description 智能组卷
	 * @date 2016-5-9
	 * @return String
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String SmartCreateExam(String tag, String cmd, JSONObject params) {
		String smartCreateExam = Config.getString("SmartCreateExam");
		Gson gson = new Gson();
		SmartCreateExamBean smartCreateExamBean = gson.fromJson(
				gson.toJson(params), SmartCreateExamBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(wares_server, smartCreateExam, null,
				smartCreateExamBean, "POST");
		log.info("smartCreateExam return is " + res);
		return res;
	}

}
