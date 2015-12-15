package com.nssoft.generator.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_TEST_BUGSTAT")
public class ChajaTestBugstat {
    @Id
    private String id;

    /**
     * 提交日期
     */
    private Date reg_ts;

    /**
     * URL
     */
    private String url;

    /**
     * 服务器
     */
    private String domain;

    /**
     * 浏览器信息
     */
    private String navigator;

    /**
     * Bug详情
     */
    private String content;

    /**
     * 提交人
     */
    private String submit_nm;

    /**
     * 是否解决
     */
    private String solve_yn;

    /**
     * 是否忽略
     */
    private String ignore_yn;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取提交日期
     *
     * @return reg_ts - 提交日期
     */
    public Date getReg_ts() {
        return reg_ts;
    }

    /**
     * 设置提交日期
     *
     * @param reg_ts 提交日期
     */
    public void setReg_ts(Date reg_ts) {
        this.reg_ts = reg_ts;
    }

    /**
     * 获取URL
     *
     * @return url - URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置URL
     *
     * @param url URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取服务器
     *
     * @return domain - 服务器
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 设置服务器
     *
     * @param domain 服务器
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * 获取浏览器信息
     *
     * @return navigator - 浏览器信息
     */
    public String getNavigator() {
        return navigator;
    }

    /**
     * 设置浏览器信息
     *
     * @param navigator 浏览器信息
     */
    public void setNavigator(String navigator) {
        this.navigator = navigator;
    }

    /**
     * 获取Bug详情
     *
     * @return content - Bug详情
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置Bug详情
     *
     * @param content Bug详情
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取提交人
     *
     * @return submit_nm - 提交人
     */
    public String getSubmit_nm() {
        return submit_nm;
    }

    /**
     * 设置提交人
     *
     * @param submit_nm 提交人
     */
    public void setSubmit_nm(String submit_nm) {
        this.submit_nm = submit_nm;
    }

    /**
     * 获取是否解决
     *
     * @return solve_yn - 是否解决
     */
    public String getSolve_yn() {
        return solve_yn;
    }

    /**
     * 设置是否解决
     *
     * @param solve_yn 是否解决
     */
    public void setSolve_yn(String solve_yn) {
        this.solve_yn = solve_yn;
    }

    /**
     * 获取是否忽略
     *
     * @return ignore_yn - 是否忽略
     */
    public String getIgnore_yn() {
        return ignore_yn;
    }

    /**
     * 设置是否忽略
     *
     * @param ignore_yn 是否忽略
     */
    public void setIgnore_yn(String ignore_yn) {
        this.ignore_yn = ignore_yn;
    }
}