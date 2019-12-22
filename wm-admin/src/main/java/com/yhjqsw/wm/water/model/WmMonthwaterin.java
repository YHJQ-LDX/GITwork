package com.yhjqsw.wm.water.model;

import java.math.BigDecimal;

/**
 * ---------------------------
 * 月入水水量表:存储每一个用户的token信息 (WmMonthwaterin)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class WmMonthwaterin {

	private Long id;

	/** 组织编码 */
	private String deptno;
	/** 组织名称 */
	private String deptname;
	/** 计量年月 */
	private String metermonth;
	/** 水表号 */
	private String watermno;

	/*** 月入水量 */
	private BigDecimal waterin;

	/** 创建人编码 */
	private String createby;
	/** 创建时间 */
	private java.util.Date createtime;
	/** 更新人编码 */
	private String lastupdateby;
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

	public String getWatermno() {
		return watermno;
	}

	public void setWatermno(String watermno) {
		this.watermno = watermno;
	}

	public BigDecimal getWaterin() {
		return waterin;
	}

	public void setWaterin(BigDecimal waterin) {
		this.waterin = waterin;
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