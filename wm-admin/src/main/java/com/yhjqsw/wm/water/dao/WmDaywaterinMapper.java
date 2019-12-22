package com.yhjqsw.wm.water.dao;

import java.math.BigDecimal;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yhjqsw.wm.water.model.WmDaywaterin;
import com.yhjqsw.wm.water.model.WmMonthwaterin;
import org.apache.ibatis.annotations.Param;

/**
 * ---------------------------
 * 入水水量表:存储入水水量信息 (WmDaywaterinMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface WmDaywaterinMapper {

	/**
	 * 添加入水水量表:存储入水水量信息
	 * @param record
	 * @return
	 */
    int add(WmDaywaterin record);

    /**
     * 删除入水水量表:存储入水水量信息
     * @param meterdate
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改入水水量表:存储入水水量信息
     * @param record
     * @return
     */
    int update(WmDaywaterin record);
    
    /**
     * 根据主键查询
     * @param meterdate
     * @return
     */    
    WmDaywaterin findById(java.util.Date meterdate);

    /**
     * 基础分页查询
     * @param record
     * @return
     */
    List<WmDaywaterin> findPage(@Param(value="username") String username,
                                @Param(value="deptname") String deptname,
                                @Param(value="begindate") String begindate,
                                @Param(value="enddate") String enddate);

    List<WmDaywaterin> findSubmitPage(@Param(value="username") String username,
                                      @Param(value="commit") String commit,
                                      @Param(value="apply") String apply,
                                      @Param(value="checked") String checked,
                                      @Param(value="deptname") String deptname,
                                      @Param(value="begindate") String begindate,
                                      @Param(value="enddate") String enddate);

    int selectCountByPrimaryKey(WmDaywaterin record);

    int selectPreTotalCountByPrimaryKey(WmDaywaterin record);

    BigDecimal selectWaterMValue(WmDaywaterin preRecord);

    BigDecimal  selectInitWaterMValue(WmDaywaterin record);

    List<Map<String,Object>>  selectMonthWaterIn(@Param("preday") String preday, @Param("day") String day);

    int updateCommitflagById(WmDaywaterin record);

    int updateApplyflagById(WmDaywaterin record);

    int updatereject(WmDaywaterin record);

    int updateCheckflagById(WmDaywaterin record);


    
}