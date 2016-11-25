package com.yijiajiao.rabbitmq.service;


import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.*;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.JedisPoolUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import static com.yijiajiao.rabbitmq.util.RabbitmqUtil.httpRest;

/**
 * 商品资源方向
 * 
 * @author ruyage
 * 
 */
public class WareLogic {

	private static Logger log = LoggerFactory.getLogger(WareLogic.class.getName());

	private Jedis jedis = null;

	String wares_server = Config.getString("wares_server");

	/**
	 * 向redis中写入token并删除redis中已用序列号
	 * 
	 * @param res
	 * @param username
	 * @throws Exception
	 */
	private void putRedis(String res, String username) throws Exception {

		JSONObject jb = JSONObject.fromObject(res);
		String token = jb.getString("access_token");
		Long expr = jb.getLong("expires_in");
		int sec = expr.intValue();
		jedis = JedisPoolUtil.pool.getResource();
		jedis.setex(token, sec, username);
		JedisPoolUtil.pool.returnResource(jedis);
	}

	public static String randomCode() {
		String sRand = "";
		for (int i = 0; i < 5; i++) {
			String rand = String.valueOf(Math.round(Math.random() * 9));
			sRand = sRand.concat(rand);
		}
		return sRand;
	}

	/**
	 * 用户反馈
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String feedBack(String tag, String cmd, JSONObject params) {
		/*
		 * String url = Config.getString("logic.feedback.url");
		 * FeedBackParamsBean feedParams = (FeedBackParamsBean)
		 * JSONObject.toBean(params, FeedBackParamsBean.class); FeedBackBean
		 * feedBack = new FeedBackBean(); boolean rate = false; String rateMsg =
		 * AndroidServerUtil.toUTF8("满意"); if
		 * (rateMsg.equals(feedParams.getRating())) { rate = true; }
		 * feedBack.setRemarkType(rate); long id =
		 * Long.parseLong(feedParams.getReply()); feedBack.setQuestionId(id);
		 * feedBack.setRemark(feedParams.getText()); if (feedParams.getToken()
		 * == null || "".equals(feedParams.getToken())) { String m = "token 错误";
		 * String msg = AndroidServerUtil.toUTF8(m); return
		 * "{\"result\":false, \"errno\":\"102\", \"msg\": \"" + msg + "\"}"; }
		 * jedis = JedisPoolUtil.pool.getResource(); boolean flag =
		 * jedis.exists(feedParams.getToken());
		 * JedisPoolUtil.pool.returnResource(jedis); if (!flag) { String m =
		 * "token 错误"; String msg = AndroidServerUtil.toUTF8(m); return
		 * "{\"result\":false, \"errno\":\"102\", \"msg\": \"" + msg + "\"}"; }
		 * JSONObject jsonObject = JSONObject.fromObject(feedBack); String input
		 * = jsonObject.toString(); log.info("feedBack's params is : " + input);
		 * ClientResponse response = AndroidServerUtil.resource(url, input,
		 * "POST"); String res = response.getEntity(String.class); return res;
		 */
		return null;
	}

	/**
	 * 创建订单
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String createOrder(String tag, String cmd, JSONObject params) {
		/*
		 * OrderBean order =(OrderBean)JSONObject.toBean(params,
		 * OrderBean.class);; log.info("createOrder:"+
		 * order.getCount()+order.getTotal_price
		 * ()+order.getId_card_define()+order.getToken()); jedis =
		 * JedisPoolUtil.pool.getResource(); boolean flag =
		 * jedis.exists(order.getToken());
		 * JedisPoolUtil.pool.returnResource(jedis); if (!flag) { String m =
		 * "token 错误"; String msg = AndroidServerUtil.toUTF8(m);
		 * 
		 * return "{\"result\":false, \"errno\":\"102\", \"msg\": \"" + msg +
		 * "\"}"; } String username = jedis.get(order.getToken());
		 * log.info("orderNew params is : " + params); OrderNewBean orderNew =
		 * new OrderNewBean(); orderNew.setCount(order.getCount());
		 * orderNew.setUsername(username);
		 * orderNew.setId_card_define(order.getId_card_define());
		 * orderNew.setPrice(order.getPrice());
		 * orderNew.setTotal_price(order.getTotal_price());
		 * 
		 * String path = Config.getString("order.orderNew"); ClientResponse
		 * response = AndroidServerUtil.resource(path, orderNew, "POST"); String
		 * res = response.getEntity(String.class);
		 * log.info("orderNew Transnum return : " + res ); if
		 * (response.getStatus() == 500) { String m = "server 500 error"; String
		 * msg = AndroidServerUtil.toUTF8(m); return
		 * "{\"result\":false, \"errno\":\"104\", \"msg\": \"" + msg + "\"}"; }
		 * if (res == null || "".equals(res)) { String m = "无请求的内容"; String msg
		 * = AndroidServerUtil.toUTF8(m); return
		 * "{\"result\":false, \"errno\":\"105\", \"msg\": \"" + msg + "\"}"; }
		 * if(res.contains("A00001")&&res.contains("error")){ String m =
		 * "数据库的错误"; String msg = AndroidServerUtil.toUTF8(m); return
		 * "{\"result\":false, \"errno\":\"107\", \"msg\": \"" + msg + "\"}"; }
		 * if(res.contains("A00005")&&res.contains("error")){ String m = "没有库存";
		 * String msg = AndroidServerUtil.toUTF8(m); return
		 * "{\"result\":false, \"errno\":\"108\", \"msg\": \"" + msg + "\"}"; }
		 * if(res.contains("A00010")&&res.contains("error")){ String m =
		 * "该商品已无货"; String msg = AndroidServerUtil.toUTF8(m); return
		 * "{\"result\":false, \"errno\":\"109\", \"msg\": \"" + msg + "\"}"; }
		 * return res;
		 */
		return null;
	}

	/**
	 * 上传视频
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String uploadVideo(String tag, String cmd, JSONObject params) {
		String uploadvideo = Config.getString("uploadvideo");
		Gson gson = new Gson();

		UploadVideoParamBean uploadVideoParamBean = gson.fromJson(
				gson.toJson(params), UploadVideoParamBean.class);

		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = httpRest(wares_server, uploadvideo, null,
				uploadVideoParamBean, "POST");
		log.info("uploadvideo return is " + res);
		return res;
	}

	/**
	 * 创建直播课
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String wareLive(String tag, String cmd, JSONObject params) {
		String warelive = Config.getString("warelive");
		Gson gson = new Gson();
		WareLiveBean wareLiveBean = gson.fromJson(gson.toJson(params),
				WareLiveBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = httpRest(wares_server, warelive, null,
				wareLiveBean, "POST");
		log.info("wareLive return is " + res);
		return res;

	}

	/**
	 * 创建视频课
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */

	public String wareVideo(String tag, String cmd, JSONObject params) {
		String warevideo = Config.getString("warevideo");
		Gson gson = new Gson();
		WareVideoBean wareVideoBean = gson.fromJson(gson.toJson(params),
				WareVideoBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = httpRest(wares_server, warevideo, null,
				wareVideoBean, "POST");
		log.info("wareVideo return is " + res);
		return res;

	}

	/**
	 * 创建一对一课
	 * 
	 * @param tag
	 * @param cmd
	 * @param params
	 * @return
	 */
	public String wareOne2One(String tag, String cmd, JSONObject params) {
		String wareOne2One = Config.getString("wareOne2One");
		Gson gson = new Gson();
		WareOne2OneBean wareOne2OneBean = gson.fromJson(gson.toJson(params),
				WareOne2OneBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = httpRest(wares_server, wareOne2One, null,
				wareOne2OneBean, "POST");
		log.info("wareOne2One return is " + res);
		return res;
	}

	public String commitExam(String tag, String cmd, JSONObject params) {
		String wareOne2One = Config.getString("commitExam");
		Gson gson = new Gson();
		CommitExamBean commitExamBean = gson.fromJson(gson.toJson(params),
				CommitExamBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = httpRest(wares_server, wareOne2One, null,
				commitExamBean, "POST");
		log.info("commitExam  return is " + res);
		return res;
	}


	public String updateWaresLive(String tag, String cmd, JSONObject params) {
		String updateWaresLive = Config.getString("updateWaresLive");
		Gson gson = new Gson();
		WareLiveBean wareLiveBean = gson.fromJson(gson.toJson(params),WareLiveBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = httpRest(wares_server,updateWaresLive,null,wareLiveBean,"PUT");
		log.info("updateWaresLive return is :-> "+res);
		return res;
	}
}
