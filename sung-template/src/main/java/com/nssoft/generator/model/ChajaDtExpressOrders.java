package com.nssoft.generator.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "CHAJA_DT_EXPRESS_ORDERS")
public class ChajaDtExpressOrders {
    /**
     * 记录号
     */
    @Id
    private String express_record_no;

    /**
     * 订单号
     */
    @Id
    private String order_no;

    /**
     * 样品类型
     */
    @Id
    private String sample_type;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 单价
     */
    private BigDecimal unit_price;

    /**
     * 总价
     */
    private BigDecimal total_amount;

    private String print_yn;

    /**
     * 备注
     */
    private String comments;

    private BigDecimal inner_length;

    private BigDecimal inner_width;

    private BigDecimal inner_height;

    private String inner_size_unit;

    private BigDecimal inner_gw;

    private BigDecimal inner_nw;

    private BigDecimal unit_weight;

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
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrder_no() {
        return order_no;
    }

    /**
     * 设置订单号
     *
     * @param order_no 订单号
     */
    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    /**
     * 获取样品类型
     *
     * @return sample_type - 样品类型
     */
    public String getSample_type() {
        return sample_type;
    }

    /**
     * 设置样品类型
     *
     * @param sample_type 样品类型
     */
    public void setSample_type(String sample_type) {
        this.sample_type = sample_type;
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
     * @return print_yn
     */
    public String getPrint_yn() {
        return print_yn;
    }

    /**
     * @param print_yn
     */
    public void setPrint_yn(String print_yn) {
        this.print_yn = print_yn;
    }

    /**
     * 获取备注
     *
     * @return comments - 备注
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置备注
     *
     * @param comments 备注
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return inner_length
     */
    public BigDecimal getInner_length() {
        return inner_length;
    }

    /**
     * @param inner_length
     */
    public void setInner_length(BigDecimal inner_length) {
        this.inner_length = inner_length;
    }

    /**
     * @return inner_width
     */
    public BigDecimal getInner_width() {
        return inner_width;
    }

    /**
     * @param inner_width
     */
    public void setInner_width(BigDecimal inner_width) {
        this.inner_width = inner_width;
    }

    /**
     * @return inner_height
     */
    public BigDecimal getInner_height() {
        return inner_height;
    }

    /**
     * @param inner_height
     */
    public void setInner_height(BigDecimal inner_height) {
        this.inner_height = inner_height;
    }

    /**
     * @return inner_size_unit
     */
    public String getInner_size_unit() {
        return inner_size_unit;
    }

    /**
     * @param inner_size_unit
     */
    public void setInner_size_unit(String inner_size_unit) {
        this.inner_size_unit = inner_size_unit;
    }

    /**
     * @return inner_gw
     */
    public BigDecimal getInner_gw() {
        return inner_gw;
    }

    /**
     * @param inner_gw
     */
    public void setInner_gw(BigDecimal inner_gw) {
        this.inner_gw = inner_gw;
    }

    /**
     * @return inner_nw
     */
    public BigDecimal getInner_nw() {
        return inner_nw;
    }

    /**
     * @param inner_nw
     */
    public void setInner_nw(BigDecimal inner_nw) {
        this.inner_nw = inner_nw;
    }

    /**
     * @return unit_weight
     */
    public BigDecimal getUnit_weight() {
        return unit_weight;
    }

    /**
     * @param unit_weight
     */
    public void setUnit_weight(BigDecimal unit_weight) {
        this.unit_weight = unit_weight;
    }
}