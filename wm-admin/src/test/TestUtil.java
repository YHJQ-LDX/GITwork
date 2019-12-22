

import com.yhjqsw.wm.common.WMAdminApplication;
import com.yhjqsw.wm.water.dao.WmDaywaterinMapper;
import com.yhjqsw.wm.water.dao.WmMonthwaterinMapper;
import com.yhjqsw.wm.water.dao.WmMonthwateroutMapper;
import com.yhjqsw.wm.water.dao.WmNrwMapper;
import com.yhjqsw.wm.water.model.WmMonthwaterin;

import com.yhjqsw.wm.water.model.WmMonthwaterout;
import com.yhjqsw.wm.water.model.WmNrw;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WMAdminApplication.class)
public class TestUtil {

    @Autowired
    private WmDaywaterinMapper wmDaywaterinMapper;

    @Autowired
    private WmMonthwaterinMapper wmMonthwaterinMapper;

    @Autowired
    private WmMonthwateroutMapper wmMonthwateroutMapper;

    @Autowired
    private WmNrwMapper wmNrwMapper;

    @Value("${server.port}")
    public String port;
//    @Value("${server.corn}")
//    public String corn;

    @Test
   public void testdate(){
        DateFormat df = new SimpleDateFormat("YYYY-MM");// 多态
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = (Date) calendar.getTime();
        String format = df.format(date);
        System.out.println("================>>>>"+format);
    }

    @Test
    public void test2(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String ZUOTIAN=sp.format(d);//获取昨天日期
        System.out.println("=======>>>>ZUOTIAN"+ZUOTIAN);
    }

    @Test
    public void test3(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
//        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String day = format.format(m);
        String mon = format2.format(m);
        System.out.println("当前月："+day);
        System.out.println("当前月："+mon);
        c.add(Calendar.MONTH, -1);
        m = c.getTime();
        String preday = format.format(m);
        String premon = format2.format(m);
        System.out.println("过去一个月："+preday);
        System.out.println("过去一个月："+premon);


        System.out.println("===============================================");
        List<Map<String, Object>> result = wmDaywaterinMapper.selectMonthWaterIn(preday,day);
        System.out.println(result.toString());

        for (int i = 0; i< result.size() ; i++) {
            Map<String, Object> map = result.get(i);
            String deptno = map.get("deptno").toString();
            String deptname = map.get("deptname").toString();
            Double db = Double.valueOf(map.get("monthwaterin").toString());
            BigDecimal monthwaterin = BigDecimal.valueOf(db);

            System.out.println("deptno="+deptno);
            System.out.println("deptname="+deptname);
            System.out.println("monthwaterin="+monthwaterin);

            WmMonthwaterin record = new WmMonthwaterin();
            record.setDeptno(deptno);
            record.setDeptname(deptname);
            record.setWaterin(monthwaterin);
            record.setMetermonth(mon);
            record.setCreatetime(new Date());

            int count = wmMonthwaterinMapper.selectCountByPrimaryKey(record);
            if(count >0){
                record.setCreatetime(null);
                record.setLastupdatetime(new Date());
                wmMonthwaterinMapper.update(record);
            }else{
                wmMonthwaterinMapper.add(record);
            }
        }

        // 计算公司总的产销差
        BigDecimal totalMonthWaterIn = BigDecimal.valueOf(0);
        BigDecimal totalMonthWaterOut = BigDecimal.valueOf(0);
        // 读取月入水和出水量，并计算产销差
        List<WmMonthwaterin> monthInList =  wmMonthwaterinMapper.findByMonth(mon);
        for (int i = 0; i <monthInList.size() ; i++) {

            String waterInDeptno = monthInList.get(i).getDeptno();
            BigDecimal waterIn = monthInList.get(i).getWaterin();
            totalMonthWaterIn = totalMonthWaterIn.add(waterIn);

            List<WmMonthwaterout> wmMonthwateroutList = wmMonthwateroutMapper.findByDeptAndMeterMonth(waterInDeptno,mon);
            BigDecimal waterOut = BigDecimal.valueOf(0);
            for (int j = 0; j <wmMonthwateroutList.size() ; j++) {
                waterOut = waterOut.add(wmMonthwateroutList.get(j).getWaterout());
            }
            totalMonthWaterOut = totalMonthWaterOut.add(waterOut);
            // 计算产销差
            BigDecimal nrw = waterIn.subtract(waterOut);
            BigDecimal nrwRate = nrw.divide(waterIn,4, RoundingMode.HALF_UP);
            System.out.println("=======================>>>>nrw="+nrw);
            System.out.println("=======================>>>nrwRate"+nrwRate);
            WmNrw wmNrw = new WmNrw();
            wmNrw.setDeptno(waterInDeptno);
            wmNrw.setDeptname(monthInList.get(i).getDeptname());
            wmNrw.setMetermonth(mon);
            wmNrw.setMonthout(waterOut);
            wmNrw.setMonthin(waterIn);
            wmNrw.setNrw(nrw);
            wmNrw.setNrwrate(nrwRate);
            wmNrw.setCreatetime(new Date());

            int count1 = wmNrwMapper.selectCountByPrimaryKey(waterInDeptno,mon);
            System.out.println("=======================>>>>count="+count1);
            if(count1>0){
                wmNrw.setCreatetime(null);
                wmNrw.setLastupdatetime(new Date());
                wmNrwMapper.update(wmNrw);
            }else{
                wmNrwMapper.add(wmNrw);
            }
        }

        // 计算公司总的产销差
        BigDecimal totalnrw = totalMonthWaterIn.subtract(totalMonthWaterOut);
        BigDecimal totalnrwRate = totalnrw.divide(totalMonthWaterIn,4, RoundingMode.HALF_UP);

        WmNrw toalwmNrw = new WmNrw();
        toalwmNrw.setDeptno("1");
        toalwmNrw.setDeptname("城阳水务");
        toalwmNrw.setMetermonth(mon);
        toalwmNrw.setMonthout(totalMonthWaterOut);
        toalwmNrw.setMonthin(totalMonthWaterIn);
        toalwmNrw.setNrw(totalnrw);
        toalwmNrw.setNrwrate(totalnrwRate);
        toalwmNrw.setCreatetime(new Date());
        toalwmNrw.setRemark("公司本月合计");

        int count1 = wmNrwMapper.selectCountByPrimaryKey("1",mon);
        System.out.println("=======================>>>>count="+count1);
        if(count1>0){
            toalwmNrw.setCreatetime(null);
            toalwmNrw.setLastupdatetime(new Date());
            wmNrwMapper.total_update(toalwmNrw);
        }else{
            wmNrwMapper.total_add(toalwmNrw);
        }
    }


    @Test
    public void test35(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取前月的第一天
        Calendar   cal_1=Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String firstDay = format.format(cal_1.getTime());
        System.out.println("-----1------firstDay:"+firstDay);

        //获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天
        String lastDay = format.format(cale.getTime());
        System.out.println("-----2------lastDay:"+lastDay);

        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());
        System.out.println("===============first:"+first);

        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        System.out.println("===============last:"+last);
    }

    @Test
    public void test36(){

        System.out.println("=================>>>port="+port);
//        System.out.println("==================>>>>corn="+corn);
    }

}
