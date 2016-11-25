package com.yijiajiao.rabbitmq.message;

import com.yijiajiao.rabbitmq.bean.LogicEnum;
import com.yijiajiao.rabbitmq.bean.ResultBean;
import com.yijiajiao.rabbitmq.bean.SystemStatus;
import com.yijiajiao.rabbitmq.service.*;
import com.yijiajiao.rabbitmq.util.TokenUtil;
import net.rubyeye.xmemcached.MemcachedClient;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @AUTHOR zhaoming@eduspace
 * @CREATE 2016-11-23-9:43
 */
public class LogicThread implements Runnable{

    private static Logger log = LoggerFactory.getLogger(LogicThread.class);
    private String message;
    private MemcachedClient memcachedClient;
    private WareLogic wareLogic;
    private UserLogic userLogic;
    private SaleLogic saleLogic;
    private SolutionLogic solutionLogic;
    private TeachLogic teachLogic;
    private OssLogic ossLogic;
    private FinanceLogic financeLogic;
    private MsgLogic msgLogic;
    private BaseDataLogic baseDataLogic;
    public LogicThread() {
    }

    public LogicThread(String message, MemcachedClient memcachedClient, WareLogic wareLogic, UserLogic userLogic,
                       SaleLogic saleLogic, SolutionLogic solutionLogic, TeachLogic teachLogic, OssLogic ossLogic,
                       FinanceLogic financeLogic, MsgLogic msgLogic, BaseDataLogic baseDataLogic) {
        this.message = message;
        this.memcachedClient = memcachedClient;
        this.wareLogic = wareLogic;
        this.userLogic = userLogic;
        this.saleLogic = saleLogic;
        this.solutionLogic = solutionLogic;
        this.teachLogic = teachLogic;
        this.ossLogic = ossLogic;
        this.financeLogic = financeLogic;
        this.msgLogic = msgLogic;
        this.baseDataLogic = baseDataLogic;
    }

    @Override
    public void run() {
        JSONObject jsonObject= new JSONObject();
        String cmd = "";
        String tag = "error";
        String token = "";
        String openId = "";
        try {
            jsonObject = JSONObject.fromObject(message);
            cmd = jsonObject.getString("cmd");
            tag = jsonObject.getString("tag");
            token = jsonObject.getString("token");
            openId = jsonObject.getString("openId");
        } catch (JSONException e) {
            log.error("----message 转换json对象时 error :"+e.getMessage());
            return;
        }
        //验证登录信息
        if (!TokenUtil.verifyToken(token, openId)) {
            ResultBean resultBean = new ResultBean();
            resultBean.setFailMsg(SystemStatus.TOKEN_TIME_OUT);
            log.info("token: " + token + " openId:" + openId
                    + " ,token验证失败");
            setMemcached(tag, JSONObject.fromObject(resultBean).toString());
        }else{
            JSONObject params = (JSONObject) jsonObject.get("params");
            System.out.println("params=="+params.toString());
            String backValue = "";
            try {
                LogicEnum logic = LogicEnum.valueOf(cmd);
                backValue = logicRest(tag,cmd,params,logic);
            }
            catch (Exception e){
                e.printStackTrace();
                ResultBean resultBean = new ResultBean();
                resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
                backValue = JSONObject.fromObject(resultBean).toString();
            }
            setMemcached(tag, backValue);
        }
    }
    private String logicRest(String tag,String cmd,JSONObject params,LogicEnum logic){
        switch (logic){
            case UpLoadVedio:
                return wareLogic.uploadVideo(tag, cmd, params);
            case ApplyTeacher:
                return userLogic.applyteacher(tag, cmd, params);
            case SetStore:
                return userLogic.setStore(tag, cmd, params);
            case ApplyPermission:
                return teachLogic.applyPermission(tag, cmd,params);
            case PassTest:
                return teachLogic.passTest(tag, cmd, params);
            case Insertanswerpermission:
                return teachLogic.insertanswerpermission(tag,cmd, params);
            case WareLive:
                return wareLogic.wareLive(tag, cmd, params);
            case WareVideo:
                return wareLogic.wareVideo(tag, cmd, params);
            case WareOne2One:
                return wareLogic.wareOne2One(tag, cmd, params);
            case CommitExam:
                return wareLogic.commitExam(tag, cmd, params);
            case CreateOrder:
                return saleLogic.createOrder(tag, cmd, params);
            case CreateRefund:
                return saleLogic.createRefund(tag, cmd, params);
            case UpdateAppraise:
                return saleLogic.updateAppraise(tag, cmd,params);
            case UpdateAppraiseReback:
                return saleLogic.updateAppraiseReback(tag, cmd,params);
            case Complete:
                return userLogic.complete(tag, cmd, params);
            case Ask:
                return solutionLogic.updateAsk(tag, cmd, params);
            case Answer:
                return solutionLogic.updateAnswer(tag, cmd,params);
            case AddDoubt:
                return solutionLogic.addDoubt(tag, cmd, params);
            case UpdateDoubt:
                return solutionLogic.updateDoubt(tag, cmd,params);
            case AddComplain:
                return solutionLogic.addComplain(tag, cmd,params);
            case ReBackComplain:
                return solutionLogic.reBackComplain(tag, cmd,params);
            case FeedBack:
                return ossLogic.feedBack(tag, cmd, params);
            case BindAliPay:
                return financeLogic.bindAliPay(tag, cmd, params);
            case SetMsg:
                return msgLogic.SetMsg(tag, cmd, params);
            case CreateExam:
                log.info("手动组卷头");
                return baseDataLogic.CreateExam(tag, cmd,params);
            case CreateExamDetail:
                log.info("手动组卷详情");
                return baseDataLogic.CreateExamDetail(tag, cmd,params);
            case AddQuestions:
                log.info("手动组卷添加试题");
                return baseDataLogic.AddQuestions(tag, cmd,params);
            case SmartCreateExam:
                log.info("自动组卷");
                return baseDataLogic.SmartCreateExam(tag, cmd,params);
            case ApplyInterviewTime:
                log.info("申请面试时间");
                return teachLogic.applyInterviewTime(tag,cmd,params);
            case ApplyFacingTeachTime:
                log.info("申请面授时间");
                return teachLogic.applyFacingTeachTime(tag,cmd,params);
            case AddTimePakage:
                log.info("添加答疑时长包");
                return solutionLogic.addTimePakage(tag,cmd,params);
            case SolutionAppraise:
                log.info("答疑评价");
                return solutionLogic.solutionAppraise(tag,cmd,params);
            case SolutionFeedBack:
                log.info("教师端添加反馈理由");
                return solutionLogic.solutionFeedBack(tag,cmd,params);
            case DiagnoseAnswerSubmit:
                log.info("诊断试卷提交答案");
                return teachLogic.diagnoseAnswerSubmit(tag,cmd,params);
            case MarkingPaper:
                log.info("课中练习/课后作业/模拟考交卷");
                return baseDataLogic.markingPaper(tag,cmd,params);
            case UpdateWaresLive:
                log.info("修改课程信息");
                return wareLogic.updateWaresLive(tag,cmd,params);
            default:
                log.info("没有匹配该请求的路径：cmd="+cmd);
                return "没有匹配该请求的路径!";
        }
    }
    private void setMemcached(String tag, String value) {
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
