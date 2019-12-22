package com.yhjqsw.wm.water.dao;

import com.yhjqsw.wm.water.model.WaterMinit;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 初始水量表
 **/
public interface WaterMinitMapper {
    /**
     * 添加初始水量表
     * @param record
     * @return
     */
    int add(WaterMinit record);
    /**
     * 删除初始水量表
     * @param id
     * @return
     */
    int delete(Long id);
    /**
     * 修改初始水量表
     * @param record
     * @return
     */
    int update(WaterMinit record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    WaterMinit findById(Long id);
    /**
     * 基础分页查询
     * *@param record
     * @return
     */
    List<WaterMinit> findPage(@Param(value="watermno") String watermno);

    int selectCountByPrimaryKey(WaterMinit record);

}
