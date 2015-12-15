package com.nssoft.generator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_EXPRESSRECORD")
public class ChajaDtExpressrecord {
    /**
     * 记录号
     */
    @Id
    private String express_record_no;

    /**
     * 快递发票的类型
     */
    private String express_type;

    /**
     * 发送日期
     */
    private Date reg_date;

    /**
     * 发送方账号
     */
    private String sender_id;

    /**
     * 发送公司
     */
    private String sender_nm;

    /**
     * 发送者地址
     */
    private String sender_addr;

    /**
     * 发送者电话
     */
    private String sender_tel;

    /**
     * 发送者传真
     */
    private String sender_fax;

    /**
     * 接收方账号
     */
    private String receiver_id;

    /**
     * 接收公司
     */
    private String receiver_nm;

    /**
     * 接收者地址
     */
    private String receiver_addr;

    /**
     * 接收者电话
     */
    private String receiver_tel;

    /**
     * 接收者传真
     */
    private String receiver_fax;

    /**
     * TO
     */
    private String express_to;

    /**
     * FROM
     */
    private String express_from;

    /**
     * 快递号
     */
    private String express_no;

    /**
     * 快递项目号
     */
    private String mail_item_no;

    /**
     * 快递公司
     */
    private String shipped_per;

    /**
     * 付款条款
     */
    private String terms_of_payment;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 总数量
     */
    private Integer total_quantity;

    /**
     * 总金额
     */
    private BigDecimal total_amount;

    /**
     * 获取记录号
     *
     * @return express_record_no - 记录号
     */
    public String getExpress_record_no() {
        return express_record_no;
    }

    /**
     * 设置记录号
     *
     * @param express_record_no 记录号
     */
    public void setExpress_record_no(String express_record_no) {
        this.express_record_no = express_record_no;
    }

    /**
     * 获取快递发票的类型
     *
     * @return express_type - 快递发票的类型
     */
    public String getExpress_type() {
        return express_type;
    }

    /**
     * 设置快递发票的类型
     *
     * @param express_type 快递发票的类型
     */
    public void setExpress_type(String express_type) {
        this.express_type = express_type;
    }

    /**
     * 获取发送日期
     *
     * @return reg_date - 发送日期
     */
    public Date getReg_date() {
        return reg_date;
    }

    /**
     * 设置发送日期
     *
     * @param reg_date 发送日期
     */
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    /**
     * 获取发送方账号
     *
     * @return sender_id - 发送方账号
     */
    public String getSender_id() {
        return sender_id;
    }

    /**
     * 设置发送方账号
     *
     * @param sender_id 发送方账号
     */
    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    /**
     * 获取发送公司
     *
     * @return sender_nm - 发送公司
     */
    public String getSender_nm() {
        return sender_nm;
    }

    /**
     * 设置发送公司
     *
     * @param sender_nm 发送公司
     */
    public void setSender_nm(String sender_nm) {
        this.sender_nm = sender_nm;
    }

    /**
     * 获取发送者地址
     *
     * @return sender_addr - 发送者地址
     */
    public String getSender_addr() {
        return sender_addr;
    }

    /**
     * 设置发送者地址
     *
     * @param sender_addr 发送者地址
     */
    public void setSender_addr(String sender_addr) {
        this.sender_addr = sender_addr;
    }

    /**
     * 获取发送者电话
     *
     * @return sender_tel - 发送者电话
     */
    public String getSender_tel() {
        return sender_tel;
    }

    /**
     * 设置发送者电话
     *
     * @param sender_tel 发送者电话
     */
    public void setSender_tel(String sender_tel) {
        this.sender_tel = sender_tel;
    }

    /**
     * 获取发送者传真
     *
     * @return sender_fax - 发送者传真
     */
    public String getSender_fax() {
        return sender_fax;
    }

    /**
     * 设置发送者传真
     *
     * @param sender_fax 发送者传真
     */
    public void setSender_fax(String sender_fax) {
        this.sender_fax = sender_fax;
    }

    /**
     * 获取接收方账号
     *
     * @return receiver_id - 接收方账号
     */
    public String getReceiver_id() {
        return receiver_id;
    }

    /**
     * 设置接收方账号
     *
     * @param receiver_id 接收方账号
     */
    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    /**
     * 获取接收公司
     *
     * @return receiver_nm - 接收公司
     */
    public String getReceiver_nm() {
        return receiver_nm;
    }

    /**
     * 设置接收公司
     *
     * @param receiver_nm 接收公司
     */
    public void setReceiver_nm(String receiver_nm) {
        this.receiver_nm = receiver_nm;
    }

    /**
     * 获取接收者地址
     *
     * @return receiver_addr - 接收者地址
     */
    public String getReceiver_addr() {
        return receiver_addr;
    }

    /**
     * 设置接收者地址
     *
     * @param receiver_addr 接收者地址
     */
    public void setReceiver_addr(String receiver_addr) {
        this.receiver_addr = receiver_addr;
    }

    /**
     * 获取接收者电话
     *
     * @return receiver_tel - 接收者电话
     */
    public String getReceiver_tel() {
        return receiver_tel;
    }

    /**
     * 设置接收者电话
     *
     * @param receiver_tel 接收者电话
     */
    public void setReceiver_tel(String receiver_tel) {
        this.receiver_tel = receiver_tel;
    }

    /**
     * 获取接收者传真
     *
     * @return receiver_fax - 接收者传真
     */
    public String getReceiver_fax() {
        return receiver_fax;
    }

    /**
     * 设置接收者传真
     *
     * @param receiver_fax 接收者传真
     */
    public void setReceiver_fax(String receiver_fax) {
        this.receiver_fax = receiver_fax;
    }

    /**
     * 获取TO
     *
     * @return express_to - TO
     */
    public String getExpress_to() {
        return express_to;
    }

    /**
     * 设置TO
     *
     * @param express_to TO
     */
    public void setExpress_to(String express_to) {
        this.express_to = express_to;
    }

    /**
     * 获取FROM
     *
     * @return express_from - FROM
     */
    public String getExpress_from() {
        return express_from;
    }

    /**
     * 设置FROM
     *
     * @param express_from FROM
     */
    public void setExpress_from(String express_from) {
        this.express_from = express_from;
    }

    /**
     * 获取快递号
     *
     * @return express_no - 快递号
     */
    public String getExpress_no() {
        return express_no;
    }

    /**
     * 设置快递号
     *
     * @param express_no 快递号
     */
    public void setExpress_no(String express_no) {
        this.express_no = express_no;
    }

    /**
     * 获取快递项目号
     *
     * @return mail_item_no - 快递项目号
     */
    public String getMail_item_no() {
        return mail_item_no;
    }

    /**
     * 设置快递项目号
     *
     * @param mail_item_no 快递项目号
     */
    public void setMail_item_no(String mail_item_no) {
        this.mail_item_no = mail_item_no;
    }

    /**
     * 获取快递公司
     *
     * @return shipped_per - 快递公司
     */
    public String getShipped_per() {
        return shipped_per;
    }

    /**
     * 设置快递公司
     *
     * @param shipped_per 快递公司
     */
    public void setShipped_per(String shipped_per) {
        this.shipped_per = shipped_per;
    }

    /**
     * 获取付款条款
     *
     * @return terms_of_payment - 付款条款
     */
    public String getTerms_of_payment() {
        return terms_of_payment;
    }

    /**
     * 设置付款条款
     *
     * @param terms_of_payment 付款条款
     */
    public void setTerms_of_payment(String terms_of_payment) {
        this.terms_of_payment = terms_of_payment;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取总数量
     *
     * @return total_quantity - 总数量
     */
    public Integer getTotal_quantity() {
        return total_quantity;
    }

    /**
     * 设置总数量
     *
     * @param total_quantity 总数量
     */
    public void setTotal_quantity(Integer total_quantity) {
        this.total_quantity = total_quantity;
    }

    /**
     * 获取总金额
     *
     * @return total_amount - 总金额
     */
    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    /**
     * 设置总金额
     *
     * @param total_amount 总金额
     */
    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }
}