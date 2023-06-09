package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.FollowUs.FollowUsPage;
import pages.Login.LoginPage;
import pages.Product.ProductPage;
import pages.Register.RegisterPage;
import pages.Search.SearchPage;
import pages.Sliders.SlidersPage;

import java.time.Duration;

import static Utils.ActionsPage.*;


public class HomePage {
    private WebDriver driver;
    private final By registerBtn = By.className("ico-register");
    private final By welcomeMsg = By.xpath("//div[@class=\"topic-block-title\"]//h2");
    private final By loginBtn = By.className("ico-login");
    private final By logoutBtn = By.className("ico-logout");
    private final By searchBar = By.id("small-searchterms");
    private final By searchBtn = By.xpath("//button[@type='submit']");
    private final By addToWishBtn1 = By.xpath("//div[@data-productid='1']//button[@title='Add to wishlist']");
    private final By addToCartBtn1 = By.xpath("//div[@data-productid='1']//button[contains(@class,'add-to-cart')]");
    private final By faceBookBtn = By.xpath("//li[@class='facebook']//a[@target='_blank']");
    private final By twitterBtn = By.xpath("//li[@class='twitter']//a[@target='_blank']");
    private final By youTubeBtn = By.xpath("//li[@class='youtube']//a[@target='_blank']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage clickRegisterBtn() {
        click(driver, registerBtn);

        return new RegisterPage(driver);

    }

    public String getWelcomeMsg() {
        return getText(driver, welcomeMsg);
    }

    public LoginPage clickLoginBtn() {
        click(driver, loginBtn);
        return new LoginPage(driver);
    }

    public HomePage clickLogoutBtn() {
        click(driver, logoutBtn);
        return this;
    }

    public HomePage searchInput(String input) {
        sendKeys(driver, searchBar, input);
        return this;
    }

    public SearchPage clickSearchBtn() {
        click(driver, searchBtn);
        return new SearchPage(driver);
    }
    public ProductPage AddProduct1ToWishBtn() {
        click(driver, addToWishBtn1);
        return new ProductPage(driver);
    }
    public ProductPage AddProduct1ToCartBtn() {
        click(driver, addToCartBtn1);
        return new ProductPage(driver);
    }
    public FollowUsPage clickFaceBookBtn(){
        click(driver, faceBookBtn);
        return new FollowUsPage(driver);
    }
    public FollowUsPage clickTwitterBtn(){
        click(driver, twitterBtn);
        return new FollowUsPage(driver);
    }
    public FollowUsPage clickYouTubeBtn(){
        click(driver, youTubeBtn);
        return new FollowUsPage(driver);
    }

    public SlidersPage switchToSliders(){
        return new SlidersPage(driver);
    }

}
