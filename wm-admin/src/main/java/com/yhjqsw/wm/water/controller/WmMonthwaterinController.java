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

import com.yhjqsw.wm.water.model.WmMonthwaterin;
import com.yhjqsw.wm.water.service.WmMonthwaterinService;

/**
 * ---------------------------
 * 月入水水量表:存储每一个用户的token信息 (WmMonthwaterinController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("wmMonthwaterin")
public class WmMonthwaterinController {

	@Autowired
	private WmMonthwaterinService wmMonthwaterinService;

	/**
	 * 保存月入水水量表:存储每一个用户的token信息
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody WmMonthwaterin record) {
		try {
			return HttpResult.ok(wmMonthwaterinService.save(record));
		} catch (Exception e) {
			e.printStackTrace();
			return HttpResult.error(e.getMessage());
		}
	}

    /**
     * 删除月入水水量表:存储每一个用户的token信息
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<WmMonthwaterin> records) {
		return HttpResult.ok(wmMonthwaterinService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(wmMonthwaterinService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param deptno
     * @return
     */ 	
//	@GetMapping(value="/findById")
//	public HttpResult findById(@RequestParam String deptno) {
//		return HttpResult.ok(wmMonthwaterinService.findById(deptno));
//	}
}
