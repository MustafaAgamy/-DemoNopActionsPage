package sliders;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Listeners.RetryAnalyzer;

public class SlidersTests extends BaseTests {

    @Test(retryAnalyzer = utils.Listeners.RetryAnalyzer.class)
    public void testSliders() throws InterruptedException {
        var slidersPage = homePage.switchToSliders();
        slidersPage.clickOnSliderSwitchAndCheckActivity();
        Assert.assertTrue(slidersPage.clickOnSliderSwitchAndCheckActivity(),"Assertion fail");
    }


}
