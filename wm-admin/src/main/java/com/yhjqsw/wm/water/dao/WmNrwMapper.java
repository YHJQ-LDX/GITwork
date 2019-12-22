package com.yhjqsw.wm.water.dao;

import java.util.List;

import com.yhjqsw.wm.water.model.WmNrw;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

/**
 * ---------------------------
 * 产销差表:程序通过后台定时任务计算每个营业所的产销差和产销差率 (WmNrwMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface WmNrwMapper {

	/**
	 * 添加产销差表:程序通过后台定时任务计算每个营业所的产销差和产销差率
	 * @param record
	 * @return
	 */
    int add(WmNrw record);

    int total_add(WmNrw record);

    /**
     * 删除产销差表:程序通过后台定时任务计算每个营业所的产销差和产销差率
     * @param metermonth
     * @return
     */
    int delete(String metermonth);
    
    /**
     * 修改产销差表:程序通过后台定时任务计算每个营业所的产销差和产销差率
     * @param record
     * @return
     */
    int update(WmNrw record);

    int total_update(WmNrw record);
    
    /**
     * 根据主键查询
     * @param metermonth
     * @return
     */    
    WmNrw findById(String metermonth);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<WmNrw> findPage(@Param(value="deptname") String deptname,
                         @Param(value="begindate") String begindate,
                         @Param(value="enddate") String enddate);
    List<WmNrw> findTotalPage(@Param(value="deptname") String deptname,
                         @Param(value="begindate") String begindate,
                         @Param(value="enddate") String enddate);

    int selectCountByPrimaryKey(@Param("deptno")String deptno, @Param("metermonth") String metermonth);
    
}