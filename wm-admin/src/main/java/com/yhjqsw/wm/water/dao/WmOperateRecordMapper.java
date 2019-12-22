package com.yhjqsw.wm.water.dao;

import java.util.List;

import com.yhjqsw.wm.water.model.WmOperateRecord;
import org.apache.ibatis.annotations.Param;

/**
 * ---------------------------
 *  (WmOperateRecordMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-08-07 14:58:57
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface WmOperateRecordMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int add(WmOperateRecord record);

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
    int update(WmOperateRecord record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    WmOperateRecord findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<WmOperateRecord> findPage(@Param(value="id") String id,
                                   @Param(value="operatemodule") String operatemodule ,
                                   @Param(value="begindate") String begindate,
                                   @Param(value="enddate") String enddate);
    
}