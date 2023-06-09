package pages.Register;

import Utils.ActionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import static Utils.ActionsPage.*;


public class RegisterConfirmPage {
    private WebDriver driver;
    private final By registerMsg = By.className("result");
    private final By continueBtn = By.xpath("//a[@class=\"button-1 register-continue-button\"]");

    public RegisterConfirmPage(WebDriver driver){
        this.driver = driver;
    }

    public String getResultMsg(){
        return getText(driver, registerMsg);
    }

    public HomePage clickContinueBtn(){
        click(driver, continueBtn);

        return new HomePage(driver);
    }
}
