package com.yijiajiao.rabbitmq.service;

import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.*;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.RabbitmqUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolutionLogic {
	private static Logger log =  LoggerFactory.getLogger(SolutionLogic.class.getName());
	String solution_server = Config.getString("solution_server");

	public String updateAsk(String tag, String cmd, JSONObject params) {
		String updateAsk = Config.getString("updateAsk");
		Gson gson = new Gson();
		UpdateAskBean updateAskBean = gson.fromJson(gson.toJson(params),
				UpdateAskBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(solution_server, updateAsk, null,
				updateAskBean, "POST");
		log.info("updateAsk return is " + res);
		return res;
	}

	public String updateAnswer(String tag, String cmd, JSONObject params) {
		String updateAnswer = Config.getString("updateAnswer");
		Gson gson = new Gson();
		UpdateAnswerBean updateAnswerBean = gson.fromJson(gson.toJson(params),
				UpdateAnswerBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(solution_server, updateAnswer, null,
				updateAnswerBean, "POST");
		log.info("updateAnswer return is " + res);
		return res;
	}

	public String addDoubt(String tag, String cmd, JSONObject params) {
		String addDoubt = Config.getString("addDoubt");
		Gson gson = new Gson();
		AddDoubtBean addDoubtBean = gson.fromJson(gson.toJson(params),
				AddDoubtBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(solution_server, addDoubt, null,
				addDoubtBean, "POST");
		log.info("addDoubt return is " + res);
		return res;
	}

	public String updateDoubt(String tag, String cmd, JSONObject params) {
		String updateDoubt = Config.getString("updateDoubt");
		Gson gson = new Gson();
		AddDoubtBean updateDoubtBean = gson.fromJson(gson.toJson(params),
				AddDoubtBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(solution_server, updateDoubt, null,
				updateDoubtBean, "POST");
		log.info("updateDoubtBean return is " + res);
		return res;
	}

	public String addComplain(String tag, String cmd, JSONObject params) {
		String addComplain = Config.getString("addComplain");
		Gson gson = new Gson();
		AddComplainBean addComplainBean = gson.fromJson(gson.toJson(params),
				AddComplainBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(solution_server, addComplain, null,
				addComplainBean, "POST");
		log.info("addComplain return is " + res);
		return res;
	}

	public String reBackComplain(String tag, String cmd, JSONObject params) {
		String reBackComplain = Config.getString("reBackComplain");
		Gson gson = new Gson();
		ReBackComplainBean reBackComplainBean = gson.fromJson(
				gson.toJson(params), ReBackComplainBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(solution_server, reBackComplain,
				null, reBackComplainBean, "POST");
		log.info("reBackComplain return is " + res);
		return res;
	}

	public String addTimePakage(String tag, String cmd, JSONObject params) {
		String path = Config.getString("addtimepakage");
		Gson gson = new Gson();
		AddTimePakageBean addTimePakageBean = gson.fromJson(gson.toJson(params), AddTimePakageBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(solution_server, path, null, addTimePakageBean, "POST");
		log.info("addtimepakage  return is "+res);
		return res;
	}

	public String solutionAppraise(String tag, String cmd, JSONObject params) {
		String path =Config.getString("solutionAppraise");
		Gson gson = new Gson();
		AppraiseSolutionBean appraiseSolutionBean = gson.fromJson(gson.toJson(params), AppraiseSolutionBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(solution_server, path, null, appraiseSolutionBean, "POST");
		log.info("appraiseSolution return is "+res);
		return res;
	}

	public String solutionFeedBack(String tag, String cmd, JSONObject params) {
		String path = Config.getString("solutionFeedBack");
		Gson gson = new Gson();
		SolutionFeedBackBean solutionFeedBackBean = gson.fromJson(gson.toJson(params), SolutionFeedBackBean.class);
		log.info("gson.toJson(params): " + gson.toJson(params));
		String res = RabbitmqUtil.httpRest(solution_server, path, null, solutionFeedBackBean, "POST");
		log.info("solutionFeedBack return is "+res);
		return res;
	}

}
