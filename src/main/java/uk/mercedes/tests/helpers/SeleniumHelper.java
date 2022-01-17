package uk.mercedes.tests.helpers;

import java.util.List;

import cucumber.api.java.es.E;
import io.github.sukgu.Shadow;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

import static uk.mercedes.tests.drivers.Driver.driver;

/**
 * Common utilities used for Selenium;
 */
public class SeleniumHelper {

    public static int LOW_TIMEOUT = 2;
    public static int MEDIUM_TIMEOUT = 5;

    public static WebElement findShadowElement(String cssSelector) {
        Shadow shadow = new Shadow(driver);
        return shadow.findElement(cssSelector);
    }

    public static List<WebElement> findShadowElements(String cssSelector) {
        Shadow shadow = new Shadow(driver);
        return shadow.findElements(cssSelector);
    }

    public static WebElement findShadowElement(String cssSelector, boolean treatException) {
        WebElement element = null;
        if (!treatException) findShadowElement(cssSelector);
        try {
            Shadow shadow = new Shadow(driver);
            element = shadow.findElement(cssSelector);
        } catch(Exception ignore) {}
        return element;
    }

    public static WebElement findShadowElementByXPath(String xPath) {
        Shadow shadow = new Shadow(driver);
        return shadow.findElementByXPath(xPath);
    }

    public static WebElement findShadowElementByXPath(String xPath, boolean treatException) {
        WebElement element = null;
        if (!treatException) findShadowElementByXPath(xPath);
        try {
            Shadow shadow = new Shadow(driver);
            element = shadow.findElementByXPath(xPath);
        } catch(Exception ignore) {}
        return element;
    }

    public static WebElement findShadowElement(String cssSelector, int timeout) {
        WebElement element;
        long end = System.currentTimeMillis() + timeout*1000;
        while (System.currentTimeMillis() < end) {
            element = findShadowElement(cssSelector, true);
            if (element != null) return element;
        }
        return findShadowElement(cssSelector);
    }

    public static WebElement findShadowElementByXPath(String xPath, int timeout) {
        WebElement element;
        long end = System.currentTimeMillis() + timeout*1000;
        while (System.currentTimeMillis() < end) {
            element = findShadowElementByXPath(xPath, true);
            if (element != null) return element;
        }
        return findShadowElementByXPath(xPath);
    }

    public static void moveToElement(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        } catch(Exception ignore) {}
    }

    public static void moveToElementViewPort(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void moveToElementAndClick(WebElement element) {
        moveToElement(element);
        implicitlyWait(LOW_TIMEOUT);
        element.click();
    }

    public static void takeSnapShot(String fileWithPath) {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(fileWithPath);
            FileUtils.copyFile(srcFile, destFile);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void implicitlyWait(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
