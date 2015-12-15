package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_DT_FILE")
public class ChajaDtFile {
    /**
     * 文件编号
     */
    @Id
    private String file_id;

    /**
     * 模块编号
     */
    @Id
    private String module_cd;

    /**
     * 标识号码
     */
    private String module_no;

    /**
     * 文件名
     */
    private String file_nm;

    /**
     * 文件路径
     */
    private String file_path;

    /**
     * 文件扩展名
     */
    private String file_extension;

    /**
     * 文件内容类型
     */
    private String file_content_type;

    /**
     * 是否使用
     */
    private String used_yn;

    /**
     * 上传日期
     */
    private Long upload_ts;

    /**
     * 获取文件编号
     *
     * @return file_id - 文件编号
     */
    public String getFile_id() {
        return file_id;
    }

    /**
     * 设置文件编号
     *
     * @param file_id 文件编号
     */
    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

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
     * 获取标识号码
     *
     * @return module_no - 标识号码
     */
    public String getModule_no() {
        return module_no;
    }

    /**
     * 设置标识号码
     *
     * @param module_no 标识号码
     */
    public void setModule_no(String module_no) {
        this.module_no = module_no;
    }

    /**
     * 获取文件名
     *
     * @return file_nm - 文件名
     */
    public String getFile_nm() {
        return file_nm;
    }

    /**
     * 设置文件名
     *
     * @param file_nm 文件名
     */
    public void setFile_nm(String file_nm) {
        this.file_nm = file_nm;
    }

    /**
     * 获取文件路径
     *
     * @return file_path - 文件路径
     */
    public String getFile_path() {
        return file_path;
    }

    /**
     * 设置文件路径
     *
     * @param file_path 文件路径
     */
    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    /**
     * 获取文件扩展名
     *
     * @return file_extension - 文件扩展名
     */
    public String getFile_extension() {
        return file_extension;
    }

    /**
     * 设置文件扩展名
     *
     * @param file_extension 文件扩展名
     */
    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }

    /**
     * 获取文件内容类型
     *
     * @return file_content_type - 文件内容类型
     */
    public String getFile_content_type() {
        return file_content_type;
    }

    /**
     * 设置文件内容类型
     *
     * @param file_content_type 文件内容类型
     */
    public void setFile_content_type(String file_content_type) {
        this.file_content_type = file_content_type;
    }

    /**
     * 获取是否使用
     *
     * @return used_yn - 是否使用
     */
    public String getUsed_yn() {
        return used_yn;
    }

    /**
     * 设置是否使用
     *
     * @param used_yn 是否使用
     */
    public void setUsed_yn(String used_yn) {
        this.used_yn = used_yn;
    }

    /**
     * 获取上传日期
     *
     * @return upload_ts - 上传日期
     */
    public Long getUpload_ts() {
        return upload_ts;
    }

    /**
     * 设置上传日期
     *
     * @param upload_ts 上传日期
     */
    public void setUpload_ts(Long upload_ts) {
        this.upload_ts = upload_ts;
    }
}