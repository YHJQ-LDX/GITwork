package com.yhjqsw.wm.water.service;

import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.core.page.PageResult;
import com.yhjqsw.wm.core.service.CurdService;
import com.yhjqsw.wm.water.model.WmDaywaterin;

import java.util.List;

/**
 * ---------------------------
 * 入水水量表:存储入水水量信息 (WmDaywaterinService)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface WmDaywaterinService extends CurdService<WmDaywaterin> {
    PageResult findSubmitPage(PageRequest pageRequest);

//    Long idFond(WmDaywaterin record);

    int updateCommitflag(List<WmDaywaterin> records);
    int updateCommitflag(WmDaywaterin records);
    int selectCountByPrimaryKey(WmDaywaterin record);

    int updateApplyFlag(List<WmDaywaterin> records);
    int updateApplyFlag(WmDaywaterin record);

    int updatereject(List<WmDaywaterin> records);
    int updatereject(WmDaywaterin record);

    int updateCheckFlag(List<WmDaywaterin> records);
    int updateCheckFlag(WmDaywaterin record);

}
