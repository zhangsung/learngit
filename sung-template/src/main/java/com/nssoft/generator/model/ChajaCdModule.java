package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_CD_MODULE")
public class ChajaCdModule {
    /**
     * 模块编号
     */
    @Id
    private String module_cd;

    /**
     * 模块名称
     */
    private String module_nm;

    /**
     * 备注
     */
    private String exp;

    /**
     * 获取模块编号
     *
     * @return module_cd - 模块编号
     */
    public String getModule_cd() {
        return module_cd;
    }

    /**
     * 设置模块编号
     *
     * @param module_cd 模块编号
     */
    public void setModule_cd(String module_cd) {
        this.module_cd = module_cd;
    }

    /**
     * 获取模块名称
     *
     * @return module_nm - 模块名称
     */
    public String getModule_nm() {
        return module_nm;
    }

    /**
     * 设置模块名称
     *
     * @param module_nm 模块名称
     */
    public void setModule_nm(String module_nm) {
        this.module_nm = module_nm;
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