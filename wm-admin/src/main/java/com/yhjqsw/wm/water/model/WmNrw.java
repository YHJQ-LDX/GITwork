package com.yhjqsw.wm.water.model;

import java.math.BigDecimal;

/**
 * ---------------------------
 * 产销差表:程序通过后台定时任务计算每个营业所的产销差和产销差率 (WmNrw)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class WmNrw {

	private Long id;
	/** 组织编码 */
	private String deptno;
	/** 组织名称 */
	private String deptname;
	/** 计量年月 */
	private String metermonth;
	/** 月入水水量 */
	private BigDecimal monthin;
	/** 月出水水量 */
	private BigDecimal monthout;
	/** 月产销差 */
	private BigDecimal nrw;
	/** 执行时长 */
	private BigDecimal nrwrate;
	/** 创建时间 */
	private java.util.Date createtime;
	/** 更新时间 */
	private java.util.Date lastupdatetime;
	/** 备注 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getMetermonth() {
		return metermonth;
	}

	public void setMetermonth(String metermonth) {
		this.metermonth = metermonth;
	}

	public BigDecimal getMonthin() {
		return monthin;
	}

	public void setMonthin(BigDecimal monthin) {
		this.monthin = monthin;
	}

	public BigDecimal getMonthout() {
		return monthout;
	}

	public void setMonthout(BigDecimal monthout) {
		this.monthout = monthout;
	}

	public BigDecimal getNrw() {
		return nrw;
	}

	public void setNrw(BigDecimal nrw) {
		this.nrw = nrw;
	}

	public BigDecimal getNrwrate() {
		return nrwrate;
	}

	public void setNrwrate(BigDecimal nrwrate) {
		this.nrwrate = nrwrate;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(java.util.Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}