package com.yhjqsw.wm.water.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.yhjqsw.wm.admin.util.SecurityUtils;
import com.yhjqsw.wm.core.page.ColumnFilter;
import com.yhjqsw.wm.core.page.MybatisPageHelper;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.core.page.PageResult;
import com.yhjqsw.wm.water.model.WmOperateRecord;
import com.yhjqsw.wm.water.service.WmOperateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yhjqsw.wm.water.model.WmDaywaterin;
import com.yhjqsw.wm.water.dao.WmDaywaterinMapper;
import com.yhjqsw.wm.water.service.WmDaywaterinService;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * ---------------------------
 * 入水水量表:存储入水水量信息 (WmDaywaterinServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
@Transactional
public class WmDaywaterinServiceImpl implements WmDaywaterinService {

	@Autowired
	private WmDaywaterinMapper wmDaywaterinMapper;
	@Autowired
	private WmOperateRecordService wmOperateRecordService;
	@Override
	public int save(WmDaywaterin record) throws Exception {

		BigDecimal preWaterMValue = BigDecimal.valueOf(0);

		// 获取计量日期前一天的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = record.getMeterdate();
		java.util.Date day = sdf.parse(record.getMeterdate());
		long ms = day.getTime() - 1*24*3600*1000L;
		Date prevDay = new Date(ms);
		String predateStr = sdf.format(prevDay);

		record.setMeterdate(predateStr);
		int pretotalcount = wmDaywaterinMapper.selectPreTotalCountByPrimaryKey(record);
		if(pretotalcount <= 0  ){
			preWaterMValue = wmDaywaterinMapper.selectInitWaterMValue(record);
		}else {
			int precount = wmDaywaterinMapper.selectCountByPrimaryKey(record);
			if(precount == 0){
				throw new Exception(predateStr+"的数据还没有录入，请按日期先后顺序录入");
			}else{
				preWaterMValue = wmDaywaterinMapper.selectWaterMValue(record);
			}
		}

		BigDecimal waterIn = record.getWatermvalue().subtract(preWaterMValue);
		record.setWaterin(waterIn);
		record.setMeterdate(dateStr);

		if(record.getId() == null || record.getId() == 0) {
			int count = wmDaywaterinMapper.selectCountByPrimaryKey(record);
			if(count >0){
				throw new Exception("记录已存在，请勿重复添加");
			}
			return wmDaywaterinMapper.add(record);
		}
		return wmDaywaterinMapper.update(record);
	}

	@Override
	public int delete(WmDaywaterin record) {
		return wmDaywaterinMapper.delete(record.getId());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delete(List<WmDaywaterin> records) {
		for(WmDaywaterin record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public WmDaywaterin findById(Long id) {
		return null;
	}

//	@Override
//	public WmDaywaterin findById(java.util.Date id) {
//		return wmDaywaterinMapper.findById(id);
//	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		String username = getColumnFilterValue(pageRequest, "username");
		String deptname = getColumnFilterValue(pageRequest, "deptname");
		String begindateStr =  getColumnFilterValue(pageRequest, "begindate");
		String enddateStr =  getColumnFilterValue(pageRequest, "enddate");
		return MybatisPageHelper.findPage(pageRequest, wmDaywaterinMapper,"findPage", username,deptname,begindateStr,enddateStr);
	}

	@Override
	public PageResult findSubmitPage(PageRequest pageRequest){
		String username = getColumnFilterValue(pageRequest, "username");
		String commit = getColumnFilterValue(pageRequest, "commit");
		String apply = getColumnFilterValue(pageRequest, "apply");
		String checked = getColumnFilterValue(pageRequest, "checked");
		String deptname = getColumnFilterValue(pageRequest, "deptname");
		String begindateStr =  getColumnFilterValue(pageRequest, "begindate");
		String enddateStr =  getColumnFilterValue(pageRequest, "enddate");
		return MybatisPageHelper.findPage(pageRequest, wmDaywaterinMapper,"findSubmitPage",
				username,commit,apply,checked,deptname,begindateStr,enddateStr);
	}



	@Override
	public int updateCommitflag(List<WmDaywaterin> records) {
		for(WmDaywaterin record:records) {
			updateCommitflag(record);
		}
		return 1;
	}

	@Override
	public int updateCommitflag(WmDaywaterin record) {

		WmOperateRecord wmOperateRecord=new WmOperateRecord();
		wmOperateRecord.setOperateModule("日入水量");//模块
		wmOperateRecord.setOperateModuleRecordId(record.getId());//数据ID
		wmOperateRecord.setOperateType("提交");//操作类型
		wmOperateRecord.setOperateTime(new java.util.Date());//操作时间
		wmOperateRecord.setOperateUser(SecurityUtils.getUsername());//操作人员
		try {
			wmOperateRecordService.save(wmOperateRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wmDaywaterinMapper.updateCommitflagById(record);
	}

	@Override
	public int selectCountByPrimaryKey(WmDaywaterin record) {
		return wmDaywaterinMapper.selectCountByPrimaryKey(record);
	}

	@Override
	public int updateApplyFlag(List<WmDaywaterin> records) {
		for(WmDaywaterin record:records) {
			updateApplyFlag(record);
		}
		return 1;
	}

	@Override
	public int updatereject(WmDaywaterin record) {
		WmOperateRecord wmOperateRecord=new WmOperateRecord();
		wmOperateRecord.setOperateModule("日入水量");//模块
		wmOperateRecord.setOperateModuleRecordId(record.getId());//数据ID
		wmOperateRecord.setOperateType("驳回");//操作类型
		wmOperateRecord.setOperateTime(new java.util.Date());//操作时间
		wmOperateRecord.setOperateUser(SecurityUtils.getUsername());//操作人员
		try {
			wmOperateRecordService.save(wmOperateRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wmDaywaterinMapper.updatereject(record);
	}


	@Override
	public int updatereject(List<WmDaywaterin> records) {
		for(WmDaywaterin record:records) {
			updatereject(record);
		}
		return 1;
	}

	@Override
	public int updateApplyFlag(WmDaywaterin record) {
		WmOperateRecord wmOperateRecord=new WmOperateRecord();
		wmOperateRecord.setOperateModule("日入水量");//模块
		wmOperateRecord.setOperateModuleRecordId(record.getId());//数据ID
		wmOperateRecord.setOperateType("申请");//操作类型
		wmOperateRecord.setOperateTime(new java.util.Date());//操作时间
		wmOperateRecord.setOperateUser(SecurityUtils.getUsername());//操作人员
		try {
			wmOperateRecordService.save(wmOperateRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wmDaywaterinMapper.updateApplyflagById(record);
	}

	@Override
	public int updateCheckFlag(List<WmDaywaterin> records) {
		for(WmDaywaterin record:records) {
			updateCheckFlag(record);
		}
		return 1;
	}

	@Override
	public int updateCheckFlag(WmDaywaterin record) {
		WmOperateRecord wmOperateRecord=new WmOperateRecord();
		wmOperateRecord.setOperateModule("日入水量");//模块
		wmOperateRecord.setOperateModuleRecordId(record.getId());//数据ID
		wmOperateRecord.setOperateType("审核");//操作类型
		wmOperateRecord.setOperateTime(new java.util.Date());//操作时间
		wmOperateRecord.setOperateUser(SecurityUtils.getUsername());//操作人员
		try {
			wmOperateRecordService.save(wmOperateRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wmDaywaterinMapper.updateCheckflagById(record);
	}

	/**
	 * 获取过滤字段的值
	 * @param filterName
	 * @return
	 */
	public String getColumnFilterValue(PageRequest pageRequest, String filterName) {
		String value = null;
		ColumnFilter columnFilter = pageRequest.getColumnFilter(filterName);
		if(columnFilter != null) {
			value = columnFilter.getValue();
		}
		return value;

	}

}



