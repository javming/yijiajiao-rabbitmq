package com.yijiajiao.rabbitmq.util;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.yijiajiao.rabbitmq.bean.DateBean;
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class RabbitmqUtil {
	public static String httpRest(String server, String url,
			Map<String, Object> param, Object object, String method) {
		ClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client c = Client.create(config);
		WebResource r = c.resource("http://" + server + url);
		System.out.println("请求其他地址：" + "http://" + server + url);
		Builder builder = r.header("Content-Type", MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON);
		ClientResponse response = null;
		if (param != null) {
			Iterator i = param.entrySet().iterator();
			while (i.hasNext()) {
				Map.Entry en = (Map.Entry) i.next();
				builder.header((String) en.getKey(), en.getValue());
			}
		}
		if (method.equals("POST")) {
			response = builder.post(ClientResponse.class, object);
		} else if (method.equals("GET")) {
			response = builder.get(ClientResponse.class);
		} else if (method.equals("PUT")) {
			response = builder.put(ClientResponse.class, object);
		} else if (method.equals("DELETE")) {
			response = builder.delete(ClientResponse.class);
		}
		String result = response.getEntity(String.class);
		System.out.println("接受其他系统信息：" + result);
		return result;
	}

	public static void asyncHttpRest(String server, String url,
									 Map<String, Object> param, Object object, String method) throws ExecutionException, InterruptedException {
		ClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client c = Client.create(config);
		AsyncWebResource r = c.asyncResource("http://" + server + url);
		System.out.println("请求其他地址：" + "http://" + server + url);
		//Builder builder = r.header("Content-Type", MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
		Future<ClientResponse> response = null;
		if (param != null) {
			Iterator i = param.entrySet().iterator();
			while (i.hasNext()) {
				Map.Entry en = (Map.Entry) i.next();
				r.header((String) en.getKey(), en.getValue());
			}
		}
		if (method.equals("POST")) {
			response = r.post(ClientResponse.class, object);
		} else if (method.equals("GET")) {
			response = r.get(ClientResponse.class);
		} else if (method.equals("PUT")) {
			response = r.put(ClientResponse.class, object);
		} else if (method.equals("DELETE")) {
			response = r.delete(ClientResponse.class);
		}
		String result = response.get().getEntity(String.class);
		System.out.println("接受其他系统信息：" + result);

	}


	public static ClientResponse resource(String url, Object requestEntity,
			String method) {
		ClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client c = Client.create(config);
		WebResource r = c.resource(url);
		ClientResponse response = null;
		if ("POST".equals(method)) {
			response = r.header("Content-Type", MediaType.APPLICATION_JSON)
					.type(MediaType.APPLICATION_JSON)
					.post(ClientResponse.class, requestEntity);
		} else if ("GET".equals(method)) {
			response = r.accept(MediaType.APPLICATION_JSON).get(
					ClientResponse.class);
		} else if ("PUT".equals(method)) {
			response = r.header("Content-Type", MediaType.APPLICATION_JSON)
					.type(MediaType.APPLICATION_JSON)
					.put(ClientResponse.class, requestEntity);
		}
		return response;
	}

	// json转化成对象
	public static Object getTransObject(String param, Class<?> clazz)
			throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Object obj = mapper.readValue(URLDecoder.decode(param, "UTF-8"), clazz);
		return obj;
	}

	public static Date long2Date(long time) throws ParseException {
		Date result = null;
		String since = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date(time * 1000));
		result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(since);
		return result;
	}

	public static String getDateStr() throws ParseException {
		String result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
		return result;
	}

	public static int getPageCount(int item, int pagesize) {
		int pagecount = 0;
		if (item % pagesize == 0) {
			pagecount = item / pagesize;
		} else {
			pagecount = item / pagesize + 1;
		}
		return pagecount;
	}

	public static void main(String[] args) {
		try {
			System.out.println(getDateStr());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static DateBean getRightDate(long since, long max) {
		DateBean dateBean = new DateBean();
		Date sincetime = null;
		Date maxtime = null;
		try {
			if (since == -1 && max == -1) {
				sincetime = RabbitmqUtil.long2Date(-28800L);
				maxtime = RabbitmqUtil.long2Date(91845924611L);
			} else if (since != -1 && max == -1) {
				sincetime = RabbitmqUtil.long2Date(since);
				maxtime = RabbitmqUtil.long2Date(91845924611L);
			} else if (since == -1 && max != -1) {
				sincetime = RabbitmqUtil.long2Date(-28800L);
				maxtime = RabbitmqUtil.long2Date(max);
			} else {
				sincetime = RabbitmqUtil.long2Date(since);
				maxtime = RabbitmqUtil.long2Date(max);
			}
			dateBean.setSince(sincetime);
			dateBean.setMax(maxtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateBean;
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @param old
	 * @return
	 */
	public static Date convertDateToNoMs(Date old) {
		String aa = new SimpleDateFormat("yyyyMMddHHmmss").format(old);
		Date t = null;
		try {
			t = new SimpleDateFormat("yyyyMMddHHmmss").parse(aa);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return t;
	}

	public static String toUTF8(String m) {
		String msg = null;
		try {
			msg = new String(m.getBytes("gbk"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public static JSONObject objectToJson(Object r) {
		return JSONObject.fromObject(r);
	}
}
