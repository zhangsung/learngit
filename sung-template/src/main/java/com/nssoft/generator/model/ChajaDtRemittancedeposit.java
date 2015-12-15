package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_DT_REMITTANCEDEPOSIT")
public class ChajaDtRemittancedeposit {
    /**
     * 汇款编号
     */
    @Id
    private String remittance_id;

    /**
     * 合同号
     */
    @Id
    private String contract_no;

    private String isShiped;

    /**
     * 备注
     */
    private String exp;

    /**
     * 获取汇款编号
     *
     * @return remittance_id - 汇款编号
     */
    public String getRemittance_id() {
        return remittance_id;
    }

    /**
     * 设置汇款编号
     *
     * @param remittance_id 汇款编号
     */
    public void setRemittance_id(String remittance_id) {
        this.remittance_id = remittance_id;
    }

    /**
     * 获取合同号
     *
     * @return contract_no - 合同号
     */
    public String getContract_no() {
        return contract_no;
    }

    /**
     * 设置合同号
     *
     * @param contract_no 合同号
     */
    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
    }

    /**
     * @return isShiped
     */
    public String getIsShiped() {
        return isShiped;
    }

    /**
     * @param isShiped
     */
    public void setIsShiped(String isShiped) {
        this.isShiped = isShiped;
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