package com.yhjqsw.wm.water.service.impl;

import java.util.List;

import com.yhjqsw.wm.core.page.ColumnFilter;
import com.yhjqsw.wm.core.page.MybatisPageHelper;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhjqsw.wm.water.model.WmNrw;
import com.yhjqsw.wm.water.dao.WmNrwMapper;
import com.yhjqsw.wm.water.service.WmNrwService;

/**
 * ---------------------------
 * 产销差表:程序通过后台定时任务计算每个营业所的产销差和产销差率 (WmNrwServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class WmNrwServiceImpl implements WmNrwService {

	@Autowired
	private WmNrwMapper wmNrwMapper;

	@Override
	public int save(WmNrw record) {
		if(record.getMetermonth() == null || record.getMetermonth().equals("")) {
			return wmNrwMapper.add(record);
		}
		return wmNrwMapper.update(record);
	}

	@Override
	public int delete(WmNrw record) {
		return wmNrwMapper.delete(record.getMetermonth());
	}

	@Override
	public int delete(List<WmNrw> records) {
		for(WmNrw record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public WmNrw findById(Long id) {
		return null;
	}

//	@Override
//	public WmNrw findById(String id) {
//		return wmNrwMapper.findById(id);
//	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		String type = getColumnFilterValue(pageRequest,"type");
		String deptname = getColumnFilterValue(pageRequest, "deptname");
		String begindateStr =  getColumnFilterValue(pageRequest, "begindate");
		String enddateStr =  getColumnFilterValue(pageRequest, "enddate");
		if(type.equals("company")){
			return MybatisPageHelper.findPage(pageRequest, wmNrwMapper,"findTotalPage", deptname,begindateStr,enddateStr);
		}else{
			return MybatisPageHelper.findPage(pageRequest, wmNrwMapper,"findPage", deptname,begindateStr,enddateStr);
		}
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
