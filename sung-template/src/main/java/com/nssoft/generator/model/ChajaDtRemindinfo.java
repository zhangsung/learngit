package com.nssoft.generator.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_REMINDINFO")
public class ChajaDtRemindinfo {
    /**
     * 时间
     */
    @Id
    private Date reg_dt;

    /**
     * 消息类型
     */
    @Id
    private String msg_type;

    /**
     * 确认内容
     */
    private String confirm_msg;

    /**
     * 获取时间
     *
     * @return reg_dt - 时间
     */
    public Date getReg_dt() {
        return reg_dt;
    }

    /**
     * 设置时间
     *
     * @param reg_dt 时间
     */
    public void setReg_dt(Date reg_dt) {
        this.reg_dt = reg_dt;
    }

    /**
     * 获取消息类型
     *
     * @return msg_type - 消息类型
     */
    public String getMsg_type() {
        return msg_type;
    }

    /**
     * 设置消息类型
     *
     * @param msg_type 消息类型
     */
    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    /**
     * 获取确认内容
     *
     * @return confirm_msg - 确认内容
     */
    public String getConfirm_msg() {
        return confirm_msg;
    }

    /**
     * 设置确认内容
     *
     * @param confirm_msg 确认内容
     */
    public void setConfirm_msg(String confirm_msg) {
        this.confirm_msg = confirm_msg;
    }
}