package com.raxtone.test;

import com.xiaoma.log4j.LoggerControler;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/02/28 0028.
 */
public class TestLog4j {

    final static LoggerControler logger = LoggerControler.getLoggerControler(TestLog4j.class);

    @Test
    public void fun(){

        logger.info("这是info");

        //logger.error("这是error");

    }

}
