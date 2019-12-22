package com.yhjqsw.wm.water.controller;

import java.util.List;

import com.yhjqsw.wm.core.http.HttpResult;
import com.yhjqsw.wm.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.yhjqsw.wm.water.model.WmOperateRecord;
import com.yhjqsw.wm.water.service.WmOperateRecordService;

/**
 * ---------------------------
 *  (WmOperateRecordController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-08-07 14:58:57
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("wmOperateRecord")
public class WmOperateRecordController {

	@Autowired
	private WmOperateRecordService wmOperateRecordService;

	/**
	 * 保存
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody WmOperateRecord record) {
        try {
            return HttpResult.ok(wmOperateRecordService.save(record));
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResult.error(e.getMessage());
        }
    }

    /**
     * 删除
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<WmOperateRecord> records) {
		return HttpResult.ok(wmOperateRecordService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(wmOperateRecordService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(wmOperateRecordService.findById(id));
	}
}
