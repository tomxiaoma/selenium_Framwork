package com.xiaoma.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2018/02/28 0028.
 */
public class LoggerControler {

    private static Logger logger = null;
    private static LoggerControler loggerControler = null;

    public static LoggerControler getLoggerControler(Class<?> T){
        if(null == logger){
            Properties properties = new Properties();
            try {
                String path = System.getProperty("user.dir");
                String filePath = path+"/configs/log4j.properties";
                InputStream is = new FileInputStream(filePath);
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PropertyConfigurator.configure(properties);
            logger= Logger.getLogger(T);
            loggerControler = new LoggerControler();
        }
        return loggerControler;
    }

    public void info(String msg){
        logger.info(msg);
    }

    public void error(String msg){
        logger.error(msg);
    }

    public void debug(String msg){
        logger.debug(msg);
    }

    public void warn(String msg){
        logger.warn(msg);
    }






}
