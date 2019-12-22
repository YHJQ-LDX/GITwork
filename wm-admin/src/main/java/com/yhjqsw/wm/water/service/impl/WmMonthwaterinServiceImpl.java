package com.yhjqsw.wm.water.service.impl;

import java.util.List;

import com.yhjqsw.wm.core.page.ColumnFilter;
import com.yhjqsw.wm.core.page.MybatisPageHelper;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhjqsw.wm.water.model.WmMonthwaterin;
import com.yhjqsw.wm.water.dao.WmMonthwaterinMapper;
import com.yhjqsw.wm.water.service.WmMonthwaterinService;

/**
 * ---------------------------
 * 月入水水量表:存储每一个用户的token信息 (WmMonthwaterinServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class WmMonthwaterinServiceImpl implements WmMonthwaterinService {

	@Autowired
	private WmMonthwaterinMapper wmMonthwaterinMapper;

	@Override
	public int save(WmMonthwaterin record) {
		if(record.getDeptno() == null || record.getDeptno().equals("")) {
			return wmMonthwaterinMapper.add(record);
		}
		return wmMonthwaterinMapper.update(record);
	}

	@Override
	public int delete(WmMonthwaterin record) {
		return wmMonthwaterinMapper.delete(record.getDeptno());
	}

	@Override
	public int delete(List<WmMonthwaterin> records) {
		for(WmMonthwaterin record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public WmMonthwaterin findById(Long id) {
		return null;
	}

//	@Override
//	public WmMonthwaterin findById(String id) {
//		return wmMonthwaterinMapper.findById(id);
//	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		String username = getColumnFilterValue(pageRequest, "username");
		String deptname = getColumnFilterValue(pageRequest, "deptname");
		String begindateStr =  getColumnFilterValue(pageRequest, "begindate");
		String enddateStr =  getColumnFilterValue(pageRequest, "enddate");
		return MybatisPageHelper.findPage(pageRequest, wmMonthwaterinMapper,"findPage",
				username, deptname,begindateStr,enddateStr);
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
