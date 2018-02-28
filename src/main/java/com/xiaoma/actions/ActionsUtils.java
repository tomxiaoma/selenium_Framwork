package com.xiaoma.actions;

import com.xiaoma.driver.SeleniumDriver;
import com.xiaoma.findwait.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/02/06 0006.
 */
public class ActionsUtils extends SeleniumDriver{

    //点击按钮
    public static void clickButtons(By by){
        WebElement element =WebElementUtils.findElement(by);
        element.click();
    }

    //文本框中输入值
    public static void sendKeys(By by,String text){
        WebElement element = WebElementUtils.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    //获取单个文本
    public static String getText(By by){
        String element = driver.findElement(by).getText();
        return element;
    }

    //获取一个list文本
    public static ArrayList<String> getTexts(By by){
        ArrayList<String> al = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(by);
        for (int i=0;i<elements.size();i++){
           String el = elements.get(i).getText();
           al.add(el);
        }
        return al;
    }

    public static void doubleClick(By by){
        Actions actions = new Actions(driver);
        WebElement element = WebElementUtils.findElement(by);
        actions.doubleClick(element);
    }

}
