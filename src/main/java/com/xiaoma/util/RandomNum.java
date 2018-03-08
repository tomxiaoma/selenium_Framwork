package com.xiaoma.util;


import com.xiaoma.log4j.LoggerControler;
import java.util.Random;

/**
 * Created by xiaoma on 2018/1/10.
 */
public class RandomNum {
    private final static LoggerControler logger = LoggerControler.getLoggerControler(RandomNum.class);
    public static long getNumRandom(int length){
        //随机数乘以10^n次方
        long num=0;
        num=(long)(Math.random()*Math.pow(10,length));
        logger.info(String.valueOf(num));
        return num;
    }

    public static long getNumRandom1(int min,int max){
        //如输出一个10~100之间的随机数
        long num=0;
        Random random=new Random();
        num=random.nextInt(max-min+1)+min;
        logger.info(String.valueOf(num));
        return num;
    }
    public static String getStringRandom(int length){
       String val="";
        Random random=new Random();
        for(int i = 0; i<length; i++){
            String charOrNum=random.nextInt(10)%2==0?"char":"num";
            if ("char".equals(charOrNum)){
                int temp=random.nextInt(10)%2==0?65:97;
                val+=(char)(random.nextInt(26)+temp);
            }else if ("num".equals(charOrNum)){
                val+=String.valueOf(random.nextInt(10));
            }
        }
        logger.info(val);
        return val;
    }


}
