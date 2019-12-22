package com.yhjqsw.wm.water.service.impl;

import java.util.List;

import com.yhjqsw.wm.core.page.ColumnFilter;
import com.yhjqsw.wm.core.page.MybatisPageHelper;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhjqsw.wm.water.model.WmOperateRecord;
import com.yhjqsw.wm.water.dao.WmOperateRecordMapper;
import com.yhjqsw.wm.water.service.WmOperateRecordService;

/**
 * ---------------------------
 *  (WmOperateRecordServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-08-07 14:58:57
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class WmOperateRecordServiceImpl implements WmOperateRecordService {

	@Autowired
	private WmOperateRecordMapper wmOperateRecordMapper;

	@Override
	public int save(WmOperateRecord record) {
		if(record.getId() == null || record.getId() == 0) {
			return wmOperateRecordMapper.add(record);
		}
		return wmOperateRecordMapper.update(record);
	}

	@Override
	public int delete(WmOperateRecord record) {
		return wmOperateRecordMapper.delete(record.getId());
	}

	@Override
	public int delete(List<WmOperateRecord> records) {
		for(WmOperateRecord record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public WmOperateRecord findById(Long id) {
		return wmOperateRecordMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		String id = getColumnFilterValue(pageRequest, "id");
		String operatemodule = getColumnFilterValue(pageRequest, "operatemodule");
		String begindateStr =  getColumnFilterValue(pageRequest, "begindate");
		String enddateStr =  getColumnFilterValue(pageRequest, "enddate");
		return MybatisPageHelper.findPage(pageRequest, wmOperateRecordMapper,"findPage",
				id,operatemodule,begindateStr,enddateStr);
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
