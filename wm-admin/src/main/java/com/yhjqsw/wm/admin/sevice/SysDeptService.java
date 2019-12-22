package com.yhjqsw.wm.admin.sevice;

import java.util.List;

import com.yhjqsw.wm.admin.model.SysDept;
import com.yhjqsw.wm.core.service.CurdService;

/**
 * 机构管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<SysDept> findTree();
}
