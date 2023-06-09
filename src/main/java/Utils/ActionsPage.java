package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ActionsPage {
    /**
     * @Info This page contains actions you can use in your pages
     * If you want to include it in your pages do one of the following:
     * 1- make the methods static
     * 2- make page classes extend it
     */

    public static String getText(WebDriver driver, By locator) {

        return moveToElementAndHighLight(driver, locator).getText();
    }

    public static void click(WebDriver driver, By locator) {

        moveToElementAndHighLight(driver, locator).click();
    }

    public static void clear(WebDriver driver, By locator) {

        moveToElementAndHighLight(driver, locator).clear();
    }

    public static void sendKeys(WebDriver driver, By locator, String value) {

        moveToElementAndHighLight(driver, locator).sendKeys(value);
    }

    public static void select(WebDriver driver, By locator, String selectBy, String selection){
        Select select = new Select
                (moveToElementAndHighLight(driver, locator));
        if(selectBy.equalsIgnoreCase("Value")){
            select.selectByValue(selection);}
        else if (selectBy.equalsIgnoreCase("Index")){
            select.selectByIndex(Integer.parseInt(selection));}
        else if (selectBy.equalsIgnoreCase("VisibleText")) {
            select.selectByVisibleText(selection);}
        else{
            try {
                throw new CustomException("The entered selectBy is not a valid Select");
            } catch (CustomException e) {
                throw new RuntimeException(e);
            }
        }
        wait(driver, 400);
    }

    public static void dragAndDrop(WebDriver driver, By firstLocator, By secondLocator){
        Actions actions = new Actions(driver);
        WebElement firstWebElement = moveToElementAndHighLight(driver, firstLocator);
        WebElement secondWebElement = moveToElementAndHighLight(driver, secondLocator);
        actions.clickAndHold(firstWebElement).pause(300).moveToElement(secondWebElement).pause(300).release().build().perform();
        wait(driver, 700);
    }

    public static Actions clickAndHold(WebDriver driver, By locator){
        Actions actions = new Actions(driver);
        WebElement webElement = moveToElementAndHighLight(driver, locator);
        return actions.clickAndHold(webElement);
    }

    public static void switchToFrame(WebDriver driver, By frame){
        WebElement webElement = moveToElementAndHighLight(driver, frame);
        driver.switchTo().frame(webElement);
    }

    public static void highLightWindow(WebDriver driver){
        String window = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(window)) {
                // Switch to the target window and highlight it
            driver.switchTo().window(windowHandle);
            wait(driver, 800);
            ((JavascriptExecutor) driver).executeScript("alert('This is the target window');");
            wait(driver, 800);
            driver.switchTo().alert().accept();
//                driver.switchTo().defaultContent();
            }
        }
    }

    public static WebElement moveToElementAndHighLight(WebDriver driver, By locator) {
        WebElement webElement = findElement(driver, locator);

        executeJavascript
                (driver, webElement,"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", 600 );

        executeJavascript
                (driver, webElement, "arguments[0].style.border= '3px solid red'", 200);

        executeJavascript
                (driver, webElement, "arguments[0].style.border=''", 200);

        return webElement;
    }

    public static void moveToWebElementAndHighLight(WebDriver driver, WebElement webElement) {

        executeJavascript
                (driver, webElement,"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", 600 );

        executeJavascript
                (driver, webElement, "arguments[0].style.border= '3px solid red'", 200);

        executeJavascript
                (driver, webElement, "arguments[0].style.border=''", 200);
    }

    public static List <WebElement> moveToMultipleElementsAndHighLight(WebDriver driver, By locator) {
        List<WebElement> webElements = findElements(driver, locator);

        for(int i = 0; i < webElements.size(); i++) {
            executeJavascript
                    (driver, webElements.get(i), "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", 600);

            executeJavascript
                    (driver, webElements.get(i), "arguments[0].style.border= '3px solid red'", 200);

            executeJavascript
                    (driver, webElements.get(i), "arguments[0].style.border=''", 200);
        }
        return webElements;
    }

    public static void moveToMultipleWebElementsAndHighLight(WebDriver driver, List<WebElement> webElements) {

        for(int i = 0; i < webElements.size(); i++) {
            executeJavascript
                    (driver, webElements.get(i), "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", 600);

            executeJavascript
                    (driver, webElements.get(i), "arguments[0].style.border= '3px solid red'", 200);

            executeJavascript
                    (driver, webElements.get(i), "arguments[0].style.border=''", 200);
        }
    }

    public static WebElement findElement(WebDriver driver, By by) {
        var wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static List<WebElement> findElements(WebDriver driver, By locator){
        var wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static WebDriver wait(WebDriver driver, int time){
        synchronized (driver) {
            try {
                driver.wait(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }
    public static void executeJavascript(WebDriver driver, WebElement element, String script, int time) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        wait(driver,time);
        executor.executeScript(script, element);

    }
}


