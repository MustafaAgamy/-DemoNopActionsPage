package pages.Search;

import Utils.ActionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Product.ProductPage;

import static Utils.ActionsPage.*;
import java.util.List;
import java.util.Locale;

public class SearchPage {
    private WebDriver driver;
    private final By productsTitle = By.xpath("//h2[@class='product-title']");
    private final By searchBar = By.xpath("//input[@id='q']");
    private final By productLink = By.xpath("//h2[@class='product-title']//a");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * @Steps to search for item
     * And Confirm the results contain the searched word
     * if you want more advanced search with tags use method 2 in your test
     */
    public boolean searchResultsIfContainTheWord(){
        boolean productContainsTheWord = true;
        String searched = moveToElementAndHighLight(driver, searchBar).getAttribute("value");
        List<WebElement> searchResults = moveToMultipleElementsAndHighLight(driver, productsTitle);
        for(int i = 0; i < searchResults.size(); i++){
            if(!searchResults.get(i).getText().toLowerCase(Locale.ROOT).contains(searched.toLowerCase())){
                productContainsTheWord = false;
                break;
            }
        }
        return productContainsTheWord;
    }

    /**
     * @Steps to search for item
     * And Confirm the results contain the searched word
     * And if the result doesn't contain the word
     * You can compare the tags at the product page
     */
    public ProductPage searchResultsIfNotContainTheWord(){
        String searched = ActionsPage.moveToElementAndHighLight(driver, searchBar).getAttribute("value");
        List<WebElement> searchResults = findElements(driver, productsTitle);
        List <WebElement> productsLinks = findElements(driver, productLink);
        for(int i = 0; i < searchResults.size(); i++){
            if(!searchResults.get(i).getText().toLowerCase(Locale.ROOT).contains(searched.toLowerCase())){
                WebElement webElement = searchResults.get(i);
                moveToWebElementAndHighLight(driver, webElement);
                String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
                productsLinks.get(i).sendKeys(clickLink);
            }
        }
        return new ProductPage(driver);
    }
}
