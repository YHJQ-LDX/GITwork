package com.yhjqsw.wm.water.controller;

import com.yhjqsw.wm.core.http.HttpResult;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.water.model.WaterMinit;
import com.yhjqsw.wm.water.service.WaterMinitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("waterMinit")
public class WaterMinitController {
    @Autowired
    private WaterMinitService waterMinitService;
    /**
     * 保存月入水水量表:存储每一个用户的token信息
     * @param record
     * @return
     */
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody WaterMinit record) {
        try {
            return HttpResult.ok(waterMinitService.save(record));
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
    public HttpResult delete(@RequestBody List<WaterMinit> records) {
        return HttpResult.ok(waterMinitService.delete(records));
    }

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */
    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(waterMinitService.findPage(pageRequest));
    }


}
