import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

public class TestAllJsonlib {

    public TestAllJsonlib() {
        buildJsonString();
    }

    private void buildJsonString() {
        Group group = new Group();

        for(int i=0;i<200000;i++) {
            User user = new User();

            user.setId(1L);
            user.setName("test" + i);
            user.setVendor("class" + i);
            user.setImageUrl("img/class.png" + i);
            user.setCreator("niles" + i);
            user.setInfo("Test user in group" + i);
            group.addUser(user);
        }
        try {
            System.err.println("start compare...");
            Gson gson = new Gson();

            long t0 = 0;
            long t1 = System.currentTimeMillis();
            String  str = null;

            t0 = t1;
            t1 = System.currentTimeMillis();
            System.err.println("jackson serialize object:" + (t1 - t0));

            t0 = t1;
            str = JSON.toJSONString(group);
            t1 = System.currentTimeMillis();
            System.err.println("fastjson serialize object:" + (t1 - t0));

            t0 = t1;
            str = gson.toJson(group);
            t1 = System.currentTimeMillis();
            System.err.println("Gson serialize object:" + (t1 - t0));

            System.err.println("--------------");

            t0 = t1;
            t1 = System.currentTimeMillis();
            System.err.println("jackson parse object:" + (t1 - t0));

            t0 = t1;
            Group group0 = JSON.parseObject(str,Group.class);
            t1 = System.currentTimeMillis();
            System.err.println("fastjson parse object:" + (t1 - t0));

            t0 = t1;
            Group group1 = gson.fromJson(str, Group.class);
            t1 = System.currentTimeMillis();
            System.err.println("Gson parse object:" + (t1 - t0));


        } catch(Exception ex) {
            ex.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new TestAllJsonlib();
    }

}


class User {

    private Long id;
    private String name;
    private String vendor;
    private String imageUrl;
    private String creator;
    private String info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}

class Group {
    private Map<String,User> users = new Hashtable<String,User>();

    private Date updateTime = null;
    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }

    public Map<String,User> getUsers() { return users; }
    public void setUsers(Map<String,User> users) { this.users = users; }

    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    public User getUser(String name) {
        return users.get(name);
    }
}