package com.yhjqsw.wm.water.model;

import java.math.BigDecimal;

/**
 * ---------------------------
 * 月出水水量表：存储月出水水量信息 (WmMonthwaterout)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-29 17:14:13
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class WmMonthwaterout {

	/**  */
	private Long id;
	/** 组织编码 */
	private String deptno;
	/** 组织名称 */
	private String deptname;
	/** 计量年月 */
	private String metermonth;
	/** 用水性质*/
	private String wateruse;
	/** 出水量 */
	private BigDecimal waterout;
	/** 提交标志位 */
	private String commitflag;
	/** 审核标志位 */
	private String checkflag;
	/** 提交人用户编码 */
	private String commitusercode;
	/** 提交人用户名 */
	private String commitusername;
	/** 审核人用户编码 */
	private String checkusercode;
	/** 审核人用户名 */
	private String checkusername;
	/** 申请修改标志位 */
	private String redoappflag;
	/** 申请修改次数 */
	private Integer redoapptimes;
	/** 创建人编码 */
	private String createby;
	/** 创建时间 */
	private java.util.Date createtime;
	/** 更新人编码 */
	private String lastupdateby;
	/** 更新时间 */
	private String lastupdatetime;
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

	public String getWateruse() {
		return wateruse;
	}

	public void setWateruse(String wateruse) {
		this.wateruse = wateruse;
	}

	public BigDecimal getWaterout() {
		return waterout;
	}

	public void setWaterout(BigDecimal waterout) {
		this.waterout = waterout;
	}

	public String getCommitflag() {
		return commitflag;
	}

	public void setCommitflag(String commitflag) {
		this.commitflag = commitflag;
	}

	public String getCheckflag() {
		return checkflag;
	}

	public void setCheckflag(String checkflag) {
		this.checkflag = checkflag;
	}

	public String getCommitusercode() {
		return commitusercode;
	}

	public void setCommitusercode(String commitusercode) {
		this.commitusercode = commitusercode;
	}

	public String getCommitusername() {
		return commitusername;
	}

	public void setCommitusername(String commitusername) {
		this.commitusername = commitusername;
	}

	public String getCheckusercode() {
		return checkusercode;
	}

	public void setCheckusercode(String checkusercode) {
		this.checkusercode = checkusercode;
	}

	public String getCheckusername() {
		return checkusername;
	}

	public void setCheckusername(String checkusername) {
		this.checkusername = checkusername;
	}

	public String getRedoappflag() {
		return redoappflag;
	}

	public void setRedoappflag(String redoappflag) {
		this.redoappflag = redoappflag;
	}

	public Integer getRedoapptimes() {
		return redoapptimes;
	}

	public void setRedoapptimes(Integer redoapptimes) {
		this.redoapptimes = redoapptimes;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public String getLastupdateby() {
		return lastupdateby;
	}

	public void setLastupdateby(String lastupdateby) {
		this.lastupdateby = lastupdateby;
	}

	public String getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(String lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}