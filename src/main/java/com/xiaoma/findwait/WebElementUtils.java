package com.xiaoma.findwait;

import com.xiaoma.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by mawentao on 2018/02/06 0006.
 */
public class WebElementUtils extends SeleniumDriver {


    public static WebElement findElement(final By by){

        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver,10);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("元素"+by+"查找失败");
            e.printStackTrace();
        }
        return driver.findElement(by);
    }

    public static List<WebElement> findElements(By by){
        List<WebElement> element = null;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver,10);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("元素"+by+"查找失败");
            e.printStackTrace();
        }
        return driver.findElements(by);
    }

}
