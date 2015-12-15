package com.nssoft.generator.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Table(name = "CHAJA_DT_MEMBERINFO")
public class ChajaDtMemberinfo {
    /**
     * 用户编号
     */
    @Id
    private String member_id;

    /**
     * 公司ID
     */
    private String company_id;

    /**
     * 公司类型
     */
    @NotNull
    private String company_type;

    /**
     * 用户名
     */
    @NotNull(message = "{test2.test1}")
    private String nm;

    /**
     * 密码
     */
    private String pw;

    /**
     * 性别
     */
    private String gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String tel;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 注册日期
     */
    private Date reg_ts;

    /**
     * 修改日期
     */
    private Date mod_ts;

    /**
     * 最后登录日期
     */
    private Date last_login_ts;

    /**
     * 最后登录IP
     */
    private String last_login_ip;

    /**
     * 是否登录受限
     */
    private String login_limit_yn;

    /**
     * 密码错误次数
     */
    private Short pw_fail_cnt;

    /**
     * 是否激活
     */
    private String active_yn;

    /**
     * 会员等级
     */
    private String member_grade;

    private String identify_code;

    /**
     * 获取用户编号
     *
     * @return member_id - 用户编号
     */
    public String getMember_id() {
        return member_id;
    }

    /**
     * 设置用户编号
     *
     * @param member_id 用户编号
     */
    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

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
     * 获取用户名
     *
     * @return nm - 用户名
     */
    public String getNm() {
        return nm;
    }

    /**
     * 设置用户名
     *
     * @param nm 用户名
     */
    public void setNm(String nm) {
        this.nm = nm;
    }

    /**
     * 获取密码
     *
     * @return pw - 密码
     */
    public String getPw() {
        return pw;
    }

    /**
     * 设置密码
     *
     * @param pw 密码
     */
    public void setPw(String pw) {
        this.pw = pw;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取注册日期
     *
     * @return reg_ts - 注册日期
     */
    public Date getReg_ts() {
        return reg_ts;
    }

    /**
     * 设置注册日期
     *
     * @param reg_ts 注册日期
     */
    public void setReg_ts(Date reg_ts) {
        this.reg_ts = reg_ts;
    }

    /**
     * 获取修改日期
     *
     * @return mod_ts - 修改日期
     */
    public Date getMod_ts() {
        return mod_ts;
    }

    /**
     * 设置修改日期
     *
     * @param mod_ts 修改日期
     */
    public void setMod_ts(Date mod_ts) {
        this.mod_ts = mod_ts;
    }

    /**
     * 获取最后登录日期
     *
     * @return last_login_ts - 最后登录日期
     */
    public Date getLast_login_ts() {
        return last_login_ts;
    }

    /**
     * 设置最后登录日期
     *
     * @param last_login_ts 最后登录日期
     */
    public void setLast_login_ts(Date last_login_ts) {
        this.last_login_ts = last_login_ts;
    }

    /**
     * 获取最后登录IP
     *
     * @return last_login_ip - 最后登录IP
     */
    public String getLast_login_ip() {
        return last_login_ip;
    }

    /**
     * 设置最后登录IP
     *
     * @param last_login_ip 最后登录IP
     */
    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    /**
     * 获取是否登录受限
     *
     * @return login_limit_yn - 是否登录受限
     */
    public String getLogin_limit_yn() {
        return login_limit_yn;
    }

    /**
     * 设置是否登录受限
     *
     * @param login_limit_yn 是否登录受限
     */
    public void setLogin_limit_yn(String login_limit_yn) {
        this.login_limit_yn = login_limit_yn;
    }

    /**
     * 获取密码错误次数
     *
     * @return pw_fail_cnt - 密码错误次数
     */
    public Short getPw_fail_cnt() {
        return pw_fail_cnt;
    }

    /**
     * 设置密码错误次数
     *
     * @param pw_fail_cnt 密码错误次数
     */
    public void setPw_fail_cnt(Short pw_fail_cnt) {
        this.pw_fail_cnt = pw_fail_cnt;
    }

    /**
     * 获取是否激活
     *
     * @return active_yn - 是否激活
     */
    public String getActive_yn() {
        return active_yn;
    }

    /**
     * 设置是否激活
     *
     * @param active_yn 是否激活
     */
    public void setActive_yn(String active_yn) {
        this.active_yn = active_yn;
    }

    /**
     * 获取会员等级
     *
     * @return member_grade - 会员等级
     */
    public String getMember_grade() {
        return member_grade;
    }

    /**
     * 设置会员等级
     *
     * @param member_grade 会员等级
     */
    public void setMember_grade(String member_grade) {
        this.member_grade = member_grade;
    }

    /**
     * @return identify_code
     */
    public String getIdentify_code() {
        return identify_code;
    }

    /**
     * @param identify_code
     */
    public void setIdentify_code(String identify_code) {
        this.identify_code = identify_code;
    }

	@Override
	public String toString() {
		return "ChajaDtMemberinfo [company_id=" + company_id
				+ ", company_type=" + company_type + ", nm=" + nm + ", pw="
				+ pw + ", gender=" + gender + ", email=" + email + ", tel="
				+ tel + ", birthday=" + birthday + ", reg_ts=" + reg_ts
				+ ", mod_ts=" + mod_ts + ", last_login_ts=" + last_login_ts
				+ ", last_login_ip=" + last_login_ip + ", login_limit_yn="
				+ login_limit_yn + ", pw_fail_cnt=" + pw_fail_cnt
				+ ", active_yn=" + active_yn + ", member_grade=" + member_grade
				+ ", identify_code=" + identify_code + "]";
	}
    
}