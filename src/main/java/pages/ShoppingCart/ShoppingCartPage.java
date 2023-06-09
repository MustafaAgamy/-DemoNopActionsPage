package pages.ShoppingCart;

import Utils.ActionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static Utils.ActionsPage.*;


public class ShoppingCartPage {
    private WebDriver driver;
    private final By productName = By.xpath("//td//a[@class='product-name']");
    private final By productSpecs = By.xpath("//td//div[@class='attributes']");
    private final By quantityNumber = By.xpath("//td//input[@class='qty-input']");
    private final By itemPrice = By.xpath("//td//span[@class='product-unit-price']");
    private final By totalPrice =By.xpath("//td//span[@class='product-subtotal']");
    private final By removeItem = By.xpath("//td[@class='remove-from-cart']");
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }


    public String productName(){
        return getText(driver, productName);
    }
    public String productSpecifications(){
        return getText(driver, productSpecs);
    }
    public String quantityNumber(){
        return moveToElementAndHighLight(driver, quantityNumber).getAttribute("value");}
    public String productPrice(){
        return getText(driver, itemPrice);
    }
    public String totalPrice(){
        return getText(driver, totalPrice);
    }
}
