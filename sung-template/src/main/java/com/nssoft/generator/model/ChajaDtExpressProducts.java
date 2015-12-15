package com.nssoft.generator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_EXPRESS_PRODUCTS")
public class ChajaDtExpressProducts {
    /**
     * 记录号
     */
    @Id
    private String express_record_no;

    /**
     * 开发记录号
     */
    @Id
    private String develop_no;

    /**
     * 开发日期
     */
    @Id
    private Date reg_date;

    /**
     * 单价
     */
    private BigDecimal unit_price;

    /**
     * 总价
     */
    private BigDecimal total_amount;

    /**
     * 数量
     */
    private Integer quantity;

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
     * 获取开发记录号
     *
     * @return develop_no - 开发记录号
     */
    public String getDevelop_no() {
        return develop_no;
    }

    /**
     * 设置开发记录号
     *
     * @param develop_no 开发记录号
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
     * 获取单价
     *
     * @return unit_price - 单价
     */
    public BigDecimal getUnit_price() {
        return unit_price;
    }

    /**
     * 设置单价
     *
     * @param unit_price 单价
     */
    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    /**
     * 获取总价
     *
     * @return total_amount - 总价
     */
    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    /**
     * 设置总价
     *
     * @param total_amount 总价
     */
    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    /**
     * 获取数量
     *
     * @return quantity - 数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置数量
     *
     * @param quantity 数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}