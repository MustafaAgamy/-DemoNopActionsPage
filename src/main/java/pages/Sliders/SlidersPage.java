package pages.Sliders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SlidersPage {
    private WebDriver driver;
    private final By firstSlider = By.xpath("//*[@id=\"nivo-slider\"]/a[1]");
    private final By secondSlider = By.xpath("//*[@id=\"nivo-slider\"]/a[2]");
    private final By firstSliderSwitchBtn = By.xpath("//div[@class='nivo-controlNav']//a[1]");
    private final By secondSliderSwitchBtn = By.xpath("//div[@class='nivo-controlNav']//a[2]");

    public SlidersPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean clickOnSliderSwitchAndCheckActivity() throws InterruptedException {
        boolean assertion = false;
        WebElement firstSlide = findElement(firstSlider);
        WebElement secondSlide = findElement(secondSlider);
        if (firstSlide.isDisplayed() == true) {
            Thread.sleep(2000);
            if (secondSlide.isDisplayed() == true){
                assertion = true;
            }
        }
        return assertion;
    }



    public WebElement findElement(By by) {
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
