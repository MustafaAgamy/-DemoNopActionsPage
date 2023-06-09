package followus;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TwitterTest extends BaseTests {

    String twitterTitle = "Twitter";

    @Test
    public void twitterTest(){

        Assert.assertTrue(homePage
                        .clickTwitterBtn()
                        .checkTwitterPage()
                            .contains(twitterTitle),
                            "Twitter page isn't opened");
    }
}
