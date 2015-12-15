package com.nssoft.generator.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_PRODUCTCOLORDETAIL")
public class ChajaDtProductcolordetail {
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
     * 颜色
     */
    @Id
    private String color;

    /**
     * 日本条形码
     */
    private String jan_code;

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
     * 获取颜色
     *
     * @return color - 颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置颜色
     *
     * @param color 颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取日本条形码
     *
     * @return jan_code - 日本条形码
     */
    public String getJan_code() {
        return jan_code;
    }

    /**
     * 设置日本条形码
     *
     * @param jan_code 日本条形码
     */
    public void setJan_code(String jan_code) {
        this.jan_code = jan_code;
    }
}