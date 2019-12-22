package com.yhjqsw.wm.water.controller;

import java.util.List;

import com.yhjqsw.wm.core.http.HttpResult;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.water.model.WmMonthwaterout;
import com.yhjqsw.wm.water.service.WmMonthwateroutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ---------------------------
 * 月出水水量表：存储月出水水量信息 (WmMonthwateroutController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-29 17:14:13
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("wmMonthwaterout")
public class WmMonthwateroutController {

	@Autowired
	private WmMonthwateroutService wmMonthwateroutService;

	/**
	 * 保存月出水水量表：存储月出水水量信息
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody WmMonthwaterout record) {
		try {
			return HttpResult.ok(wmMonthwateroutService.save(record));
		} catch (Exception e) {
			e.printStackTrace();
			return HttpResult.error(e.getMessage());
		}
	}

    /**
     * 删除月出水水量表：存储月出水水量信息
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<WmMonthwaterout> records) {
		return HttpResult.ok(wmMonthwateroutService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(wmMonthwateroutService.findPage(pageRequest));
	}

    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(wmMonthwateroutService.findById(id));
	}
}
