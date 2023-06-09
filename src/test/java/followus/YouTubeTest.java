package followus;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class YouTubeTest extends BaseTests {
    String youTubeTitle = "YouTube";

    @Test
    public void youTubeTest(){

        Assert.assertTrue(homePage
                        .clickYouTubeBtn()
                        .checkYouTubePage()
                            .contains(youTubeTitle),
                            "YouTube page isn't opened");
    }
}
