package com.nssoft.generator.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_REMIND_PRODUCTS")
public class ChajaDtRemindProducts {
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
     * 开发编号
     */
    @Id
    private String develop_no;

    /**
     * 开发日期
     */
    @Id
    private Date reg_date;

    /**
     * 担当
     */
    private String sign;

    /**
     * 跳转页面
     */
    private String url;

    /**
     * 是否确认
     */
    private String confirm_yn;

    /**
     * 快递记录号
     */
    private String express_record_no;

    /**
     * 担当者邮箱
     */
    private String sign_email;

    /**
     * 款号
     */
    private String item_no;

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
     * 获取开发编号
     *
     * @return develop_no - 开发编号
     */
    public String getDevelop_no() {
        return develop_no;
    }

    /**
     * 设置开发编号
     *
     * @param develop_no 开发编号
     */
    public void setDevelop_no(String develop_no) {
        this.develop_no = develop_no;
    }

    /**
     * 获取开发日期
     *
     * @return reg_date - 开发日期
     */
    public Date getReg_date() {
        return reg_date;
    }

    /**
     * 设置开发日期
     *
     * @param reg_date 开发日期
     */
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    /**
     * 获取担当
     *
     * @return sign - 担当
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置担当
     *
     * @param sign 担当
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取跳转页面
     *
     * @return url - 跳转页面
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置跳转页面
     *
     * @param url 跳转页面
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取是否确认
     *
     * @return confirm_yn - 是否确认
     */
    public String getConfirm_yn() {
        return confirm_yn;
    }

    /**
     * 设置是否确认
     *
     * @param confirm_yn 是否确认
     */
    public void setConfirm_yn(String confirm_yn) {
        this.confirm_yn = confirm_yn;
    }

    /**
     * 获取快递记录号
     *
     * @return express_record_no - 快递记录号
     */
    public String getExpress_record_no() {
        return express_record_no;
    }

    /**
     * 设置快递记录号
     *
     * @param express_record_no 快递记录号
     */
    public void setExpress_record_no(String express_record_no) {
        this.express_record_no = express_record_no;
    }

    /**
     * 获取担当者邮箱
     *
     * @return sign_email - 担当者邮箱
     */
    public String getSign_email() {
        return sign_email;
    }

    /**
     * 设置担当者邮箱
     *
     * @param sign_email 担当者邮箱
     */
    public void setSign_email(String sign_email) {
        this.sign_email = sign_email;
    }

    /**
     * 获取款号
     *
     * @return item_no - 款号
     */
    public String getItem_no() {
        return item_no;
    }

    /**
     * 设置款号
     *
     * @param item_no 款号
     */
    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }
}