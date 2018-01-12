package com.example.service.ivrcall.api.dto;

import com.example.service.ivrcall.dao.po.BasePO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by baota on 2017/7/26.
 */
@Data
public class AutoCallDTO extends BasePO {

    private String businessKey;//业务ID

    private Long caseId;//案件ID
    private Long applicationId; //申请单号
    private Long customerId; //客户ID
    private String realname; //申请用户姓名
    private String mobile; //申请用户手机号码
    private String flowRatePhase; // 波动率逾期周期. M1,M2,M3等
    private Date recallDate; //催收日期
    private BigDecimal overdueAmount; //逾期金额
    private Integer overdueDays; //逾期天数
    private Long uid; //挖财用户id
    private String loanType; //贷款类型

    private String client;//客户端
    private String gender;//性别
    private String debitCardno;//银行卡号
    private String sumAmount;//应收金额总计

    private String contactRelation;//联系人关系
    private String riskLevel;//风险等级
    private Integer isPtp;//是否承诺还款
    private String taskSource;//任务
    private String agent;//坐席
    private String superior;//上级
    private String organizationName;//组织名称


    private String callBeginTime;//拨打开始时间
    private String callEndTime;//拨打结束时间
    private String ringingTime;//振铃时长
    private String callTime;//通话时长
    private String callResult;//拨打结果
    private Integer attempt;//拨打次数
    private Integer recordStatus;//记录状态
    private String inputMenu;//按键反馈
    private String voiceTemplet;//语音模板
}
