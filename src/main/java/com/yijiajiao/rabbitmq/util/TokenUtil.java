package com.yijiajiao.rabbitmq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenUtil {
/*	private static String url = Config.uuimsString("url");
	private static String ak = Config.uuimsString("ak");
	private static String sk = Config.uuimsString("sk");*/
	private static final String WEBCLIENT="E-web";
	private static Logger log = LoggerFactory.getLogger(TokenUtil.class.getName());

	public TokenUtil() {
	}

	public static boolean verifyToken(String token, String openId) {
		log.info("验证登录信息=====》token="+token+"--openId="+openId);
		boolean b = false;
		   if(token==null || openId == null || "".equals(openId) || "".equals(token)){
			   System.out.println("---数据为空！");
			   return false;
		   }
/*		OauthClient client = new OauthClient(url, token);
		ValidateTokenRequest request = new ValidateTokenRequest();
		request.setOpenId(openId);
		System.out.println(request);
		
			ValidateTokenResponse response = client.execute(request);
			System.out.println(response);
			if (response.getMessage().equals("Success")) {
				System.out.println("验证通过");
				b = true;
			}*/
	     try {
				String key0 = new StringBuilder(openId).append(0).toString();
				String key1 = new StringBuilder(openId).append(1).toString();
				
				boolean flag0 = RedisUtil.exist(key0);
				boolean flag1 = RedisUtil.exist(key1);
				System.out.println("key0=="+key0+"---flag0=="+flag0+"----key1=="+key1+"---flag1=="+flag1);
				if(flag0 && flag1){
					String value0 = RedisUtil.getValue(key0);
					String value1 = RedisUtil.getValue(key1);
					if(token.equals(value0)){
						RedisUtil.expire(key0, RedisUtil.webexpire);
						log.info("验证通过！");
						b= true;
					}else if(token.equals(value1)){
						RedisUtil.expire(key1, RedisUtil.appexpire);
						log.info("验证通过！");
						b= true;
					}else{
						b=false;
					}
				}else if(flag0 && !flag1){
					String value = RedisUtil.getValue(key0);
					if(token.equals(value)){
						RedisUtil.expire(key0, RedisUtil.webexpire);
						b= true;
						log.info("验证通过！");
					}else{
						b= false;
					}
				}else if(!flag0 && flag1){
					String value = RedisUtil.getValue(key1);
					if(token.equals(value)){
						RedisUtil.expire(key1, RedisUtil.appexpire);
						b= true;
						log.info("验证通过！");
					}else{
						b= false;
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
			b= false;
		}
	     return b;
	}

	   public static void putToken(String openId,String token,String clientId){
		   StringBuilder sb = new StringBuilder(openId);
		   if(WEBCLIENT.equals(clientId)){
			   sb.append(0);//表示web登录
			   RedisUtil.putRedis(sb.toString(), token, RedisUtil.webexpire);
		   }else{
			   sb.append(1);//表示移动端登录
			   RedisUtil.putRedis(sb.toString(), token, RedisUtil.appexpire);
		   }
	   }
	

}
