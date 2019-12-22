package com.yhjqsw.wm.water.service;

import com.yhjqsw.wm.core.service.CurdService;
import com.yhjqsw.wm.water.model.WaterUse;

import java.util.List;

/**
 * ---------------------------
 *  (WaterUseService)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-08-05 15:51:05
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface WaterUseService extends CurdService<WaterUse> {
    List<WaterUse> findTree();
}
