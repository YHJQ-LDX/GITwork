package com.yhjqsw.wm.water.dao;

import com.yhjqsw.wm.water.model.WaterUse;

import java.util.List;

/**
 * ---------------------------
 *  (WaterUseMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-08-05 15:51:05
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface WaterUseMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int add(WaterUse record);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改
     * @param record
     * @return
     */
    int update(WaterUse record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    WaterUse findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<WaterUse> findPage();

    List<WaterUse> findAll();
    
}