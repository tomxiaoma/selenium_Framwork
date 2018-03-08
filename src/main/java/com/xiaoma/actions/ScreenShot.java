package com.xiaoma.actions;

import com.xiaoma.driver.SeleniumDriver;
import com.xiaoma.log4j.LoggerControler;
import com.xiaoma.util.DateFormat;
import com.xiaoma.util.MyFile;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import java.io.File;
import java.io.IOException;


/**
 * Created by xiaoma on 2018/2/12.必须要继承SeleniumDrivers
 */
public class ScreenShot extends SeleniumDriver{
   private final static LoggerControler logger = LoggerControler.getLoggerControler(ActionsUtils.class);
    static String path = System.getProperties().getProperty("user.dir") + "/error/";
    /**
     * 错误截图，通过日期命名的截图
     **/
    public static void screenShots() {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
          //根据日期创建文件夹，CHECK_LOG_FORMAT = "yyyyMMdd";REPORT_CSV_FORMAT = "yyyyMMdd_HHmmss";
        MyFile myFile=new MyFile();
        String myPath=path+String.valueOf(System.currentTimeMillis());
        System.out.print(myPath);
        myFile.createFile1(myPath);
        try {
            //FileUtils.copyFile(file,new File("D:\\testing\\webdriver_demo\\aa.jpg"));
            //FileUtils.copyFile(file,new File("D:\\testing\\webdriver_demo\\"+DateFormat.format(DateFormat.CHECK_LOG_FORMAT)+".jpg"));
            String times= String.valueOf(System.currentTimeMillis());
            FileUtils.copyFile(file,new File(myPath + "/" +times+".jpg"));
          // FileUtils.copyFile(file,new File(myPath + "/" + DateFormat.format(DateFormat.REPORT_CSV_FORMAT) + ".png"));
        } catch (IOException e) {
            logger.warn("截图失败！！");
            e.printStackTrace();
        }
    }
    /**
     * 错误截图,通过传入name来给截图命名
     **/
    public static void screenShots1(String name) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        try {
            MyFile myFile = new MyFile();
            myFile.createFile1(path + DateFormat.format(DateFormat.CHECK_LOG_FORMAT));
            logger.info(DateFormat.format(DateFormat.ZH_DATE_FORMAT));
            FileUtils.copyFile(file,new File(path + DateFormat.format(DateFormat.CHECK_LOG_FORMAT) + "/" + name + ".jpg"));
        } catch (IOException e) {
            logger.warn("截图失败！！");
            e.printStackTrace();
        }
    }
}
