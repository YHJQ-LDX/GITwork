package com.yhjqsw.wm.common.aspect;

import com.yhjqsw.wm.admin.util.SecurityUtils;
import com.yhjqsw.wm.water.model.WmDaywaterin;
import com.yhjqsw.wm.water.model.WmOperateRecord;
import com.yhjqsw.wm.water.service.WmOperateRecordService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.Date;

@Aspect
@Component
@Configuration
public class OperateRecordAspect {
    @Autowired
    private WmOperateRecordService wmOperateRecordService;
    //        @Pointcut("execution(* com.yhjqsw.wm.water.service.WmDaywaterinService.update*(..))")
    public void daoDaywaterinUpdate(){
    }
    //        @Around("daoDaywaterinUpdate()")
    public Object doAroundUpdate(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        saveOperateRecord(point);
        return result;
    }
    private void saveOperateRecord(ProceedingJoinPoint joinPoint){
        String userName = SecurityUtils.getUsername();
        WmOperateRecord wmOperateRecord=new WmOperateRecord();
        wmOperateRecord.setOperateModule("日入水量");//模块
        wmOperateRecord.setOperateModuleRecordId(getModuleRecordId(joinPoint));//数据ID
        wmOperateRecord.setOperateType(getType(joinPoint));//操作类型
        wmOperateRecord.setOperateTime(new Date());//操作时间
        wmOperateRecord.setOperateUser(userName);//操作人员
        try {
            wmOperateRecordService.save(wmOperateRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String getType(ProceedingJoinPoint joinPoint){
        String mothedname= joinPoint.getSignature().getName();
        String mn= mothedname.substring(6,8);
        if(mn.equals("Co")){
            return "提交";
        }else if(mn.equals("Ap")){
            return "申请修改";
        }else if(mn.equals("re")){
            return "驳回";
        }
        return "审核";
    }

    private Long getModuleRecordId(ProceedingJoinPoint joinPoint){
        Object[] args =joinPoint.getArgs();
        try {
            WmDaywaterin wmDaywaterin =(WmDaywaterin)(((ArrayList)args[0]).get(0));
            System.out.println("==================================="+wmDaywaterin.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}


