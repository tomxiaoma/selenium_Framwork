package com.raxtone.test;

import com.xiaoma.util.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/03/05 0005.
 */
public class TestDemo {

   /* public static int foo(int i){
        if(i<=0)
            return 0;
        else if(i>0 && i<=2)
            return 1;
        return foo(i-1) + foo(i-2);
    }

    @Test
    public void fun(){
        int s = TestDemo.foo(6);
        System.out.print(s);
    }*/

    @DataProvider(name = "testData")
    public Object[][] data() {
        ExcelUtil testcase = new ExcelUtil();
        return testcase.testData("F:\\a.xlsx");
    }

    @Test(dataProvider = "testData")
    public void testCase(HashMap<String, String> data) {
        System.out.println(data.get("acct"));
        System.out.println(data.get("pwd"));
    }
}
