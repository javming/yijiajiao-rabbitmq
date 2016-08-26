package com.yijiajiao.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.BindAliPayBean;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.RabbitmqUtil;

import net.sf.json.JSONObject;

public class FinanceLogic {

	private static Logger log =LoggerFactory.getLogger(FinanceLogic.class.getName());
	String finance_server = Config.getString("finance_server");

	public String bindAliPay(String tag, String cmd, JSONObject params) {
		String bindAliPay = Config.getString("bindAliPay");
		Gson gson = new Gson();
		BindAliPayBean bindAliPayBean = gson.fromJson(gson.toJson(params),
				BindAliPayBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(finance_server, bindAliPay, null,
				bindAliPayBean, "POST");
		log.info("bindAliPay return is " + res);
		return res;
	}
}
