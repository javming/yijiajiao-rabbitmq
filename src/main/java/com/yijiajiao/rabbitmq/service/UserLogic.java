package com.yijiajiao.rabbitmq.service;


import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.ApplyTeacherBean;
import com.yijiajiao.rabbitmq.bean.CompleteInfoBean;
import com.yijiajiao.rabbitmq.bean.SetStoreBean;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.RabbitmqUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * 用户管理方向
 * 
 * @author ruyage
 * 
 */
public class UserLogic {

	private static Logger log = LoggerFactory.getLogger(UserLogic.class.getName());
	private Jedis jedis = null;
	String user_server = Config.getString("user_server");
	String teach_server = Config.getString("teach_server");
	String sale_server = Config.getString("sale_server");

	public String applyteacher(String tag, String cmd, JSONObject params) {
		String applyteacher = Config.getString("applyteacher");
		Gson gson = new Gson();
		ApplyTeacherBean applyTeacherBean = gson.fromJson(gson.toJson(params),
				ApplyTeacherBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(user_server, applyteacher, null,
				applyTeacherBean, "POST");
		log.info("applyteacher return is " + res);
		return res;
	}

	public String setStore(String tag, String cmd, JSONObject params) {
		String setStore = Config.getString("setStore");
		Gson gson = new Gson();
		SetStoreBean setStoreBean = gson.fromJson(gson.toJson(params),
				SetStoreBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(user_server, setStore, null,
				setStoreBean, "POST");
		log.info("setStore return is " + res);
		return res;
	}

	/**
	 * 完善个人信息
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String complete(String tag, String cmd, JSONObject params) {
		String passTest = Config.getString("complete");
		Gson gson = new Gson();
		CompleteInfoBean completeInfoBean = gson.fromJson(gson.toJson(params),
				CompleteInfoBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(user_server, passTest, null,
				completeInfoBean, "POST");
		log.info("complete   return is " + res);
		return res;
	}

}
