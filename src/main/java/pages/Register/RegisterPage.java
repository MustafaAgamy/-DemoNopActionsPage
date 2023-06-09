package pages.Register;

import Utils.ActionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static Utils.ActionsPage.*;



public class RegisterPage{
    private WebDriver driver;
    private final By genderMale = By.id("gender-male");
    private final By genderFemale = By.id("gender-female");
    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By birthDayField = By.name("DateOfBirthDay");
    private final By birthMonthField = By.name("DateOfBirthMonth");
    private final By birthYearField = By.name("DateOfBirthYear");
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By confPasswordField = By.id("ConfirmPassword");
    private final By confRegisterBtn = By.id("register-button");


    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public RegisterPage fillRegisterInfoMale(String firstName, String lastName, String day, String month, String year,
                                     String email,String password, String confPassword){

        click(driver, genderMale);
        sendKeys(driver, firstNameField, firstName);
        sendKeys(driver, lastNameField, lastName);
        selectBirthInfo(day, month, year);
        sendKeys(driver, emailField, email);
        sendKeys(driver, passwordField, password);
        sendKeys(driver, confPasswordField, confPassword);

        return this;

    }

    public RegisterPage fillRegisterInfoFeMale(String firstName, String lastName, String day, String month, String year,
                                       String email,String password, String confPassword){


        click(driver, genderFemale);
        sendKeys(driver, firstNameField, firstName);
        sendKeys(driver, lastNameField, lastName);
        selectBirthInfo(day, month, year);
        sendKeys(driver, emailField, email);
        sendKeys(driver, passwordField, password);
        sendKeys(driver, confPasswordField, confPassword);
        return this;

    }

    public RegisterPage selectBirthInfo(String day, String month, String year){

        select(driver, birthDayField, "Value", day);
        select(driver, birthMonthField, "Value", month);
        select(driver, birthYearField, "Value", year);

        return this;
    }

    public RegisterConfirmPage clickConfRegister(){
        click(driver, confRegisterBtn);
        return new RegisterConfirmPage(driver);
    }

}
