package wishlist;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import static utils.DataDrivenClass.readJson;

public class AddingItemOpenWish extends BaseTests {
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\ShoppingData.json";

    @Test
    void testAddingItemAndCheckingWishListPage() throws IOException, ParseException {


        Assert.assertTrue( homePage
                .AddProduct1ToWishBtn()
                .fillInfoAndAddForProduct1()
                .clickAddToWishBtn()
                .closeSuccessMsg()
                .clickWishListPageBtn()
                .productName()
                        .contains(
                                readJson(filePath, "ProductName")),
                        "Incorrect Product name");
    }
}
