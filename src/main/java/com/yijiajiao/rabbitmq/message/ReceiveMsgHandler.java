package com.yijiajiao.rabbitmq.message;

import com.google.gson.Gson;
import com.yijiajiao.rabbitmq.bean.ResultBean;
import com.yijiajiao.rabbitmq.bean.SystemStatus;
import com.yijiajiao.rabbitmq.service.*;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.HessionCodecFactory;
import com.yijiajiao.rabbitmq.util.TokenUtil;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description	消息消费者，处理异步业务
 * @author  zhaoming
 * @date 2016-8-13
 */
public class ReceiveMsgHandler implements MessageListener{
	
	private static Logger logger = LoggerFactory.getLogger(ReceiveMsgHandler.class);
	@Autowired
	WareLogic wareLogic;
	@Autowired
	UserLogic userLogic;
	@Autowired
	SaleLogic saleLogic;
	@Autowired
	SolutionLogic solutionLogic;
	@Autowired
	TeachLogic teachLogic;
	@Autowired
	OssLogic ossLogic;
	@Autowired
	FinanceLogic financeLogic;
	@Autowired
	MsgLogic msgLogic;
	@Autowired
	BaseDataLogic baseDataLogic;

	@Override
	public void onMessage(Message  message){
		long start = System.currentTimeMillis();
		String receiveMsg=null;
		try {
			receiveMsg =(String) HessionCodecFactory.deSerialize(message.getBody());
		} catch (Exception e) {
			logger.info(e.toString(),e);
		}
		if(receiveMsg != null && !"".equals(receiveMsg)){
			logger.info("get command is  :\n" + receiveMsg);
			if (receiveMsg != null) {
				return;
			}
			JSONObject jb= new JSONObject();
			try {
				jb = JSONObject.fromObject(receiveMsg);
			} catch (Exception e) {
				System.err.println("消息数据格式错误！！！");
				e.printStackTrace();
				return;
			}
			String cmd = jb.getString("cmd");
			String tag = jb.getString("tag");
			String token = jb.getString("token");
			String openId = jb.getString("openId");
			//验证登录信息
			if (!TokenUtil.verifyToken(token, openId)) {
				ResultBean resultBean = new ResultBean();
				resultBean.setFailMsg(SystemStatus.TOKEN_TIME_OUT);
				logger.info("token: " + token + " openId:" + openId
						+ " ,token验证失败");
				setMemcached(tag, new Gson().toJson(resultBean));
			}else{
				JSONObject params = (JSONObject) jb.get("params");
				System.out.println("params=="+params.toString());
				if ("UpLoadVedio".equals(cmd)) {
					String backvalue = wareLogic.uploadVideo(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("ApplyTeacher".equals(cmd)) {
					String backvalue = userLogic.applyteacher(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("SetStore".equals(cmd)) {
					String backvalue = userLogic.setStore(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("ApplyPermission".equals(cmd)) {
					String backvalue = teachLogic.applyPermission(tag, cmd,
							params);
					setMemcached(tag, backvalue);
				}

				if ("PassTest".equals(cmd)) {
					String backvalue = teachLogic.passTest(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("Insertanswerpermission".equals(cmd)) {
					String backvalue = teachLogic.insertanswerpermission(tag,
							cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("WareLive".equals(cmd)) {
					String backvalue = wareLogic.wareLive(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("WareVideo".equals(cmd)) {
					String backvalue = wareLogic.wareVideo(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("WareOne2One".equals(cmd)) {
					String backvalue = wareLogic.wareOne2One(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("CommitExam".equals(cmd)) {
					String backvalue = wareLogic.commitExam(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("CreateOrder".equals(cmd)) {
					String backvalue = saleLogic.createOrder(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("CreateRefund".equals(cmd)) {
					String backvalue = saleLogic.createRefund(tag, cmd, params);
					setMemcached(tag, backvalue);
				}
				if ("UpdateAppraise".equals(cmd)) {
					String backvalue = saleLogic.updateAppraise(tag, cmd,
							params);
					setMemcached(tag, backvalue);
				}
				if ("UpdateAppraiseReback".equals(cmd)) {
					String backvalue = saleLogic.updateAppraiseReback(tag, cmd,
							params);
					setMemcached(tag, backvalue);
				}
				if ("Complete".equals(cmd)) {
					String backvalue = userLogic.complete(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("Ask".equals(cmd)) {
					String backvalue = solutionLogic
							.updateAsk(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("Answer".equals(cmd)) {
					String backvalue = solutionLogic.updateAnswer(tag, cmd,
							params);
					setMemcached(tag, backvalue);
				}

				if ("AddDoubt".equals(cmd)) {
					String backvalue = solutionLogic.addDoubt(tag, cmd, params);
					setMemcached(tag, backvalue);
				}
				if ("UpdateDoubt".equals(cmd)) {
					String backvalue = solutionLogic.updateDoubt(tag, cmd,
							params);
					setMemcached(tag, backvalue);
				}
				if ("AddComplain".equals(cmd)) {
					String backvalue = solutionLogic.addComplain(tag, cmd,
							params);
					setMemcached(tag, backvalue);
				}
				if ("ReBackComplain".equals(cmd)) {
					String backvalue = solutionLogic.reBackComplain(tag, cmd,
							params);
					setMemcached(tag, backvalue);
				}

				if ("FeedBack".equals(cmd)) {
					String backvalue = ossLogic.feedBack(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("BindAliPay".equals(cmd)) {
					String backvalue = financeLogic
							.bindAliPay(tag, cmd, params);
					setMemcached(tag, backvalue);
				}
				if ("SetMsg".equals(cmd)) {
					String backvalue = msgLogic.SetMsg(tag, cmd, params);
					setMemcached(tag, backvalue);
				}

				if ("CreateExam".equals(cmd)) {
					logger.info("手动组卷头");
					String backvalue = baseDataLogic.CreateExam(tag, cmd,
							params);
					setMemcached(tag, backvalue);
				}
				if ("CreateExamDetail".equals(cmd)) {
					logger.info("手动组卷详情");
					String backvalue = baseDataLogic.CreateExamDetail(tag, cmd,
							params);
					setMemcached(tag, backvalue);
				}
				if ("SmartCreateExam".equals(cmd)) {
					logger.info("自动组卷");
					String backvalue = baseDataLogic.SmartCreateExam(tag, cmd,
							params);
					setMemcached(tag, backvalue);

				}
				if("ApplyInterviewTime".equals(cmd)){
					logger.info("申请面试时间");
					String backvalue = teachLogic.applyInterviewTime(tag,cmd,params);
					setMemcached(tag, backvalue);
				}
				if("ApplyFacingTeachTime".equals(cmd)){
					logger.info("申请面授时间");
					String backvalue= teachLogic.applyFacingTeachTime(tag,cmd,params);
					setMemcached(tag, backvalue);
				}
				if("AddTimePakage".equals(cmd)){
					logger.info("添加答疑时长包");
					String backvalue = solutionLogic.addTimePakage(tag,cmd,params);
					setMemcached(tag, backvalue);
				}
				if("SolutionAppraise".equals(cmd)){
					logger.info("答疑评价");
					String backvalue = solutionLogic.solutionAppraise(tag,cmd,params);
					setMemcached(tag, backvalue);
				}
				if("SolutionFeedBack".equals(cmd)){
					logger.info("教师端添加反馈理由");
					String backvalue= solutionLogic.solutionFeedBack(tag,cmd,params);
					setMemcached(tag, backvalue);
				}
			}
		}
		long end = System.currentTimeMillis();
		logger.info("spend "+(end-start)+" ms");
	}
	
	
	public MemcachedClient getMemcacheClient(String server, String port) {
		int p = Integer.parseInt(port);
		try {
			MemcachedClient memcachedClient = new XMemcachedClient(server, p);
			memcachedClient.setOpTimeout(Long.parseLong(Config.getString("memcached.optime")));
			return memcachedClient;
		} catch (IOException e) {
			logger.info(e.toString(), e);
		}
		return null;
	}
	public void setMemcached(String tag, String value) {
		String memcachedIp = Config.getString("memcached.ip");
		String memcachedPort = Config.getString("memcached.port");
		MemcachedClient memcachedClient = getMemcacheClient(memcachedIp,
				memcachedPort);
		try {
			boolean flag = memcachedClient.set(tag, 0, value);
			if (flag) {
				logger.info("set memcached result is :    " + tag + " = " + value);
			}
		} catch (MemcachedException e) {
			System.err.println("MemcachedClient operation fail");
			e.printStackTrace();
			logger.info(e.toString(), e);
		} catch (TimeoutException e) {
			System.err.println("MemcachedClient operation timeout");
			logger.info(e.toString(), e);
		} catch (InterruptedException e) {
			// log.info(e.toString(), e);
		}
		try {
			memcachedClient.shutdown();
		} catch (Exception e) {
			logger.debug("Shutdown MemcachedClient fail");
			logger.info(e.toString(), e);
		}
	}
}
