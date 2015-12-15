package com.nssoft.generator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_NEWPRODUCTINFO")
public class ChajaDtNewproductinfo {
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
     * 是否下单
     */
    private String order_yn;

    /**
     * 下单款号
     */
    private String item_no_order;

    /**
     * 工厂(供应商)
     */
    private String supplier_id;

    /**
     * 客户(日本)
     */
    private String customer_id;

    /**
     * 货物类型
     */
    private String category;

    /**
     * 款号
     */
    private String item_no;

    /**
     * 品名
     */
    private String item_nm;

    /**
     * 担当
     */
    private String sign;

    /**
     * 样品交期
     */
    private Date delivery_date;

    /**
     * 材质
     */
    private String material;

    /**
     * 材质详情
     */
    private String material_detail;

    /**
     * 产品尺寸
     */
    private String product_size;

    /**
     * 印刷尺寸
     */
    private String print_size;

    /**
     * 单个包装1
     */
    private String pcs_packing1;

    /**
     * 单个包装2
     */
    private String pcs_packing2;

    /**
     * 单个包装3
     */
    private String pcs_packing3;

    /**
     * 内盒装1
     */
    private Integer inner_packing1;

    /**
     * 内盒装2
     */
    private String inner_packing2;

    /**
     * 内盒装3
     */
    private String inner_packing3;

    /**
     * 大箱包装1
     */
    private Integer ctn_packing1;

    /**
     * 大箱包装2
     */
    private String ctn_packing2;

    /**
     * PCS干燥剂
     */
    private String dry_pcs;

    /**
     * BOX干燥剂
     */
    private String dry_box;

    /**
     * CTN干燥剂
     */
    private String dry_ctn;

    /**
     * 样品费(国内)
     */
    private BigDecimal sample_price_rmb;

    /**
     * 样品费(国外)
     */
    private BigDecimal sample_price_usd;

    private Short sample_price_paycnt;

    /**
     * 样品费备注
     */
    private String sample_price_exp;

    /**
     * 最小起订数量
     */
    private String moq;

    /**
     * 最小起订金额
     */
    private String moa;

    /**
     * 国内单价(RMB)
     */
    private String unitprice_cn_rmb;

    /**
     * 国内单价(USD)
     */
    private String unitprice_cn_usd;

    /**
     * 国内单价单位
     */
    private String unitprice_cn_unit;

    /**
     * 国内单价备注
     */
    private String unitprice_cn_exp;

    /**
     * 国外单价1
     */
    private String unitprice_fob1;

    /**
     * 国外单价1单位
     */
    private String unitprice_fob1_unit;

    /**
     * 国外单价2
     */
    private String unitprice_fob2;

    /**
     * 国外单价2单位
     */
    private String unitprice_fob2_unit;

    /**
     * 国外单价备注
     */
    private String unitprice_fob_exp;

    /**
     * 中间确认日期
     */
    private Date mid_confirm_date;

    /**
     * 样品修改日期
     */
    private Date modify_date;

    /**
     * 修改备注
     */
    private String modify_exp;

    /**
     * 样品结果
     */
    private String sample_result;

    /**
     * 备注
     */
    private String exp;

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
     * 获取是否下单
     *
     * @return order_yn - 是否下单
     */
    public String getOrder_yn() {
        return order_yn;
    }

    /**
     * 设置是否下单
     *
     * @param order_yn 是否下单
     */
    public void setOrder_yn(String order_yn) {
        this.order_yn = order_yn;
    }

    /**
     * 获取下单款号
     *
     * @return item_no_order - 下单款号
     */
    public String getItem_no_order() {
        return item_no_order;
    }

    /**
     * 设置下单款号
     *
     * @param item_no_order 下单款号
     */
    public void setItem_no_order(String item_no_order) {
        this.item_no_order = item_no_order;
    }

    /**
     * 获取工厂(供应商)
     *
     * @return supplier_id - 工厂(供应商)
     */
    public String getSupplier_id() {
        return supplier_id;
    }

    /**
     * 设置工厂(供应商)
     *
     * @param supplier_id 工厂(供应商)
     */
    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    /**
     * 获取客户(日本)
     *
     * @return customer_id - 客户(日本)
     */
    public String getCustomer_id() {
        return customer_id;
    }

    /**
     * 设置客户(日本)
     *
     * @param customer_id 客户(日本)
     */
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * 获取货物类型
     *
     * @return category - 货物类型
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置货物类型
     *
     * @param category 货物类型
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取款号
     *
     * @return item_no - 款号
     */
    public String getItem_no() {
        return item_no;
    }

    /**
     * 设置款号
     *
     * @param item_no 款号
     */
    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }

    /**
     * 获取品名
     *
     * @return item_nm - 品名
     */
    public String getItem_nm() {
        return item_nm;
    }

    /**
     * 设置品名
     *
     * @param item_nm 品名
     */
    public void setItem_nm(String item_nm) {
        this.item_nm = item_nm;
    }

    /**
     * 获取担当
     *
     * @return sign - 担当
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置担当
     *
     * @param sign 担当
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取样品交期
     *
     * @return delivery_date - 样品交期
     */
    public Date getDelivery_date() {
        return delivery_date;
    }

    /**
     * 设置样品交期
     *
     * @param delivery_date 样品交期
     */
    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    /**
     * 获取材质
     *
     * @return material - 材质
     */
    public String getMaterial() {
        return material;
    }

    /**
     * 设置材质
     *
     * @param material 材质
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * 获取材质详情
     *
     * @return material_detail - 材质详情
     */
    public String getMaterial_detail() {
        return material_detail;
    }

    /**
     * 设置材质详情
     *
     * @param material_detail 材质详情
     */
    public void setMaterial_detail(String material_detail) {
        this.material_detail = material_detail;
    }

    /**
     * 获取产品尺寸
     *
     * @return product_size - 产品尺寸
     */
    public String getProduct_size() {
        return product_size;
    }

    /**
     * 设置产品尺寸
     *
     * @param product_size 产品尺寸
     */
    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    /**
     * 获取印刷尺寸
     *
     * @return print_size - 印刷尺寸
     */
    public String getPrint_size() {
        return print_size;
    }

    /**
     * 设置印刷尺寸
     *
     * @param print_size 印刷尺寸
     */
    public void setPrint_size(String print_size) {
        this.print_size = print_size;
    }

    /**
     * 获取单个包装1
     *
     * @return pcs_packing1 - 单个包装1
     */
    public String getPcs_packing1() {
        return pcs_packing1;
    }

    /**
     * 设置单个包装1
     *
     * @param pcs_packing1 单个包装1
     */
    public void setPcs_packing1(String pcs_packing1) {
        this.pcs_packing1 = pcs_packing1;
    }

    /**
     * 获取单个包装2
     *
     * @return pcs_packing2 - 单个包装2
     */
    public String getPcs_packing2() {
        return pcs_packing2;
    }

    /**
     * 设置单个包装2
     *
     * @param pcs_packing2 单个包装2
     */
    public void setPcs_packing2(String pcs_packing2) {
        this.pcs_packing2 = pcs_packing2;
    }

    /**
     * 获取单个包装3
     *
     * @return pcs_packing3 - 单个包装3
     */
    public String getPcs_packing3() {
        return pcs_packing3;
    }

    /**
     * 设置单个包装3
     *
     * @param pcs_packing3 单个包装3
     */
    public void setPcs_packing3(String pcs_packing3) {
        this.pcs_packing3 = pcs_packing3;
    }

    /**
     * 获取内盒装1
     *
     * @return inner_packing1 - 内盒装1
     */
    public Integer getInner_packing1() {
        return inner_packing1;
    }

    /**
     * 设置内盒装1
     *
     * @param inner_packing1 内盒装1
     */
    public void setInner_packing1(Integer inner_packing1) {
        this.inner_packing1 = inner_packing1;
    }

    /**
     * 获取内盒装2
     *
     * @return inner_packing2 - 内盒装2
     */
    public String getInner_packing2() {
        return inner_packing2;
    }

    /**
     * 设置内盒装2
     *
     * @param inner_packing2 内盒装2
     */
    public void setInner_packing2(String inner_packing2) {
        this.inner_packing2 = inner_packing2;
    }

    /**
     * 获取内盒装3
     *
     * @return inner_packing3 - 内盒装3
     */
    public String getInner_packing3() {
        return inner_packing3;
    }

    /**
     * 设置内盒装3
     *
     * @param inner_packing3 内盒装3
     */
    public void setInner_packing3(String inner_packing3) {
        this.inner_packing3 = inner_packing3;
    }

    /**
     * 获取大箱包装1
     *
     * @return ctn_packing1 - 大箱包装1
     */
    public Integer getCtn_packing1() {
        return ctn_packing1;
    }

    /**
     * 设置大箱包装1
     *
     * @param ctn_packing1 大箱包装1
     */
    public void setCtn_packing1(Integer ctn_packing1) {
        this.ctn_packing1 = ctn_packing1;
    }

    /**
     * 获取大箱包装2
     *
     * @return ctn_packing2 - 大箱包装2
     */
    public String getCtn_packing2() {
        return ctn_packing2;
    }

    /**
     * 设置大箱包装2
     *
     * @param ctn_packing2 大箱包装2
     */
    public void setCtn_packing2(String ctn_packing2) {
        this.ctn_packing2 = ctn_packing2;
    }

    /**
     * 获取PCS干燥剂
     *
     * @return dry_pcs - PCS干燥剂
     */
    public String getDry_pcs() {
        return dry_pcs;
    }

    /**
     * 设置PCS干燥剂
     *
     * @param dry_pcs PCS干燥剂
     */
    public void setDry_pcs(String dry_pcs) {
        this.dry_pcs = dry_pcs;
    }

    /**
     * 获取BOX干燥剂
     *
     * @return dry_box - BOX干燥剂
     */
    public String getDry_box() {
        return dry_box;
    }

    /**
     * 设置BOX干燥剂
     *
     * @param dry_box BOX干燥剂
     */
    public void setDry_box(String dry_box) {
        this.dry_box = dry_box;
    }

    /**
     * 获取CTN干燥剂
     *
     * @return dry_ctn - CTN干燥剂
     */
    public String getDry_ctn() {
        return dry_ctn;
    }

    /**
     * 设置CTN干燥剂
     *
     * @param dry_ctn CTN干燥剂
     */
    public void setDry_ctn(String dry_ctn) {
        this.dry_ctn = dry_ctn;
    }

    /**
     * 获取样品费(国内)
     *
     * @return sample_price_rmb - 样品费(国内)
     */
    public BigDecimal getSample_price_rmb() {
        return sample_price_rmb;
    }

    /**
     * 设置样品费(国内)
     *
     * @param sample_price_rmb 样品费(国内)
     */
    public void setSample_price_rmb(BigDecimal sample_price_rmb) {
        this.sample_price_rmb = sample_price_rmb;
    }

    /**
     * 获取样品费(国外)
     *
     * @return sample_price_usd - 样品费(国外)
     */
    public BigDecimal getSample_price_usd() {
        return sample_price_usd;
    }

    /**
     * 设置样品费(国外)
     *
     * @param sample_price_usd 样品费(国外)
     */
    public void setSample_price_usd(BigDecimal sample_price_usd) {
        this.sample_price_usd = sample_price_usd;
    }

    /**
     * @return sample_price_paycnt
     */
    public Short getSample_price_paycnt() {
        return sample_price_paycnt;
    }

    /**
     * @param sample_price_paycnt
     */
    public void setSample_price_paycnt(Short sample_price_paycnt) {
        this.sample_price_paycnt = sample_price_paycnt;
    }

    /**
     * 获取样品费备注
     *
     * @return sample_price_exp - 样品费备注
     */
    public String getSample_price_exp() {
        return sample_price_exp;
    }

    /**
     * 设置样品费备注
     *
     * @param sample_price_exp 样品费备注
     */
    public void setSample_price_exp(String sample_price_exp) {
        this.sample_price_exp = sample_price_exp;
    }

    /**
     * 获取最小起订数量
     *
     * @return moq - 最小起订数量
     */
    public String getMoq() {
        return moq;
    }

    /**
     * 设置最小起订数量
     *
     * @param moq 最小起订数量
     */
    public void setMoq(String moq) {
        this.moq = moq;
    }

    /**
     * 获取最小起订金额
     *
     * @return moa - 最小起订金额
     */
    public String getMoa() {
        return moa;
    }

    /**
     * 设置最小起订金额
     *
     * @param moa 最小起订金额
     */
    public void setMoa(String moa) {
        this.moa = moa;
    }

    /**
     * 获取国内单价(RMB)
     *
     * @return unitprice_cn_rmb - 国内单价(RMB)
     */
    public String getUnitprice_cn_rmb() {
        return unitprice_cn_rmb;
    }

    /**
     * 设置国内单价(RMB)
     *
     * @param unitprice_cn_rmb 国内单价(RMB)
     */
    public void setUnitprice_cn_rmb(String unitprice_cn_rmb) {
        this.unitprice_cn_rmb = unitprice_cn_rmb;
    }

    /**
     * 获取国内单价(USD)
     *
     * @return unitprice_cn_usd - 国内单价(USD)
     */
    public String getUnitprice_cn_usd() {
        return unitprice_cn_usd;
    }

    /**
     * 设置国内单价(USD)
     *
     * @param unitprice_cn_usd 国内单价(USD)
     */
    public void setUnitprice_cn_usd(String unitprice_cn_usd) {
        this.unitprice_cn_usd = unitprice_cn_usd;
    }

    /**
     * 获取国内单价单位
     *
     * @return unitprice_cn_unit - 国内单价单位
     */
    public String getUnitprice_cn_unit() {
        return unitprice_cn_unit;
    }

    /**
     * 设置国内单价单位
     *
     * @param unitprice_cn_unit 国内单价单位
     */
    public void setUnitprice_cn_unit(String unitprice_cn_unit) {
        this.unitprice_cn_unit = unitprice_cn_unit;
    }

    /**
     * 获取国内单价备注
     *
     * @return unitprice_cn_exp - 国内单价备注
     */
    public String getUnitprice_cn_exp() {
        return unitprice_cn_exp;
    }

    /**
     * 设置国内单价备注
     *
     * @param unitprice_cn_exp 国内单价备注
     */
    public void setUnitprice_cn_exp(String unitprice_cn_exp) {
        this.unitprice_cn_exp = unitprice_cn_exp;
    }

    /**
     * 获取国外单价1
     *
     * @return unitprice_fob1 - 国外单价1
     */
    public String getUnitprice_fob1() {
        return unitprice_fob1;
    }

    /**
     * 设置国外单价1
     *
     * @param unitprice_fob1 国外单价1
     */
    public void setUnitprice_fob1(String unitprice_fob1) {
        this.unitprice_fob1 = unitprice_fob1;
    }

    /**
     * 获取国外单价1单位
     *
     * @return unitprice_fob1_unit - 国外单价1单位
     */
    public String getUnitprice_fob1_unit() {
        return unitprice_fob1_unit;
    }

    /**
     * 设置国外单价1单位
     *
     * @param unitprice_fob1_unit 国外单价1单位
     */
    public void setUnitprice_fob1_unit(String unitprice_fob1_unit) {
        this.unitprice_fob1_unit = unitprice_fob1_unit;
    }

    /**
     * 获取国外单价2
     *
     * @return unitprice_fob2 - 国外单价2
     */
    public String getUnitprice_fob2() {
        return unitprice_fob2;
    }

    /**
     * 设置国外单价2
     *
     * @param unitprice_fob2 国外单价2
     */
    public void setUnitprice_fob2(String unitprice_fob2) {
        this.unitprice_fob2 = unitprice_fob2;
    }

    /**
     * 获取国外单价2单位
     *
     * @return unitprice_fob2_unit - 国外单价2单位
     */
    public String getUnitprice_fob2_unit() {
        return unitprice_fob2_unit;
    }

    /**
     * 设置国外单价2单位
     *
     * @param unitprice_fob2_unit 国外单价2单位
     */
    public void setUnitprice_fob2_unit(String unitprice_fob2_unit) {
        this.unitprice_fob2_unit = unitprice_fob2_unit;
    }

    /**
     * 获取国外单价备注
     *
     * @return unitprice_fob_exp - 国外单价备注
     */
    public String getUnitprice_fob_exp() {
        return unitprice_fob_exp;
    }

    /**
     * 设置国外单价备注
     *
     * @param unitprice_fob_exp 国外单价备注
     */
    public void setUnitprice_fob_exp(String unitprice_fob_exp) {
        this.unitprice_fob_exp = unitprice_fob_exp;
    }

    /**
     * 获取中间确认日期
     *
     * @return mid_confirm_date - 中间确认日期
     */
    public Date getMid_confirm_date() {
        return mid_confirm_date;
    }

    /**
     * 设置中间确认日期
     *
     * @param mid_confirm_date 中间确认日期
     */
    public void setMid_confirm_date(Date mid_confirm_date) {
        this.mid_confirm_date = mid_confirm_date;
    }

    /**
     * 获取样品修改日期
     *
     * @return modify_date - 样品修改日期
     */
    public Date getModify_date() {
        return modify_date;
    }

    /**
     * 设置样品修改日期
     *
     * @param modify_date 样品修改日期
     */
    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    /**
     * 获取修改备注
     *
     * @return modify_exp - 修改备注
     */
    public String getModify_exp() {
        return modify_exp;
    }

    /**
     * 设置修改备注
     *
     * @param modify_exp 修改备注
     */
    public void setModify_exp(String modify_exp) {
        this.modify_exp = modify_exp;
    }

    /**
     * 获取样品结果
     *
     * @return sample_result - 样品结果
     */
    public String getSample_result() {
        return sample_result;
    }

    /**
     * 设置样品结果
     *
     * @param sample_result 样品结果
     */
    public void setSample_result(String sample_result) {
        this.sample_result = sample_result;
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