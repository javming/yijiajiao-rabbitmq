package com.yijiajiao.rabbitmq.service;


import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.SetMsgBean;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.RabbitmqUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MsgLogic {

	private static Logger log = LoggerFactory.getLogger(MsgLogic.class.getName());
	String msg_server = Config.getString("msg_server");

	public String SetMsg(String tag, String cmd, JSONObject params) {
		String setMsg = Config.getString("setMsg");
		Gson gson = new Gson();
		SetMsgBean setMsgBean = gson.fromJson(gson.toJson(params),
				SetMsgBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(msg_server, setMsg, null, setMsgBean,
				"POST");
		log.info("SetMsg return is " + res);
		return res;
	}
}
