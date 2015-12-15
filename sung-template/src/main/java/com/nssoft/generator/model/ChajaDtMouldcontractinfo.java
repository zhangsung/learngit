package com.nssoft.generator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_MOULDCONTRACTINFO")
public class ChajaDtMouldcontractinfo {
    /**
     * 合同号
     */
    @Id
    private String contract_no;

    /**
     * 万青类型
     */
    private String chaja_type;

    /**
     * 客户信息
     */
    private String customer_id;

    /**
     * 签订日期
     */
    private Date sign_date;

    private String factory_id;

    /**
     * 退还金额条件
     */
    private BigDecimal condition_price;

    /**
     * 退还件数条件
     */
    private Integer condition_pcs;

    /**
     * 模具费用
     */
    private BigDecimal mould_price;

    /**
     * 是否支付
     */
    private String pay_yn;

    /**
     * 满足退还条件
     */
    private String condition_yn;

    /**
     * 是否退还
     */
    private String return_yn;

    /**
     * 备注
     */
    private String exp;

    /**
     * 获取合同号
     *
     * @return contract_no - 合同号
     */
    public String getContract_no() {
        return contract_no;
    }

    /**
     * 设置合同号
     *
     * @param contract_no 合同号
     */
    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
    }

    /**
     * 获取万青类型
     *
     * @return chaja_type - 万青类型
     */
    public String getChaja_type() {
        return chaja_type;
    }

    /**
     * 设置万青类型
     *
     * @param chaja_type 万青类型
     */
    public void setChaja_type(String chaja_type) {
        this.chaja_type = chaja_type;
    }

    /**
     * 获取客户信息
     *
     * @return customer_id - 客户信息
     */
    public String getCustomer_id() {
        return customer_id;
    }

    /**
     * 设置客户信息
     *
     * @param customer_id 客户信息
     */
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * 获取签订日期
     *
     * @return sign_date - 签订日期
     */
    public Date getSign_date() {
        return sign_date;
    }

    /**
     * 设置签订日期
     *
     * @param sign_date 签订日期
     */
    public void setSign_date(Date sign_date) {
        this.sign_date = sign_date;
    }

    /**
     * @return factory_id
     */
    public String getFactory_id() {
        return factory_id;
    }

    /**
     * @param factory_id
     */
    public void setFactory_id(String factory_id) {
        this.factory_id = factory_id;
    }

    /**
     * 获取退还金额条件
     *
     * @return condition_price - 退还金额条件
     */
    public BigDecimal getCondition_price() {
        return condition_price;
    }

    /**
     * 设置退还金额条件
     *
     * @param condition_price 退还金额条件
     */
    public void setCondition_price(BigDecimal condition_price) {
        this.condition_price = condition_price;
    }

    /**
     * 获取退还件数条件
     *
     * @return condition_pcs - 退还件数条件
     */
    public Integer getCondition_pcs() {
        return condition_pcs;
    }

    /**
     * 设置退还件数条件
     *
     * @param condition_pcs 退还件数条件
     */
    public void setCondition_pcs(Integer condition_pcs) {
        this.condition_pcs = condition_pcs;
    }

    /**
     * 获取模具费用
     *
     * @return mould_price - 模具费用
     */
    public BigDecimal getMould_price() {
        return mould_price;
    }

    /**
     * 设置模具费用
     *
     * @param mould_price 模具费用
     */
    public void setMould_price(BigDecimal mould_price) {
        this.mould_price = mould_price;
    }

    /**
     * 获取是否支付
     *
     * @return pay_yn - 是否支付
     */
    public String getPay_yn() {
        return pay_yn;
    }

    /**
     * 设置是否支付
     *
     * @param pay_yn 是否支付
     */
    public void setPay_yn(String pay_yn) {
        this.pay_yn = pay_yn;
    }

    /**
     * 获取满足退还条件
     *
     * @return condition_yn - 满足退还条件
     */
    public String getCondition_yn() {
        return condition_yn;
    }

    /**
     * 设置满足退还条件
     *
     * @param condition_yn 满足退还条件
     */
    public void setCondition_yn(String condition_yn) {
        this.condition_yn = condition_yn;
    }

    /**
     * 获取是否退还
     *
     * @return return_yn - 是否退还
     */
    public String getReturn_yn() {
        return return_yn;
    }

    /**
     * 设置是否退还
     *
     * @param return_yn 是否退还
     */
    public void setReturn_yn(String return_yn) {
        this.return_yn = return_yn;
    }

    /**
     * 获取备注
     *
     * @return exp - 备注
     */
    public String getExp() {
        return exp;
    }

    /**
     * 设置备注
     *
     * @param exp 备注
     */
    public void setExp(String exp) {
        this.exp = exp;
    }
}