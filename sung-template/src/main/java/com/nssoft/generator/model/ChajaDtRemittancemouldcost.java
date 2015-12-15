package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_DT_REMITTANCEMOULDCOST")
public class ChajaDtRemittancemouldcost {
    /**
     * 汇款编号
     */
    @Id
    private String remittance_id;

    /**
     * 模具合同号
     */
    @Id
    private String contract_no;

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
     * 获取模具合同号
     *
     * @return contract_no - 模具合同号
     */
    public String getContract_no() {
        return contract_no;
    }

    /**
     * 设置模具合同号
     *
     * @param contract_no 模具合同号
     */
    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
    }
}