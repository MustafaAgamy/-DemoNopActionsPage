package pages.Login;

import Utils.ActionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import static Utils.ActionsPage.*;



public class LoginPage {
    private WebDriver driver;
    private final By pageMsg = By.xpath("//div[@class=\"page-title\"]//h1");
    private final By emailField = By.id("Email");
    private final By passwordField =By.id("Password");
    private final By confLoginBtn = By.xpath("//button[@class=\"button-1 login-button\"]");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageMsg(){
        return ActionsPage.getText(driver, pageMsg);
    }

    public LoginPage fillLoginInfo(String email, String password){
        sendKeys(driver, emailField, email);
        sendKeys(driver, passwordField, password);
        return this;
    }

    public HomePage clickConfLoginBtn(){
       click(driver, confLoginBtn);
       findElement(driver,confLoginBtn);
       driver.findElement(confLoginBtn);
        return new HomePage(driver);
    }

}
