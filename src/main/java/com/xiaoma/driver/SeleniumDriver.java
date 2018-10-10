package com.xiaoma.driver;

import com.xiaoma.log4j.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by mawentao on 2018/02/06 0006.
 */
public class SeleniumDriver {

   public static WebDriver driver;

    final static LoggerControler logger = LoggerControler.getLoggerControler(SeleniumDriver.class);
    public static WebDriver open(String browser){
        String path = System.getProperty("user.dir");
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",path+"/tools/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\lishasha\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
            driver= new ChromeDriver(options);
        }else if(browser.equals("ie")){
            System.setProperty("webdriver.ie.driver",path+"/tools/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }else {
            System.err.println("你传入的浏览器错误"+browser);
            logger.error("您输入"+browser+"的浏览器错误");
        }
        return driver;
    }

    public static void closeBrower(){
        driver.quit();
    }

}
