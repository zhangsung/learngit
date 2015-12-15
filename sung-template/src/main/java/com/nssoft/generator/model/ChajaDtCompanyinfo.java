package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_DT_COMPANYINFO")
public class ChajaDtCompanyinfo {
    /**
     * 公司ID
     */
    @Id
    private String company_id;

    /**
     * 公司类型
     */
    @Id
    private String company_type;

    /**
     * 中文名称
     */
    private String nm_cn;

    /**
     * 中文名简称
     */
    private String nm_cn_short;

    /**
     * 英文名称
     */
    private String nm_en;

    /**
     * 英文名简称
     */
    private String nm_en_short;

    /**
     * 中文地址
     */
    private String address_cn;

    /**
     * 中文地址简称
     */
    private String address_cn_short;

    /**
     * 英文地址简称
     */
    private String address_en_short;

    /**
     * 英文地址
     */
    private String address_en;

    /**
     * 收款行(中文)
     */
    private String bank_nm_cn;

    /**
     * 收款行(英文)
     */
    private String bank_nm_en;

    /**
     * 银行代码
     */
    private String bank_swift;

    /**
     * 收款行中文地址
     */
    private String bank_address_cn;

    /**
     * 收款行英文地址
     */
    private String bank_address_en;

    /**
     * 银行账户
     */
    private String account_no;

    /**
     * 税号
     */
    private String tax_no;

    /**
     * 负责人(中文)
     */
    private String charger_nm_cn;

    /**
     * 负责人(英文)
     */
    private String charger_nm_en;

    /**
     * 电话
     */
    private String tel;

    /**
     * 传真
     */
    private String fax;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 发票地址(中文)
     */
    private String invoice_address_cn;

    /**
     * 发票地址(英文)
     */
    private String invoice_address_en;

    /**
     * 备注
     */
    private String exp;

    /**
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public String getCompany_id() {
        return company_id;
    }

    /**
     * 设置公司ID
     *
     * @param company_id 公司ID
     */
    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    /**
     * 获取公司类型
     *
     * @return company_type - 公司类型
     */
    public String getCompany_type() {
        return company_type;
    }

    /**
     * 设置公司类型
     *
     * @param company_type 公司类型
     */
    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    /**
     * 获取中文名称
     *
     * @return nm_cn - 中文名称
     */
    public String getNm_cn() {
        return nm_cn;
    }

    /**
     * 设置中文名称
     *
     * @param nm_cn 中文名称
     */
    public void setNm_cn(String nm_cn) {
        this.nm_cn = nm_cn;
    }

    /**
     * 获取中文名简称
     *
     * @return nm_cn_short - 中文名简称
     */
    public String getNm_cn_short() {
        return nm_cn_short;
    }

    /**
     * 设置中文名简称
     *
     * @param nm_cn_short 中文名简称
     */
    public void setNm_cn_short(String nm_cn_short) {
        this.nm_cn_short = nm_cn_short;
    }

    /**
     * 获取英文名称
     *
     * @return nm_en - 英文名称
     */
    public String getNm_en() {
        return nm_en;
    }

    /**
     * 设置英文名称
     *
     * @param nm_en 英文名称
     */
    public void setNm_en(String nm_en) {
        this.nm_en = nm_en;
    }

    /**
     * 获取英文名简称
     *
     * @return nm_en_short - 英文名简称
     */
    public String getNm_en_short() {
        return nm_en_short;
    }

    /**
     * 设置英文名简称
     *
     * @param nm_en_short 英文名简称
     */
    public void setNm_en_short(String nm_en_short) {
        this.nm_en_short = nm_en_short;
    }

    /**
     * 获取中文地址
     *
     * @return address_cn - 中文地址
     */
    public String getAddress_cn() {
        return address_cn;
    }

    /**
     * 设置中文地址
     *
     * @param address_cn 中文地址
     */
    public void setAddress_cn(String address_cn) {
        this.address_cn = address_cn;
    }

    /**
     * 获取中文地址简称
     *
     * @return address_cn_short - 中文地址简称
     */
    public String getAddress_cn_short() {
        return address_cn_short;
    }

    /**
     * 设置中文地址简称
     *
     * @param address_cn_short 中文地址简称
     */
    public void setAddress_cn_short(String address_cn_short) {
        this.address_cn_short = address_cn_short;
    }

    /**
     * 获取英文地址简称
     *
     * @return address_en_short - 英文地址简称
     */
    public String getAddress_en_short() {
        return address_en_short;
    }

    /**
     * 设置英文地址简称
     *
     * @param address_en_short 英文地址简称
     */
    public void setAddress_en_short(String address_en_short) {
        this.address_en_short = address_en_short;
    }

    /**
     * 获取英文地址
     *
     * @return address_en - 英文地址
     */
    public String getAddress_en() {
        return address_en;
    }

    /**
     * 设置英文地址
     *
     * @param address_en 英文地址
     */
    public void setAddress_en(String address_en) {
        this.address_en = address_en;
    }

    /**
     * 获取收款行(中文)
     *
     * @return bank_nm_cn - 收款行(中文)
     */
    public String getBank_nm_cn() {
        return bank_nm_cn;
    }

    /**
     * 设置收款行(中文)
     *
     * @param bank_nm_cn 收款行(中文)
     */
    public void setBank_nm_cn(String bank_nm_cn) {
        this.bank_nm_cn = bank_nm_cn;
    }

    /**
     * 获取收款行(英文)
     *
     * @return bank_nm_en - 收款行(英文)
     */
    public String getBank_nm_en() {
        return bank_nm_en;
    }

    /**
     * 设置收款行(英文)
     *
     * @param bank_nm_en 收款行(英文)
     */
    public void setBank_nm_en(String bank_nm_en) {
        this.bank_nm_en = bank_nm_en;
    }

    /**
     * 获取银行代码
     *
     * @return bank_swift - 银行代码
     */
    public String getBank_swift() {
        return bank_swift;
    }

    /**
     * 设置银行代码
     *
     * @param bank_swift 银行代码
     */
    public void setBank_swift(String bank_swift) {
        this.bank_swift = bank_swift;
    }

    /**
     * 获取收款行中文地址
     *
     * @return bank_address_cn - 收款行中文地址
     */
    public String getBank_address_cn() {
        return bank_address_cn;
    }

    /**
     * 设置收款行中文地址
     *
     * @param bank_address_cn 收款行中文地址
     */
    public void setBank_address_cn(String bank_address_cn) {
        this.bank_address_cn = bank_address_cn;
    }

    /**
     * 获取收款行英文地址
     *
     * @return bank_address_en - 收款行英文地址
     */
    public String getBank_address_en() {
        return bank_address_en;
    }

    /**
     * 设置收款行英文地址
     *
     * @param bank_address_en 收款行英文地址
     */
    public void setBank_address_en(String bank_address_en) {
        this.bank_address_en = bank_address_en;
    }

    /**
     * 获取银行账户
     *
     * @return account_no - 银行账户
     */
    public String getAccount_no() {
        return account_no;
    }

    /**
     * 设置银行账户
     *
     * @param account_no 银行账户
     */
    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    /**
     * 获取税号
     *
     * @return tax_no - 税号
     */
    public String getTax_no() {
        return tax_no;
    }

    /**
     * 设置税号
     *
     * @param tax_no 税号
     */
    public void setTax_no(String tax_no) {
        this.tax_no = tax_no;
    }

    /**
     * 获取负责人(中文)
     *
     * @return charger_nm_cn - 负责人(中文)
     */
    public String getCharger_nm_cn() {
        return charger_nm_cn;
    }

    /**
     * 设置负责人(中文)
     *
     * @param charger_nm_cn 负责人(中文)
     */
    public void setCharger_nm_cn(String charger_nm_cn) {
        this.charger_nm_cn = charger_nm_cn;
    }

    /**
     * 获取负责人(英文)
     *
     * @return charger_nm_en - 负责人(英文)
     */
    public String getCharger_nm_en() {
        return charger_nm_en;
    }

    /**
     * 设置负责人(英文)
     *
     * @param charger_nm_en 负责人(英文)
     */
    public void setCharger_nm_en(String charger_nm_en) {
        this.charger_nm_en = charger_nm_en;
    }

    /**
     * 获取电话
     *
     * @return tel - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取传真
     *
     * @return fax - 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真
     *
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取邮编
     *
     * @return zipcode - 邮编
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * 设置邮编
     *
     * @param zipcode 邮编
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * 获取发票地址(中文)
     *
     * @return invoice_address_cn - 发票地址(中文)
     */
    public String getInvoice_address_cn() {
        return invoice_address_cn;
    }

    /**
     * 设置发票地址(中文)
     *
     * @param invoice_address_cn 发票地址(中文)
     */
    public void setInvoice_address_cn(String invoice_address_cn) {
        this.invoice_address_cn = invoice_address_cn;
    }

    /**
     * 获取发票地址(英文)
     *
     * @return invoice_address_en - 发票地址(英文)
     */
    public String getInvoice_address_en() {
        return invoice_address_en;
    }

    /**
     * 设置发票地址(英文)
     *
     * @param invoice_address_en 发票地址(英文)
     */
    public void setInvoice_address_en(String invoice_address_en) {
        this.invoice_address_en = invoice_address_en;
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