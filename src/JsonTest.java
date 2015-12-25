import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {

    /**
     * 构造Json数据
     */
    public static String BuildJson() {

        // JSON格式数据解析对象
        JSONObject jsonObject = new JSONObject();

        // 下面构造两个map、一个list和一个Employee对象
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("name", "GuanYu");
        map1.put("sex", "male");
        map1.put("age", "60");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "ZhangFei");
        map2.put("sex", "male");
        map2.put("age", "58");
        map2.put("test", "test");

        List<Map> list = new ArrayList<Map>();
        list.add(map1);
        list.add(map2);

        Employee employee = new Employee();
        employee.setName("LiuBei");
        employee.setSex("male");
        employee.setAge(62);

        // 将Map转换为JSONArray数据
        JSONArray jsonArray1 = JSONArray.fromObject(map1);
        // 将List转换为JSONArray数据
        JSONArray jsonArray2 = JSONArray.fromObject(list);
        // 将Bean转换为JSONArray数据
        JSONArray jsonArray3 = JSONArray.fromObject(employee);

        System.out.println("JSONArray对象数据格式：");
        System.out.println(jsonArray1.toString());
        System.out.println(jsonArray2.toString());
        System.out.println(jsonArray3.toString());

        // 构造Json数据，包括一个map和一个Employee对象
        jsonObject.put("map", jsonArray1);
        jsonObject.put("employee", jsonArray2);
        System.out.println("\n最终构造的JSON数据格式：");
        System.out.println(jsonObject.toString());

        return jsonObject.toString();

    }

    /**
     * 解析Json数据
     *
     * @param jsonString Json数据字符串
     */
    public static void ParseJson(String jsonString) {

        // 以employee为例解析，map类似
        JSONObject jsonObject1 = JSONObject.fromObject(jsonString);
        JSONArray jsonArray0 = jsonObject1.getJSONArray("employee");

        List<Employee> empList = new ArrayList<Employee>();

        // 循环添加Employee对象（可能有多个）
        for (int i = 0; i < jsonArray0.size(); i++) {
            Employee employee = new Employee();

            employee.setName(jsonArray0.getJSONObject(i).getString("name"));
            employee.setSex(jsonArray0.getJSONObject(i).getString("sex"));
            employee.setAge(jsonArray0.getJSONObject(i).getInt("age"));

            empList.add(employee);
        }

        System.out.println("\n将Json数据转换为Employee对象：");
        for (int i = 0; i < empList.size(); i++) {
            Employee emp = empList.get(i);
            System.out.println("name: " + emp.getName() + " sex: " + emp.getSex() + " age: " + emp.getAge());
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        ParseJson(BuildJson());
    }

}