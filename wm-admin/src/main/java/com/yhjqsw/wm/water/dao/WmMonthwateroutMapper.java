package com.yhjqsw.wm.water.dao;

import com.yhjqsw.wm.water.model.WmMonthwaterout;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ---------------------------
 * 月出水水量表：存储月出水水量信息 (WmMonthwateroutMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-29 17:14:13
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface WmMonthwateroutMapper {

	/**
	 * 添加月出水水量表：存储月出水水量信息
	 * @param record
	 * @return
	 */
    int add(WmMonthwaterout record);

    /**
     * 删除月出水水量表：存储月出水水量信息
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改月出水水量表：存储月出水水量信息
     * @param record
     * @return
     */
    int update(WmMonthwaterout record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    WmMonthwaterout findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<WmMonthwaterout> findPage(@Param(value = "username") String username,
                                   @Param(value="deptname") String deptname,
                                   @Param(value="wateruse") String wateruse,
                                   @Param(value="begindate") String begindate,
                                   @Param(value="enddate") String enddate);

    List<WmMonthwaterout> findByDeptAndMeterMonth(@Param("deptno") String deptno,
                                     @Param("metermonth") String metermonth);

    int selectCountByPrimaryKey(@Param("deptno") String deptno,
                                @Param("wateruse") String wateruse,
                                @Param("metermonth") String metermonth);
    
}