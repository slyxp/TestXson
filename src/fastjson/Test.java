package fastjson;

import com.alibaba.fastjson.JSON;

/**
 * Created by user on 2015/12/28.
 *
 * 简单粗暴版FastJson
 */
public class Test {
    public static void main(String[] args) {
//        String text = "{\"name\":123\"age\":18\"country\":china}";

        User user = new User();
        String jsonString = JSON.toJSONString(user);
        UserGroup userGroup = JSON.parseObject(jsonString, UserGroup.class);
        System.out.println(userGroup);
    }
}

class User {
    private String name;
    private int age;
    private String country;
}

class UserGroup {
    private String name;
    private int age;
}
