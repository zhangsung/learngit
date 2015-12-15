package com.nssoft.generator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_ORDERINFO")
public class ChajaDtOrderinfo {
    /**
     * 订单编号
     */
    @Id
    private String order_no;

    /**
     * 订单日期
     */
    private Date order_date;

    /**
     * 客户信息
     */
    private String customer_id;

    /**
     * 供应商编号
     */
    private String supplier_id;

    /**
     * 产品编号
     */
    private String item_no;

    /**
     * 原款号
     */
    private String item_no_factory;

    /**
     * 品名
     */
    private String item_nm;

    /**
     * 材质
     */
    private String material;

    /**
     * 是否混装
     */
    private String ast_yn;

    private BigDecimal handling_fee;

    private String handling_fee_payyn;

    /**
     * 国内单价
     */
    private BigDecimal unitprice_cn;

    /**
     * 国内单价单位
     */
    private String unitprice_cn_unit;

    /**
     * 国内单价类型
     */
    private String unitprice_cn_type;

    /**
     * 国外价格
     */
    private BigDecimal unitprice_fob;

    /**
     * 单价单位
     */
    private String unitprice_unit;

    /**
     * 货物类型
     */
    private String category;

    /**
     * 订单箱数
     */
    private Integer order_ctns;

    /**
     * 箱数库存
     */
    private Integer order_ctns_stock;

    /**
     * 件数库存
     */
    private Integer order_pcs_stock;

    /**
     * 订单件数
     */
    private Integer order_pcs;

    /**
     * 总价
     */
    private BigDecimal total_amount;

    /**
     * 国内总价
     */
    private BigDecimal total_amount_cn;

    /**
     * 内盒确认样回签人
     */
    private String signback_nm;

    /**
     * 回签日
     */
    private Date signback_date;

    /**
     * 内盒长
     */
    private BigDecimal inner_length;

    /**
     * 内盒宽
     */
    private BigDecimal inner_width;

    /**
     * 内盒高
     */
    private BigDecimal inner_height;

    /**
     * 内盒尺寸单位
     */
    private String inner_size_unit;

    /**
     * 大箱长
     */
    private BigDecimal box_length;

    /**
     * 大箱宽
     */
    private BigDecimal box_width;

    /**
     * 大箱高
     */
    private BigDecimal box_height;

    /**
     * 大箱尺寸单位
     */
    private String box_size_unit;

    /**
     * 单个重量
     */
    private String unit_weight;

    /**
     * 大箱净重
     */
    private BigDecimal box_nw;

    /**
     * 大箱毛重
     */
    private BigDecimal box_gw;

    /**
     * 内盒净重
     */
    private BigDecimal inner_nw;

    /**
     * 内盒毛重
     */
    private BigDecimal inner_gw;

    /**
     * 产地
     */
    private String production;

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
     * 担当
     */
    private String sign;

    /**
     * 产前样交期
     */
    private Date pp_delivery_date;

    /**
     * 内盒样交期
     */
    private Date inner_delivery_date;

    /**
     * 品管样交期
     */
    private Date qc_delivery_date;

    /**
     * 大货样交期
     */
    private Date bulk_delivery_date;

    /**
     * 国内交期
     */
    private Date factory_delivery_date;

    /**
     * 交货日期
     */
    private Date delivery_date;

    /**
     * 备注
     */
    private String remark;

    /**
     * 注意事项
     */
    private String notice;

    /**
     * 获取订单编号
     *
     * @return order_no - 订单编号
     */
    public String getOrder_no() {
        return order_no;
    }

    /**
     * 设置订单编号
     *
     * @param order_no 订单编号
     */
    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    /**
     * 获取订单日期
     *
     * @return order_date - 订单日期
     */
    public Date getOrder_date() {
        return order_date;
    }

    /**
     * 设置订单日期
     *
     * @param order_date 订单日期
     */
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    /**
     * 获取客户信息
     *
     * @return customer_id - 客户信息
     */
    public String getCustomer_id() {
        return customer_id;
    }

    /**
     * 设置客户信息
     *
     * @param customer_id 客户信息
     */
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * 获取供应商编号
     *
     * @return supplier_id - 供应商编号
     */
    public String getSupplier_id() {
        return supplier_id;
    }

    /**
     * 设置供应商编号
     *
     * @param supplier_id 供应商编号
     */
    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    /**
     * 获取产品编号
     *
     * @return item_no - 产品编号
     */
    public String getItem_no() {
        return item_no;
    }

    /**
     * 设置产品编号
     *
     * @param item_no 产品编号
     */
    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }

    /**
     * 获取原款号
     *
     * @return item_no_factory - 原款号
     */
    public String getItem_no_factory() {
        return item_no_factory;
    }

    /**
     * 设置原款号
     *
     * @param item_no_factory 原款号
     */
    public void setItem_no_factory(String item_no_factory) {
        this.item_no_factory = item_no_factory;
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
     * 获取是否混装
     *
     * @return ast_yn - 是否混装
     */
    public String getAst_yn() {
        return ast_yn;
    }

    /**
     * 设置是否混装
     *
     * @param ast_yn 是否混装
     */
    public void setAst_yn(String ast_yn) {
        this.ast_yn = ast_yn;
    }

    /**
     * @return handling_fee
     */
    public BigDecimal getHandling_fee() {
        return handling_fee;
    }

    /**
     * @param handling_fee
     */
    public void setHandling_fee(BigDecimal handling_fee) {
        this.handling_fee = handling_fee;
    }

    /**
     * @return handling_fee_payyn
     */
    public String getHandling_fee_payyn() {
        return handling_fee_payyn;
    }

    /**
     * @param handling_fee_payyn
     */
    public void setHandling_fee_payyn(String handling_fee_payyn) {
        this.handling_fee_payyn = handling_fee_payyn;
    }

    /**
     * 获取国内单价
     *
     * @return unitprice_cn - 国内单价
     */
    public BigDecimal getUnitprice_cn() {
        return unitprice_cn;
    }

    /**
     * 设置国内单价
     *
     * @param unitprice_cn 国内单价
     */
    public void setUnitprice_cn(BigDecimal unitprice_cn) {
        this.unitprice_cn = unitprice_cn;
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
     * 获取国内单价类型
     *
     * @return unitprice_cn_type - 国内单价类型
     */
    public String getUnitprice_cn_type() {
        return unitprice_cn_type;
    }

    /**
     * 设置国内单价类型
     *
     * @param unitprice_cn_type 国内单价类型
     */
    public void setUnitprice_cn_type(String unitprice_cn_type) {
        this.unitprice_cn_type = unitprice_cn_type;
    }

    /**
     * 获取国外价格
     *
     * @return unitprice_fob - 国外价格
     */
    public BigDecimal getUnitprice_fob() {
        return unitprice_fob;
    }

    /**
     * 设置国外价格
     *
     * @param unitprice_fob 国外价格
     */
    public void setUnitprice_fob(BigDecimal unitprice_fob) {
        this.unitprice_fob = unitprice_fob;
    }

    /**
     * 获取单价单位
     *
     * @return unitprice_unit - 单价单位
     */
    public String getUnitprice_unit() {
        return unitprice_unit;
    }

    /**
     * 设置单价单位
     *
     * @param unitprice_unit 单价单位
     */
    public void setUnitprice_unit(String unitprice_unit) {
        this.unitprice_unit = unitprice_unit;
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
     * 获取订单箱数
     *
     * @return order_ctns - 订单箱数
     */
    public Integer getOrder_ctns() {
        return order_ctns;
    }

    /**
     * 设置订单箱数
     *
     * @param order_ctns 订单箱数
     */
    public void setOrder_ctns(Integer order_ctns) {
        this.order_ctns = order_ctns;
    }

    /**
     * 获取箱数库存
     *
     * @return order_ctns_stock - 箱数库存
     */
    public Integer getOrder_ctns_stock() {
        return order_ctns_stock;
    }

    /**
     * 设置箱数库存
     *
     * @param order_ctns_stock 箱数库存
     */
    public void setOrder_ctns_stock(Integer order_ctns_stock) {
        this.order_ctns_stock = order_ctns_stock;
    }

    /**
     * 获取件数库存
     *
     * @return order_pcs_stock - 件数库存
     */
    public Integer getOrder_pcs_stock() {
        return order_pcs_stock;
    }

    /**
     * 设置件数库存
     *
     * @param order_pcs_stock 件数库存
     */
    public void setOrder_pcs_stock(Integer order_pcs_stock) {
        this.order_pcs_stock = order_pcs_stock;
    }

    /**
     * 获取订单件数
     *
     * @return order_pcs - 订单件数
     */
    public Integer getOrder_pcs() {
        return order_pcs;
    }

    /**
     * 设置订单件数
     *
     * @param order_pcs 订单件数
     */
    public void setOrder_pcs(Integer order_pcs) {
        this.order_pcs = order_pcs;
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
     * 获取国内总价
     *
     * @return total_amount_cn - 国内总价
     */
    public BigDecimal getTotal_amount_cn() {
        return total_amount_cn;
    }

    /**
     * 设置国内总价
     *
     * @param total_amount_cn 国内总价
     */
    public void setTotal_amount_cn(BigDecimal total_amount_cn) {
        this.total_amount_cn = total_amount_cn;
    }

    /**
     * 获取内盒确认样回签人
     *
     * @return signback_nm - 内盒确认样回签人
     */
    public String getSignback_nm() {
        return signback_nm;
    }

    /**
     * 设置内盒确认样回签人
     *
     * @param signback_nm 内盒确认样回签人
     */
    public void setSignback_nm(String signback_nm) {
        this.signback_nm = signback_nm;
    }

    /**
     * 获取回签日
     *
     * @return signback_date - 回签日
     */
    public Date getSignback_date() {
        return signback_date;
    }

    /**
     * 设置回签日
     *
     * @param signback_date 回签日
     */
    public void setSignback_date(Date signback_date) {
        this.signback_date = signback_date;
    }

    /**
     * 获取内盒长
     *
     * @return inner_length - 内盒长
     */
    public BigDecimal getInner_length() {
        return inner_length;
    }

    /**
     * 设置内盒长
     *
     * @param inner_length 内盒长
     */
    public void setInner_length(BigDecimal inner_length) {
        this.inner_length = inner_length;
    }

    /**
     * 获取内盒宽
     *
     * @return inner_width - 内盒宽
     */
    public BigDecimal getInner_width() {
        return inner_width;
    }

    /**
     * 设置内盒宽
     *
     * @param inner_width 内盒宽
     */
    public void setInner_width(BigDecimal inner_width) {
        this.inner_width = inner_width;
    }

    /**
     * 获取内盒高
     *
     * @return inner_height - 内盒高
     */
    public BigDecimal getInner_height() {
        return inner_height;
    }

    /**
     * 设置内盒高
     *
     * @param inner_height 内盒高
     */
    public void setInner_height(BigDecimal inner_height) {
        this.inner_height = inner_height;
    }

    /**
     * 获取内盒尺寸单位
     *
     * @return inner_size_unit - 内盒尺寸单位
     */
    public String getInner_size_unit() {
        return inner_size_unit;
    }

    /**
     * 设置内盒尺寸单位
     *
     * @param inner_size_unit 内盒尺寸单位
     */
    public void setInner_size_unit(String inner_size_unit) {
        this.inner_size_unit = inner_size_unit;
    }

    /**
     * 获取大箱长
     *
     * @return box_length - 大箱长
     */
    public BigDecimal getBox_length() {
        return box_length;
    }

    /**
     * 设置大箱长
     *
     * @param box_length 大箱长
     */
    public void setBox_length(BigDecimal box_length) {
        this.box_length = box_length;
    }

    /**
     * 获取大箱宽
     *
     * @return box_width - 大箱宽
     */
    public BigDecimal getBox_width() {
        return box_width;
    }

    /**
     * 设置大箱宽
     *
     * @param box_width 大箱宽
     */
    public void setBox_width(BigDecimal box_width) {
        this.box_width = box_width;
    }

    /**
     * 获取大箱高
     *
     * @return box_height - 大箱高
     */
    public BigDecimal getBox_height() {
        return box_height;
    }

    /**
     * 设置大箱高
     *
     * @param box_height 大箱高
     */
    public void setBox_height(BigDecimal box_height) {
        this.box_height = box_height;
    }

    /**
     * 获取大箱尺寸单位
     *
     * @return box_size_unit - 大箱尺寸单位
     */
    public String getBox_size_unit() {
        return box_size_unit;
    }

    /**
     * 设置大箱尺寸单位
     *
     * @param box_size_unit 大箱尺寸单位
     */
    public void setBox_size_unit(String box_size_unit) {
        this.box_size_unit = box_size_unit;
    }

    /**
     * 获取单个重量
     *
     * @return unit_weight - 单个重量
     */
    public String getUnit_weight() {
        return unit_weight;
    }

    /**
     * 设置单个重量
     *
     * @param unit_weight 单个重量
     */
    public void setUnit_weight(String unit_weight) {
        this.unit_weight = unit_weight;
    }

    /**
     * 获取大箱净重
     *
     * @return box_nw - 大箱净重
     */
    public BigDecimal getBox_nw() {
        return box_nw;
    }

    /**
     * 设置大箱净重
     *
     * @param box_nw 大箱净重
     */
    public void setBox_nw(BigDecimal box_nw) {
        this.box_nw = box_nw;
    }

    /**
     * 获取大箱毛重
     *
     * @return box_gw - 大箱毛重
     */
    public BigDecimal getBox_gw() {
        return box_gw;
    }

    /**
     * 设置大箱毛重
     *
     * @param box_gw 大箱毛重
     */
    public void setBox_gw(BigDecimal box_gw) {
        this.box_gw = box_gw;
    }

    /**
     * 获取内盒净重
     *
     * @return inner_nw - 内盒净重
     */
    public BigDecimal getInner_nw() {
        return inner_nw;
    }

    /**
     * 设置内盒净重
     *
     * @param inner_nw 内盒净重
     */
    public void setInner_nw(BigDecimal inner_nw) {
        this.inner_nw = inner_nw;
    }

    /**
     * 获取内盒毛重
     *
     * @return inner_gw - 内盒毛重
     */
    public BigDecimal getInner_gw() {
        return inner_gw;
    }

    /**
     * 设置内盒毛重
     *
     * @param inner_gw 内盒毛重
     */
    public void setInner_gw(BigDecimal inner_gw) {
        this.inner_gw = inner_gw;
    }

    /**
     * 获取产地
     *
     * @return production - 产地
     */
    public String getProduction() {
        return production;
    }

    /**
     * 设置产地
     *
     * @param production 产地
     */
    public void setProduction(String production) {
        this.production = production;
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
     * 获取产前样交期
     *
     * @return pp_delivery_date - 产前样交期
     */
    public Date getPp_delivery_date() {
        return pp_delivery_date;
    }

    /**
     * 设置产前样交期
     *
     * @param pp_delivery_date 产前样交期
     */
    public void setPp_delivery_date(Date pp_delivery_date) {
        this.pp_delivery_date = pp_delivery_date;
    }

    /**
     * 获取内盒样交期
     *
     * @return inner_delivery_date - 内盒样交期
     */
    public Date getInner_delivery_date() {
        return inner_delivery_date;
    }

    /**
     * 设置内盒样交期
     *
     * @param inner_delivery_date 内盒样交期
     */
    public void setInner_delivery_date(Date inner_delivery_date) {
        this.inner_delivery_date = inner_delivery_date;
    }

    /**
     * 获取品管样交期
     *
     * @return qc_delivery_date - 品管样交期
     */
    public Date getQc_delivery_date() {
        return qc_delivery_date;
    }

    /**
     * 设置品管样交期
     *
     * @param qc_delivery_date 品管样交期
     */
    public void setQc_delivery_date(Date qc_delivery_date) {
        this.qc_delivery_date = qc_delivery_date;
    }

    /**
     * 获取大货样交期
     *
     * @return bulk_delivery_date - 大货样交期
     */
    public Date getBulk_delivery_date() {
        return bulk_delivery_date;
    }

    /**
     * 设置大货样交期
     *
     * @param bulk_delivery_date 大货样交期
     */
    public void setBulk_delivery_date(Date bulk_delivery_date) {
        this.bulk_delivery_date = bulk_delivery_date;
    }

    /**
     * 获取国内交期
     *
     * @return factory_delivery_date - 国内交期
     */
    public Date getFactory_delivery_date() {
        return factory_delivery_date;
    }

    /**
     * 设置国内交期
     *
     * @param factory_delivery_date 国内交期
     */
    public void setFactory_delivery_date(Date factory_delivery_date) {
        this.factory_delivery_date = factory_delivery_date;
    }

    /**
     * 获取交货日期
     *
     * @return delivery_date - 交货日期
     */
    public Date getDelivery_date() {
        return delivery_date;
    }

    /**
     * 设置交货日期
     *
     * @param delivery_date 交货日期
     */
    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取注意事项
     *
     * @return notice - 注意事项
     */
    public String getNotice() {
        return notice;
    }

    /**
     * 设置注意事项
     *
     * @param notice 注意事项
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }
}