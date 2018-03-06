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
        return testcase.testData("F://1a.xlsx");
    }

    @Test(dataProvider = "testData")
    public void testCase(HashMap<String, String> data) {
        String fileName = data.get("excelName");
        String bpSheetName = data.get("Benefits Package Sheet");
        int bpRowNum = Integer.parseInt(data.get("BP sheet RowNum"));
        String csvSheetName = data.get("Cost Share Variances Sheet");
        int csvRowNum = Integer.parseInt(data.get("CSV Sheet RowNum"));
        String hiosPlanID = data.get("HIOS Plan ID");
        String isPass = data.get("isPass");
        System.out.print(fileName);
    }
}
