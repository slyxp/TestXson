package fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by user on 2015/12/28.
 */
public class FastJsonTest {
    public static void main(String[] args){
        String jsonStr = "[{\"JACKIE_ZHANG\":\"张学友\"},{\"ANDY_LAU\":\"刘德华\"},{\"LIMING\":\"黎明\"},{\"Aaron_Kwok\":\"郭富城\"}]" ;
        //做5次测试
        for(int i=0,j=5;i<j;i++)
        {
            JSONArray jsonArray = JSONArray.parseArray(jsonStr);

            for(int k=0;k<jsonArray.size();k++){
                System.out.print(jsonArray.get(k) + "\t");
            }
            System.out.println();
        }
    }
}
