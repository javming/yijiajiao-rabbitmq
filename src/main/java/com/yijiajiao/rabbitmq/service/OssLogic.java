package com.yijiajiao.rabbitmq.service;


import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.FeedBackBean;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.RabbitmqUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OssLogic {

	private static Logger log = LoggerFactory.getLogger(OssLogic.class.getName());
	String oss_server = Config.getString("oss_server");

	public String feedBack(String tag, String cmd, JSONObject params) {
		String feedBack = Config.getString("feedBack");
		Gson gson = new Gson();
		FeedBackBean feedBackBean = gson.fromJson(gson.toJson(params),
				FeedBackBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(oss_server, feedBack, null,
				feedBackBean, "POST");
		log.info("feedBack return is " + res);
		return res;
	}
}
