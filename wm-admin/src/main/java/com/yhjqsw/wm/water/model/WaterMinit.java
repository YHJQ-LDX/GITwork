package com.yhjqsw.wm.water.model;

import java.math.BigDecimal;
import java.util.Date;

public class WaterMinit {
    /** ID **/
    private Long id;
    /**机构ID*/
    private String deptid;
    /** 机构名称*/
    private String deptname;
    /** 水表号*/
    private String watermno;
    /** 水表初始值*/
    private BigDecimal waterminitvalue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getWatermno() {
        return watermno;
    }

    public void setWatermno(String watermno) {
        this.watermno = watermno;
    }

    public BigDecimal getWaterminitvalue() {
        return waterminitvalue;
    }

    public void setWaterminitvalue(BigDecimal waterminitvalue) {
        this.waterminitvalue = waterminitvalue;
    }

}
