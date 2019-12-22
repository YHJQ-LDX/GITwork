package com.yhjqsw.wm.water.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yhjqsw.wm.admin.model.SysDept;
import com.yhjqsw.wm.core.page.ColumnFilter;
import com.yhjqsw.wm.core.page.MybatisPageHelper;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.core.page.PageResult;
import com.yhjqsw.wm.water.dao.WaterUseMapper;
import com.yhjqsw.wm.water.dao.WmMonthwateroutMapper;
import com.yhjqsw.wm.water.model.WaterUse;
import com.yhjqsw.wm.water.model.WmMonthwaterout;
import com.yhjqsw.wm.water.service.WmMonthwateroutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * ---------------------------
 * 月出水水量表：存储月出水水量信息 (WmMonthwateroutServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-29 17:14:13
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class WmMonthwateroutServiceImpl implements WmMonthwateroutService {

	@Autowired
	private WmMonthwateroutMapper wmMonthwateroutMapper;
	@Autowired
	WaterUseMapper waterUseMapper;

	@Override
	public int save(WmMonthwaterout record) throws Exception {
		if(record.getId() == null || record.getId() == 0) {
			int count = wmMonthwateroutMapper.selectCountByPrimaryKey(record.getDeptno(),record.getWateruse(),record.getMetermonth());
			if(count>0){
				throw new Exception("记录已存在，请勿重复添加");
			}
			return wmMonthwateroutMapper.add(record);
		}
		return wmMonthwateroutMapper.update(record);
	}

	@Override
	public int delete(WmMonthwaterout record) {
		return wmMonthwateroutMapper.delete(record.getId());
	}

	@Override
	public int delete(List<WmMonthwaterout> records) {
		for(WmMonthwaterout record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public WmMonthwaterout findById(Long id) {
		return wmMonthwateroutMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		String username = getColumnFilterValue(pageRequest, "username");
		String deptname = getColumnFilterValue(pageRequest, "deptname");
		String wateruse = getColumnFilterValue(pageRequest, "wateruse");
		String begindateStr =  getColumnFilterValue(pageRequest, "begindate");
		String enddateStr =  getColumnFilterValue(pageRequest, "enddate");
		return MybatisPageHelper.findPage(pageRequest, wmMonthwateroutMapper,"findPage",
				username,deptname,wateruse,begindateStr,enddateStr);
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
		}else{
			value = "";
		}
		return value;
	}

}
