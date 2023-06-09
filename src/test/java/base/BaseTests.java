package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

public class BaseTests {
    public WebDriver driver;
    protected HomePage homePage;

    /** THIS IS THE BASE_TEST FOR THE TEST CLASSES MAKE SURE TO INHERIT IN YOUR TEST CLASSES **
     * @setUp to initialize the Driver.
     * @goHome to navigate to the url (change depending on your test).
     * @tearDown to Close the Driver.
     */

    @BeforeClass
    @Parameters({"browser", "baseURL"})
    public void setUp(String browser, String baseURL) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        goDemo(baseURL);
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void goDemo(String baseURL){
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
