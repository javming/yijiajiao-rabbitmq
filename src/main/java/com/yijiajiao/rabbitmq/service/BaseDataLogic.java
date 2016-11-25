package com.yijiajiao.rabbitmq.service;


import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.*;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.RabbitmqUtil;
import com.yijiajiao.rabbitmq.util.RedisUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseDataLogic {

	private static Logger log = LoggerFactory.getLogger(BaseDataLogic.class);
	String wares_server = Config.getString("wares_server");
	String sale_server = Config.getString("sale_server");

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

	public String AddQuestions(String tag, String cmd, JSONObject params) {
		String AddQuestions = Config.getString("AddQuestions");
		Gson gson = new Gson();
		AddQuestionsBean addQuestionsBean = gson.fromJson(
				gson.toJson(params), AddQuestionsBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(wares_server, AddQuestions, null,
				addQuestionsBean, "POST");
		log.info("AddQuestions return is " + res);
		return res;
	}
	
	public String markingPaper(String tag, String cmd, JSONObject params) {
		String markingPaper = Config.getString("markingPaper");
		Gson gson = new Gson();
		DiagnoseAnswerSubmitBean diagnoseAnswerSubmitBean = gson.fromJson(gson.toJson(params),
				DiagnoseAnswerSubmitBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(wares_server, markingPaper, null,
				diagnoseAnswerSubmitBean, "POST");
		log.info("markingPaper  return is " + res);
		ResultBean result = gson.fromJson(res, ResultBean.class);
		if(result.getCode()!=200){
			return res;
		}
		if (diagnoseAnswerSubmitBean.getSubmitType()==null){
			System.out.println("修改ishomework为 2");
			String updateIsHomework=Config.getString("updateIsHomework")+"openId="+diagnoseAnswerSubmitBean.getOpenId()+
					"&commodityId="+diagnoseAnswerSubmitBean.getWaresId()+"&slaveId="+
					(diagnoseAnswerSubmitBean.getWaresSlaveId()==null||"".equals(diagnoseAnswerSubmitBean.getWaresSlaveId())?-1:diagnoseAnswerSubmitBean.getWaresSlaveId());
			RabbitmqUtil.httpRest(sale_server,updateIsHomework,null,null,"PUT");
		}
		RedisUtil.putRedis(tag, res, 36000);
		result.setSucResult(tag);
		String json = gson.toJson(result);
		return json;
	}

}
