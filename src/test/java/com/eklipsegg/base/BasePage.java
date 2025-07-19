package com.eklipsegg.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage {

    public WebDriver webDriver;
    public Wait<WebDriver> wait;
    public JavascriptExecutor js;

    public BasePage(WebDriver webDriver, Wait<WebDriver> wait) {
        
        this.webDriver = webDriver;
        this.wait = wait;
        this.js = (JavascriptExecutor) webDriver;
    }
    
}
