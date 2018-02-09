package com.xiaoma.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by mawentao on 2018/02/06 0006.
 */
public class SeleniumDriver {

   public static WebDriver driver;

    public static WebDriver open(String browser){
        String path = System.getProperty("user.dir");
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",path+"/tools/chromedriver.exe");
            driver= new ChromeDriver();
        }else if(browser.equals("ie")){
            System.setProperty("webdriver.ie.driver",path+"/tools/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }else {
            System.err.println("你传入的浏览器错误"+browser);
        }
        return driver;
    }

    public static void closeBrower(){
        driver.quit();
    }

}
