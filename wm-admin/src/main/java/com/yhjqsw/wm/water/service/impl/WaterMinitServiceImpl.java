package com.yhjqsw.wm.water.service.impl;

import com.yhjqsw.wm.core.page.ColumnFilter;
import com.yhjqsw.wm.core.page.MybatisPageHelper;
import com.yhjqsw.wm.core.page.PageRequest;
import com.yhjqsw.wm.core.page.PageResult;
import com.yhjqsw.wm.water.dao.WaterMinitMapper;
import com.yhjqsw.wm.water.model.WaterMinit;
import com.yhjqsw.wm.water.service.WaterMinitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WaterMinitServiceImpl implements WaterMinitService {
    @Autowired
    private WaterMinitMapper waterMinitMapper;

    @Override
    public int save(WaterMinit record) throws Exception {

            if(record.getId() == null || record.getId() == 0){
                int count = waterMinitMapper.selectCountByPrimaryKey(record);
                if(count >0){
                    throw new Exception("记录已存在，请勿重复添加");

                }else {
                    return waterMinitMapper.add(record);
                }
            }
            return waterMinitMapper.update(record);





    }

    @Override
    public int delete(WaterMinit record) {
        return waterMinitMapper.delete(record.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(List<WaterMinit> records) {
        for(WaterMinit record:records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public WaterMinit findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        String watermno = getColumnFilterValue(pageRequest, "watermno");
        return MybatisPageHelper.findPage(pageRequest, waterMinitMapper,"findPage", watermno);
    }
    /**
     * 获取过滤字段的值
     * @param filterName
     * @return
     */
    public String getColumnFilterValue(PageRequest pageRequest, String filterName) {
        String value = null;
        ColumnFilter columnFilter = pageRequest.getColumnFilter(filterName);
        if(columnFilter != null) {
            value = columnFilter.getValue();
        }else{
            value = "";
        }
        return value;
    }

}
