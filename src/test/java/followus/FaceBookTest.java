package followus;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceBookTest extends BaseTests {

    String faceBookTitle = "Facebook";

    @Test
    public void testFaceBook(){

        Assert.assertTrue(homePage
                        .clickFaceBookBtn()
                        .checkFaceBookPage()
                            .contains(faceBookTitle),
                            "FaceBook page isn't opened");
    }
}
