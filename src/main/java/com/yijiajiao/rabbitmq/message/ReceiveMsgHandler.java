package com.yijiajiao.rabbitmq.message;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.yijiajiao.rabbitmq.bean.LogicEnum;
import com.yijiajiao.rabbitmq.bean.ResultBean;
import com.yijiajiao.rabbitmq.bean.SystemStatus;
import com.yijiajiao.rabbitmq.service.*;
import com.yijiajiao.rabbitmq.util.HessionCodecFactory;
import com.yijiajiao.rabbitmq.util.TokenUtil;
import net.rubyeye.xmemcached.MemcachedClient;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description	消息消费者，处理异步业务
 * @author  zhaoming
 * @date 2016-8-13
 */
public class ReceiveMsgHandler implements ChannelAwareMessageListener {
	
	private static Logger log = LoggerFactory.getLogger(ReceiveMsgHandler.class);
	@Autowired
	MemcachedClient memcachedClient;
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
	public void onMessage(Message  message,Channel channel){
		long start = System.currentTimeMillis();
		String receiveMsg=null;
		try {
			receiveMsg =(String) HessionCodecFactory.deSerialize(message.getBody());
		} catch (Exception e) {
			log.info(e.toString(),e);
		}
		try {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
			channel.close();
			log.info("----channel.basicAck success!-----");
		} catch (Exception e) {
			log.error("-----channel.basicAck failed :"+e.getMessage()+"------");
		}
		if(receiveMsg != null && !"".equals(receiveMsg)){
			log.info("get command is  :\n" + receiveMsg);
			if (receiveMsg == null) {
				return;
			}
			JSONObject jsonObject= new JSONObject();
			String cmd = "";
			String tag = "error";
			String token = "";
			String openId = "";
			try {
				jsonObject = JSONObject.fromObject(receiveMsg);
				cmd = jsonObject.getString("cmd");
				tag = jsonObject.getString("tag");
				token = jsonObject.getString("token");
				openId = jsonObject.getString("openId");
			} catch (JSONException e) {
				log.error("----message error :"+e.getMessage());
				return;
			}

			ExecutorService pool = Executors.newFixedThreadPool(500);
			pool.execute(new Runnable() {
				@Override
				public void run() {

				}
			});

			//验证登录信息
			if (!TokenUtil.verifyToken(token, openId)) {
				ResultBean resultBean = new ResultBean();
				resultBean.setFailMsg(SystemStatus.TOKEN_TIME_OUT);
				log.info("token: " + token + " openId:" + openId
						+ " ,token验证失败");
				setMemcached(tag, new Gson().toJson(resultBean));
			}else{
				JSONObject params = (JSONObject) jsonObject.get("params");
				System.out.println("params=="+params.toString());
				try {
					String backvalue;
					LogicEnum logic = LogicEnum.valueOf(cmd);
					switch (logic){
						case UpLoadVedio:
							backvalue = wareLogic.uploadVideo(tag, cmd, params);
							break;
						case ApplyTeacher:
							backvalue = userLogic.applyteacher(tag, cmd, params);
							break;
						case SetStore:
							backvalue = userLogic.setStore(tag, cmd, params);
							break;
						case ApplyPermission:
							backvalue = teachLogic.applyPermission(tag, cmd,params);
							break;
						case PassTest:
							backvalue = teachLogic.passTest(tag, cmd, params);
							break;
						case Insertanswerpermission:
							backvalue = teachLogic.insertanswerpermission(tag,cmd, params);
							break;
						case WareLive:
							backvalue = wareLogic.wareLive(tag, cmd, params);
							break;
						case WareVideo:
							backvalue = wareLogic.wareVideo(tag, cmd, params);
							break;
						case WareOne2One:
							backvalue = wareLogic.wareOne2One(tag, cmd, params);
							break;
						case CommitExam:
							backvalue = wareLogic.commitExam(tag, cmd, params);
							break;
						case CreateOrder:
							backvalue = saleLogic.createOrder(tag, cmd, params);
							break;
						case CreateRefund:
							backvalue = saleLogic.createRefund(tag, cmd, params);
							break;
						case UpdateAppraise:
							backvalue = saleLogic.updateAppraise(tag, cmd,params);
							break;
						case UpdateAppraiseReback:
							backvalue = saleLogic.updateAppraiseReback(tag, cmd,params);
							break;
						case Complete:
							backvalue = userLogic.complete(tag, cmd, params);
							break;
						case Ask:
							backvalue = solutionLogic.updateAsk(tag, cmd, params);
							break;
						case Answer:
							backvalue = solutionLogic.updateAnswer(tag, cmd,params);
							break;
						case AddDoubt:
							backvalue = solutionLogic.addDoubt(tag, cmd, params);
							break;
						case UpdateDoubt:
							backvalue = solutionLogic.updateDoubt(tag, cmd,params);
							break;
						case AddComplain:
							backvalue = solutionLogic.addComplain(tag, cmd,params);
							break;
						case ReBackComplain:
							backvalue = solutionLogic.reBackComplain(tag, cmd,params);
							break;
						case FeedBack:
							backvalue = ossLogic.feedBack(tag, cmd, params);
							break;
						case BindAliPay:
							backvalue = financeLogic.bindAliPay(tag, cmd, params);
							break;
						case SetMsg:
							backvalue = msgLogic.SetMsg(tag, cmd, params);
							break;
						case CreateExam:
							log.info("手动组卷头");
							backvalue = baseDataLogic.CreateExam(tag, cmd,params);
							break;
						case CreateExamDetail:
							log.info("手动组卷详情");
							backvalue = baseDataLogic.CreateExamDetail(tag, cmd,params);
							break;
						case AddQuestions:
							log.info("手动组卷添加试题");
							backvalue = baseDataLogic.AddQuestions(tag, cmd,params);
							break;
						case SmartCreateExam:
							log.info("自动组卷");
							backvalue = baseDataLogic.SmartCreateExam(tag, cmd,params);
							break;
						case ApplyInterviewTime:
							log.info("申请面试时间");
							backvalue = teachLogic.applyInterviewTime(tag,cmd,params);
							break;
						case ApplyFacingTeachTime:
							log.info("申请面授时间");
							backvalue= teachLogic.applyFacingTeachTime(tag,cmd,params);
							break;
						case AddTimePakage:
							log.info("添加答疑时长包");
							backvalue = solutionLogic.addTimePakage(tag,cmd,params);
							break;
						case SolutionAppraise:
							log.info("答疑评价");
							backvalue = solutionLogic.solutionAppraise(tag,cmd,params);
							break;
						case SolutionFeedBack:
							log.info("教师端添加反馈理由");
							backvalue= solutionLogic.solutionFeedBack(tag,cmd,params);
							break;
						case DiagnoseAnswerSubmit:
							log.info("诊断试卷提交答案");
							backvalue= teachLogic.diagnoseAnswerSubmit(tag,cmd,params);
							break;
						case MarkingPaper:
							log.info("课中练习/课后作业/模拟考交卷");
							backvalue= baseDataLogic.markingPaper(tag,cmd,params);
							break;
						case UpdateWaresLive:
							log.info("修改课程信息");
							backvalue= wareLogic.updateWaresLive(tag,cmd,params);
							break;
						default:
							log.info("没有匹配该请求的路径：cmd="+cmd);
							backvalue="没有匹配该请求的路径!";
							break;
					}
					setMemcached(tag, backvalue);
				}
				catch (Exception e){
					e.printStackTrace();
					ResultBean resultBean = new ResultBean();
					resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
					setMemcached(tag, new Gson().toJson(resultBean));
				}
			}
		}
		long end = System.currentTimeMillis();
		log.info("-------------------spend "+(end-start)+" ms------------------");
	}
	
	
/*	public MemcachedClient getMemcacheClient(String server, String port) {
		int p = Integer.parseInt(port);
		try {
			MemcachedClient memcachedClient = new XMemcachedClient(server, p);
			memcachedClient.setOpTimeout(Long.parseLong(Config.getString("memcached.optime")));
			return memcachedClient;
		} catch (IOException e) {
			log.error(e.toString(), e);
		}
		return null;
	}*/
	public void setMemcached(String tag, String value) {
/*		String memcachedIp = Config.getString("memcached.ip");
		String memcachedPort = Config.getString("memcached.port");
		MemcachedClient memcachedClient = getMemcacheClient(memcachedIp,
				memcachedPort);*/
		try {
			boolean flag = memcachedClient.set(tag, 0, value);
			if (flag) {
				log.info("set memcached result is :    " + tag + " = " + value);
			}
		} catch (Exception e) {
			log.error("set MemcachedClient failed!!");
			e.printStackTrace();
		}
	}

}
