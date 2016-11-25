package com.yijiajiao.rabbitmq.bean;

/**
 * Created by Administrator on 2016/9/19.
 */
public enum LogicEnum {
    UpLoadVedio           (20001,"UpLoadVedio"),
    ApplyTeacher          (20002,"ApplyTeacher"),
    SetStore              (20003,"SetStore"),
    ApplyPermission       (20004,"ApplyPermission"),
    PassTest              (20005,"PassTest"),
    Insertanswerpermission(20006,"Insertanswerpermission"),
    WareLive              (20007,"WareLive"),
    WareVideo             (20008,"WareVideo"),
    WareOne2One           (20009,"WareOne2One"),
    CommitExam            (20010,"CommitExam"),
    CreateOrder           (20011,"CreateOrder"),
    CreateRefund          (20012,"CreateRefund"),
    UpdateAppraise        (20013,"UpdateAppraise"),
    UpdateAppraiseReback  (20014,"UpdateAppraiseReback"),
    Complete              (20015,"Complete"),
    Ask                   (20016,"Ask"),
    Answer                (20017,"Answer"),
    AddDoubt              (20018,"AddDoubt"),
    UpdateDoubt           (20019,"UpdateDoubt"),
    AddComplain           (20020,"AddComplain"),
    ReBackComplain        (20021,"ReBackComplain"),
    FeedBack              (20022,"FeedBack"),
    BindAliPay            (20023,"BindAliPay"),
    SetMsg                (20024,"SetMsg"),
    CreateExam            (20025,"CreateExam"),
    CreateExamDetail      (20026,"CreateExamDetail"),
    AddQuestions          (20027,"AddQuestions"),
    SmartCreateExam       (20028,"SmartCreateExam"),
    ApplyInterviewTime    (20029,"ApplyInterviewTime"),
    ApplyFacingTeachTime  (20030,"ApplyFacingTeachTime"),
    AddTimePakage         (20031,"AddTimePakage"),
    SolutionAppraise      (20032,"SolutionAppraise"),
    SolutionFeedBack      (20033,"SolutionFeedBack"),
    DiagnoseAnswerSubmit  (20034,"DiagnoseAnswerSubmit"),
    MarkingPaper          (20035,"MarkingPaper"),
    UpdateWaresLive       (20036,"UpdateWaresLive");

    private LogicEnum(int code, String str) {
        this.code = code;
        this.str = str;
    }

    private int code;
    private String str;

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getStr() {
        return str;
    }

    private void setStr(String str) {
        this.str = str;
    }
}
