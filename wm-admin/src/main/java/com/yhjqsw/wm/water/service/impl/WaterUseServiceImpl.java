package com.yhjqsw.wm.water.service.impl;

import com.yhjqsw.wm.core.page.MybatisPageHelper;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.core.page.PageResult;
import com.yhjqsw.wm.water.dao.WaterUseMapper;
import com.yhjqsw.wm.water.model.WaterUse;
import com.yhjqsw.wm.water.service.WaterUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------
 *  (WaterUseServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-08-05 15:51:05
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class WaterUseServiceImpl implements WaterUseService {

	@Autowired
	private WaterUseMapper waterUseMapper;

	@Override
	public int save(WaterUse record) {
		if(record.getId() == null || record.getId() == 0) {
			return waterUseMapper.add(record);
		}
		return waterUseMapper.update(record);
	}

	@Override
	public int delete(WaterUse record) {
		return waterUseMapper.delete(record.getId());
	}

	@Override
	public int delete(List<WaterUse> records) {
		for(WaterUse record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public WaterUse findById(Long id) {
		return waterUseMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, waterUseMapper);
	}

	@Override
	public List<WaterUse> findTree() {
		List<WaterUse> waterUses = waterUseMapper.findAll();
		return waterUses;
	}
}
