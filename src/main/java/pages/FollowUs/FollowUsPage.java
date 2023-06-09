package pages.FollowUs;

import Utils.ActionsPage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static Utils.ActionsPage.*;

public class FollowUsPage {
    private WebDriver driver;

    public FollowUsPage(WebDriver driver){
        this.driver = driver;
    }


    /**
     * @Steps to open the follow us links
     * And Confirm the right links are opened in a new tabs
     * Notice that one of the follow options is broken if you want to include it
     * You must know that the Assertion for it will fail
     * That's why it's not included here
     */
    public List<String > getWindowsTitles(){
        List<String> pagesTitles = new ArrayList<>();
        var mainWindow = driver.getWindowHandle();
        var newWindows = driver.getWindowHandles();
        Iterator<String> iterator = newWindows.iterator();
//            for (int i = 0; i < newWindows.size(); i++){
                String newWindow = iterator.next();
                if(!mainWindow.equals(newWindow)){
                    highLightWindow(driver);
                    String pageTitle = driver.getTitle();
                    pagesTitles.add(pageTitle);
            }
//        }
            return pagesTitles;
    }

    public String checkFaceBookPage(){
        highLightWindow(driver);

       return driver.getTitle();
    }

    public String checkTwitterPage(){
        highLightWindow(driver);

        return driver.getTitle();
    }

    public String checkYouTubePage(){
        ActionsPage.highLightWindow(driver);

        return driver.getTitle();
    }
}
