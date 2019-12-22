package com.yhjqsw.wm.water.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.yhjqsw.wm.admin.util.SecurityUtils;
import com.yhjqsw.wm.common.utils.Base64Utils;
import com.yhjqsw.wm.core.http.HttpResult;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.water.model.WmOperateRecord;
import com.yhjqsw.wm.water.service.WmOperateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.yhjqsw.wm.water.model.WmDaywaterin;
import com.yhjqsw.wm.water.service.WmDaywaterinService;

/**
 * ---------------------------
 * 入水水量表:存储入水水量信息 (WmDaywaterinController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-07-16 16:38:03
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("wmDaywaterin")
public class WmDaywaterinController {

	@Autowired
	private WmDaywaterinService wmDaywaterinService;

    /**
     * 上传图片
     *
     */
	@PreAuthorize("hasAuthority('sys:wmDaywaterin:add') AND hasAuthority('sys:wmDaywaterin:edit')")
    @RequestMapping("/upload")
	public HttpResult uploadImage(@RequestBody String record) throws IOException {
        Resource resource = new ClassPathResource("Images");
        String filePath = resource.getFile().getPath();

        System.out.println("path2 = " + filePath);
        JSONObject jobj = JSONObject.parseObject(record);
        String img_base64= jobj.getString("imgBase64");
        String userCode = jobj.getString("userCode");
        String imgString = img_base64.replaceAll("data:image/jpeg;base64,","");
        filePath = filePath + "\\"+userCode+".jpg";
        return HttpResult.ok(Base64Utils.GenerateImage(imgString,filePath));
    }

	/**
	 * 保存入水水量表:存储入水水量信息
	 * @param record
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:wmDaywaterin:add') AND hasAuthority('sys:wmDaywaterin:edit')")
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody WmDaywaterin record) {
		try{
			wmDaywaterinService.save(record);
		}catch (Exception e){
			e.printStackTrace();
			return HttpResult.error(e.getMessage());
		}
		return HttpResult.ok();
	}

    /**
     * 删除入水水量表:存储入水水量信息
     * @param records
     * @return
     */
	@PreAuthorize("hasAuthority('sys:wmDaywaterin:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<WmDaywaterin> records) {
		try{
			wmDaywaterinService.delete(records);
		}catch (Exception e){
			e.printStackTrace();
			return HttpResult.error(e.getMessage());
		}
		return HttpResult.ok();
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */
	@PreAuthorize("hasAuthority('sys:wmDaywaterin:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
//		HttpResult httpresult = new HttpResult();
//		try{
//			httpresult =  HttpResult.ok(wmDaywaterinService.findPage(pageRequest));
//		}catch (Exception e){
//			e.printStackTrace();
//			return HttpResult.error(e.getMessage());
//		}
//
//		return httpresult;
		return HttpResult.ok(wmDaywaterinService.findPage(pageRequest));
	}

	@PreAuthorize("hasAuthority('sys:wmDaywaterin:view')")
	@PostMapping(value="/findSubmitPage")
	public HttpResult findSubmitPage(@RequestBody PageRequest pageRequest) {
//		HttpResult httpresult = new HttpResult();
//		try{
//			httpresult =  HttpResult.ok(wmDaywaterinService.findPage(pageRequest));
//		}catch (Exception e){
//			e.printStackTrace();
//			return HttpResult.error(e.getMessage());
//		}
//
//		return httpresult;
		return HttpResult.ok(wmDaywaterinService.findSubmitPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param
     * @return
     */ 	
//	@GetMapping(value="/findById")
//	public HttpResult findById(@RequestParam java.util.Date meterdate) {
//		return HttpResult.ok(wmDaywaterinService.findById(meterdate));
//	}
//	@PreAuthorize("hasAuthority('sys:wmDaywaterin:view')")
	@PostMapping(value="/commit")
	public HttpResult commit(@RequestBody List<WmDaywaterin> records) {

		return HttpResult.ok(wmDaywaterinService.updateCommitflag(records));
	}

	@PostMapping(value="/apply")
	public HttpResult apply(@RequestBody List<WmDaywaterin> records) {

		return HttpResult.ok(wmDaywaterinService.updateApplyFlag(records));
	}

	@PostMapping(value="/reject")
	public HttpResult updatereject(@RequestBody List<WmDaywaterin> records) {

		return HttpResult.ok(wmDaywaterinService.updatereject(records));
	}

	@PostMapping(value="/check")
	public HttpResult check(@RequestBody List<WmDaywaterin> records) {

		return HttpResult.ok(wmDaywaterinService.updateCheckFlag(records));
	}




}
