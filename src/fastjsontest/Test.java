package fastjsontest;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by user on 2015/12/28.
 */

public class Test {
    public static void main(String[] args) {
        String json = "{\"total\":100,\"rows\":[{\"key\":\"key1\",\"value\":\"value1\"},{\"key\":\"key2\",\"value\":\"value2\"}]}";
        Type type = new TypeToken<B>() {
        }.getType();
        Gson gson = new Gson();
        B b = gson.fromJson(json, type);
        System.out.println(b.getTotal());
        System.out.println(b.getRows().size());
    }

    class A {
        private String key;
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    class B {
        private int total;
        private List<A> rows;

        public int getTotal() {
            return 1;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<A> getRows() {
            return rows;
        }

        public void setRows(List<A> rows) {
            this.rows = rows;
        }
    }
}


