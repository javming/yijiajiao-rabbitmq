package com.yijiajiao.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

import redis.clients.jedis.Jedis;

import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.ApplyPermissionBean;
import com.yijiajiao.rabbitmq.bean.ApplyfacingteachtimeBean;
import com.yijiajiao.rabbitmq.bean.ApplyinterviewtimeBean;
import com.yijiajiao.rabbitmq.bean.PassTestBean;
import com.yijiajiao.rabbitmq.bean.UpdateanswerpermissionBean;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.RabbitmqUtil;

public class TeachLogic {

	private static Logger log =LoggerFactory.getLogger(TeachLogic.class.getName());
	private Jedis jedis = null;

	String teach_server = Config.getString("teach_server");

	public String applyPermission(String tag, String cmd, JSONObject params) {
		String setStore = Config.getString("applyPermission");
		Gson gson = new Gson();
		ApplyPermissionBean applyPermissionBean = gson.fromJson(
				gson.toJson(params), ApplyPermissionBean.class);
		System.out.println("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(teach_server, setStore, null,
				applyPermissionBean, "POST");
		log.info("applyPermissionBean return is " + res);
		return res;
	}

	/**
	 * 提交基础测试
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String passTest(String tag, String cmd, JSONObject params) {
		String passTest = Config.getString("passTest");
		Gson gson = new Gson();
		PassTestBean passTestBean = gson.fromJson(gson.toJson(params),
				PassTestBean.class);
		System.out.println("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(teach_server, passTest, null,
				passTestBean, "POST");
		log.info("passTest   return is " + res);
		return res;
	}

	public String insertanswerpermission(String tag, String cmd,
			JSONObject params) {
		String updateanswerpermission = Config
				.getString("insertanswerpermission");
		Gson gson = new Gson();
		UpdateanswerpermissionBean updateanswerpermissionBean = gson.fromJson(
				gson.toJson(params), UpdateanswerpermissionBean.class);
		System.out.println("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(teach_server, updateanswerpermission,
				null, updateanswerpermissionBean, "POST");
		log.info("updateanswerpermission   return is " + res);
		return res;
	}

	public String applyInterviewTime(String tag, String cmd, JSONObject params) {
		String applyinterviewtime = Config.getString("applyinterviewtime");
		Gson gson = new Gson();
		ApplyinterviewtimeBean applyinterviewtimeBean = gson.fromJson(gson.toJson(params), ApplyinterviewtimeBean.class);
		System.out.println("gson.toJson(params): "+gson.toJson(params));
		String res = RabbitmqUtil.httpRest(teach_server, applyinterviewtime, null, applyinterviewtimeBean, "POST");
		log.info("applyinterviewtime return is"+res);
		return res;
	}

	public String applyFacingTeachTime(String tag, String cmd, JSONObject params) {
		String applyfacingteachtime = Config.getString("applyfacingteachtime");
		Gson gson = new Gson();
		ApplyfacingteachtimeBean applyfacingteachtimeBean = gson.fromJson(gson.toJson(params), ApplyfacingteachtimeBean.class);
		System.out.println("gson.toJson(params): "+gson.toJson(params));
		String res = RabbitmqUtil.httpRest(teach_server, applyfacingteachtime, null, applyfacingteachtimeBean, "POST");
		log.info("applyfacingteachtime return is"+ res);
		return res;
	}

	
}
