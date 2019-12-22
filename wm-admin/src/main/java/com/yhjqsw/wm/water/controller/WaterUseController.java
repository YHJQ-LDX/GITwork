package com.yhjqsw.wm.water.controller;


import com.yhjqsw.wm.core.http.HttpResult;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.water.model.WaterUse;
import com.yhjqsw.wm.water.service.WaterUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * ---------------------------
 *  (WaterUseController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-08-05 15:51:05
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("waterUse")
public class WaterUseController {

	@Autowired
	private WaterUseService waterUseService;

	/**
	 * 保存
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody WaterUse record) {
		try {
			return HttpResult.ok(waterUseService.save(record));
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
	public HttpResult delete(@RequestBody List<WaterUse> records) {
		try{
			return HttpResult.ok(waterUseService.delete(records));
		}catch (Exception e){
			return HttpResult.error(e.getMessage());
		}
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		try{
			return HttpResult.ok(waterUseService.findPage(pageRequest));
		}catch (Exception e){
			return HttpResult.error(e.getMessage());
		}

	}

	@PostMapping(value="/findTree")
	public HttpResult findAll() {
		try{
			return HttpResult.ok(waterUseService.findTree());
		}catch (Exception e){
			return HttpResult.error(e.getMessage());
		}

	}

    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		try{
			return HttpResult.ok(waterUseService.findById(id));
		}catch (Exception e){
			return HttpResult.error(e.getMessage());
		}

	}
}
