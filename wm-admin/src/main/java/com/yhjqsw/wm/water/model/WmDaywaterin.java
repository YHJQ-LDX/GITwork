package com.yhjqsw.wm.water.model;

import java.math.BigDecimal;

/**
 * ---------------------------
 * 入水水量表:存储入水水量信息 (WmDaywaterin)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class WmDaywaterin {
	/** ID **/
	private Long id;
	/** 组织编码 */
	private String deptno;
	/** 属组织名称 */
	private String deptname;
	/** 水表号 */
	private String watermno;
	/** 计量日期 */
	private String meterdate;
	/** 水表数值 */
	private BigDecimal  watermvalue;
	/** 水表照片 */
	private String watermimage;
	/** 当日进水量 */
	private BigDecimal  waterin;
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

	private String applyflag;

	private String applyreason;

	private String applyuser;
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
	private java.util.Date lastupdatetime;
	/** 备注 */
	private String remark;

	/** 非数据库字段，图片base64串 **/
	String imgBase64;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgBase64() {
		return imgBase64;
	}

	public void setImgBase64(String imgBase64) {
		this.imgBase64 = imgBase64;
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

	public String getWatermno() {
		return watermno;
	}

	public void setWatermno(String watermno) {
		this.watermno = watermno;
	}

	public String getMeterdate() {
		return meterdate;
	}

	public void setMeterdate(String meterdate) {
		this.meterdate = meterdate;
	}

	public BigDecimal getWatermvalue() {
		return watermvalue;
	}

	public void setWatermvalue(BigDecimal  watermvalue) {
		this.watermvalue = watermvalue;
	}

	public String getWatermimage() {
		return watermimage;
	}

	public void setWatermimage(String watermimage) {
		this.watermimage = watermimage;
	}

	public BigDecimal  getWaterin() {
		return waterin;
	}

	public void setWaterin(BigDecimal  waterin) {
		this.waterin = waterin;
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

	public String getApplyflag() {
		return applyflag;
	}

	public void setApplyflag(String applyflag) {
		this.applyflag = applyflag;
	}

	public String getApplyreason() {
		return applyreason;
	}

	public void setApplyreason(String applyreason) {
		this.applyreason = applyreason;
	}

	public String getApplyuser() {
		return applyuser;
	}

	public void setApplyuser(String applyuser) {
		this.applyuser = applyuser;
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