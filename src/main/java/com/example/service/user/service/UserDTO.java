package com.example.service.user.service;

import lombok.Data;

import java.util.Date;

/**
 * Created by baota on 2018/2/4.
 */
@Data
public class UserDTO {

    private Integer id;
    /**
     * 账户，花名拼音
     */
    private String account;
    /**
     * 花名，别名
     */
    private String nickname;
    /**
     * 用户类型，1：内部员工，2：外部员工
     */
    private String type;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 固定电话
     */
    private String telephone;
    /**
     * 上级账户，上级领导账户
     */
    private String superiorAccount;
    /**
     * 外包组织机构ID
     */
    private Integer organizationId;
    /**
     * 外包组织机构名称
     */
    private String organizationName;
    /**
     * 是否分单
     */
    private Boolean assignCase;
    /**
     * 状态，是否启用
     */
    private boolean enabled;
    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 创建时间
     */
    private Date createTime;
}
