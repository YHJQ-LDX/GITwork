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

import com.yhjqsw.wm.water.model.WmNrw;
import com.yhjqsw.wm.water.service.WmNrwService;

/**
 * ---------------------------
 * 产销差表:程序通过后台定时任务计算每个营业所的产销差和产销差率 (WmNrwController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("wmNrw")
public class WmNrwController {

	@Autowired
	private WmNrwService wmNrwService;

	/**
	 * 保存产销差表:程序通过后台定时任务计算每个营业所的产销差和产销差率
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody WmNrw record) {
		try {
			return HttpResult.ok(wmNrwService.save(record));
		} catch (Exception e) {
			e.printStackTrace();
			return HttpResult.error(e.getMessage());
		}
	}

    /**
     * 删除产销差表:程序通过后台定时任务计算每个营业所的产销差和产销差率
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<WmNrw> records) {
		return HttpResult.ok(wmNrwService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(wmNrwService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param metermonth
     * @return
     */ 	
//	@GetMapping(value="/findById")
//	public HttpResult findById(@RequestParam String metermonth) {
//		return HttpResult.ok(wmNrwService.findById(metermonth));
//	}
}
