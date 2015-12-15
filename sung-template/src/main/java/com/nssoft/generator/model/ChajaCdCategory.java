package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_CD_CATEGORY")
public class ChajaCdCategory {
    /**
     * 类型编码
     */
    @Id
    private String category_code;

    /**
     * 编码
     */
    private String code;

    /**
     * 中文名称
     */
    private String category_nm_cn;

    /**
     * 英文名称
     */
    private String category_nm_en;

    /**
     * 退税率
     */
    private Short taxrefund_rate;

    /**
     * 备注
     */
    private String exp;

    /**
     * 获取类型编码
     *
     * @return category_code - 类型编码
     */
    public String getCategory_code() {
        return category_code;
    }

    /**
     * 设置类型编码
     *
     * @param category_code 类型编码
     */
    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    /**
     * 获取编码
     *
     * @return code - 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编码
     *
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取中文名称
     *
     * @return category_nm_cn - 中文名称
     */
    public String getCategory_nm_cn() {
        return category_nm_cn;
    }

    /**
     * 设置中文名称
     *
     * @param category_nm_cn 中文名称
     */
    public void setCategory_nm_cn(String category_nm_cn) {
        this.category_nm_cn = category_nm_cn;
    }

    /**
     * 获取英文名称
     *
     * @return category_nm_en - 英文名称
     */
    public String getCategory_nm_en() {
        return category_nm_en;
    }

    /**
     * 设置英文名称
     *
     * @param category_nm_en 英文名称
     */
    public void setCategory_nm_en(String category_nm_en) {
        this.category_nm_en = category_nm_en;
    }

    /**
     * 获取退税率
     *
     * @return taxrefund_rate - 退税率
     */
    public Short getTaxrefund_rate() {
        return taxrefund_rate;
    }

    /**
     * 设置退税率
     *
     * @param taxrefund_rate 退税率
     */
    public void setTaxrefund_rate(Short taxrefund_rate) {
        this.taxrefund_rate = taxrefund_rate;
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