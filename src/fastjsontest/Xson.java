package fastjsontest;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015/12/24.
 */
public class Xson {
    List list = new ArrayList();
    public void add() {

        int i = 0;
        Employee employee = null;
        while (i < 10) {
            employee = new Employee();
            employee.setAge(i);
            employee.setName("CaoCao" + i);
            employee.setNumber("" + i);
            list.add(employee);
            i ++;
        }
    }

    public void FastJsonTest() {
        long s = System.currentTimeMillis(); // 获取当前系统毫秒数
        System.out.println("Fast Json开始时间:" +s);
        String aliJson = com.alibaba.fastjson.JSON.toJSONString(list);
        long e = System.currentTimeMillis();
        System.out.println("Fast Json结束时间:" +e);
        System.out.println("Fast Json耗时（毫秒）:" + (e-s));
        list = null;
        long s3 = System.currentTimeMillis();
        List sult = (List) com.alibaba.fastjson.JSONObject.parse(aliJson);
        long e3 = System.currentTimeMillis();
//        System.out.println("反 diff:" + (e3-s3));
    }

    public void GsonTest() {
        long s1 = System.currentTimeMillis();
        System.out.println("Gson 开始时间:" + s1);
        Gson gson = new Gson();
        String gsonStr = gson.toJson(list);
        long e1 = System.currentTimeMillis();
        System.out.println("Gson 结束时间:" + e1);
        System.out.println("Gson 耗时（毫秒）:" + (e1-s1));
        list = null;
        long s4 = System.currentTimeMillis();
        List sult2 = gson.fromJson(gsonStr,List.class);
        long e4 = System.currentTimeMillis();
//        System.out.println("反 diff:" + (e4-s4));
    }
}
