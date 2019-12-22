package com.yhjqsw.wm.admin.sevice;

import java.util.List;

import com.yhjqsw.wm.admin.model.SysDict;
import com.yhjqsw.wm.core.service.CurdService;

/**
 * 字典管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
