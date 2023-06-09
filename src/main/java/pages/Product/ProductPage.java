package pages.Product;

import Utils.ActionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ShoppingCart.ShoppingCartPage;
import pages.WishList.WishListPage;
import static Utils.ActionsPage.*;

import java.util.Iterator;
import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private final By productTag = By.xpath("//li[@class='tag']");
    private final By ramOptionsList =By.id("product_attribute_2");
    private final By hddCheckBox = By.id("product_attribute_3_7");
    private final By osCheckBox = By.id("product_attribute_4_9");
    private final By softwareCheckBox = By.id("product_attribute_5_11");
    private final By addToWishListBtn = By.xpath("//button[@id='add-to-wishlist-button-1']");
    private final By addToCartBtn = By.xpath("//button[@id='add-to-cart-button-1']");
    private final By successMsg = By.xpath("//div[@class='bar-notification success']//p");
    private final By closeSuccessMsg = By.xpath("//span[@class='close']");
    private final By wishListPageBtn = By.xpath("//span[@class='wishlist-label']");
    private final By wishItemsQuantity = By.xpath("//span[@class='wishlist-qty']");
    private final By cartItemsQuantity = By.xpath("//span[@class='cart-qty']");
    private final By cartPageBtn = By.xpath("//span[@class='cart-label']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @Steps to Compare search results with their Tags
     * In case you want more advanced search options
     */
    public boolean switchToTabAndCompareProductsTags(String searchTag1, String searchTag2, String searchTag3) {
        var mainWindow = driver.getWindowHandle();
        var newWindows = driver.getWindowHandles();
        boolean assertion = false;
        Iterator<String> iterator = newWindows.iterator();
        while(iterator.hasNext())
            {
            String newWindow=iterator.next();
            if(!mainWindow.equals(newWindow)){
                driver.switchTo().window(newWindow);
                List<WebElement> productsTags = moveToMultipleElementsAndHighLight(driver, productTag);
                String tags;
                for (WebElement productTags : productsTags) {
                    tags = productTags.getText();
                    if (tags.contains(searchTag1) || tags.contains(searchTag2) || tags.contains(searchTag3)) {
                       assertion = true;
                       break;
                    }
                }
            }
        }
        return assertion;
    }
    /**
     * @Steps to Add new Item to WishList or Cart
     * And Confirm it's Added
     */
    public ProductPage fillInfoAndAddForProduct1(){
        select(driver, ramOptionsList, "Value", "4");
        click(driver, hddCheckBox);
        click(driver, osCheckBox);
        click(driver, softwareCheckBox);

        return this;
    }
    public ProductPage clickAddToWishBtn(){
        click(driver, addToWishListBtn);

        return this;
    }
    public ProductPage clickAddToCartBtn(){
        click(driver, addToCartBtn);

        return this;
    }
    public String successMsgText(){
        return getText(driver, successMsg);
    }
    public ProductPage closeSuccessMsg(){
        click(driver, closeSuccessMsg);

        return this;
    }
    public String getWishItemsQuantity(){
        return getText(driver, wishItemsQuantity);
    }
    public String getCartItemsQuantity(){
        return getText(driver, cartItemsQuantity);
    }
    public WishListPage clickWishListPageBtn(){
        click(driver, wishListPageBtn);

        return new WishListPage(driver);
    }
    public ShoppingCartPage clickCartPageBtn(){
        click(driver, cartPageBtn);

        return new ShoppingCartPage(driver);
    }
}
