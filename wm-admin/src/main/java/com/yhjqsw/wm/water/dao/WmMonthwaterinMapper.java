package com.yhjqsw.wm.water.dao;

import java.util.List;

import com.yhjqsw.wm.water.model.WmMonthwaterin;
import org.apache.ibatis.annotations.Param;

/**
 * ---------------------------
 * 月入水水量表:存储每一个用户的token信息 (WmMonthwaterinMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface WmMonthwaterinMapper {

	/**
	 * 添加月入水水量表:存储每一个用户的token信息
	 * @param record
	 * @return
	 */
    int add(WmMonthwaterin record);

    /**
     * 删除月入水水量表:存储每一个用户的token信息
     * @param deptno
     * @return
     */
    int delete(String deptno);
    
    /**
     * 修改月入水水量表:存储每一个用户的token信息
     * @param record
     * @return
     */
    int update(WmMonthwaterin record);
    
    /**
     * 根据主键查询
     * @param deptno
     * @return
     */    
    WmMonthwaterin findById(String deptno);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<WmMonthwaterin> findPage( @Param(value = "username") String username,
                                   @Param(value="deptname") String deptname,
                                   @Param(value="begindate") String begindate,
                                   @Param(value="enddate") String enddate);

    List<WmMonthwaterin> findByMonth(String metermonth);

    int selectCountByPrimaryKey(WmMonthwaterin record);


    
}