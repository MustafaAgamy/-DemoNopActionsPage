package shoppingcart;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static utils.DataDrivenClass.readJson;

public class AddingItemCheckCount extends BaseTests {
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\ShoppingData.json";

    @Test
    public void testAddingItemAndCheckingCount() throws IOException, ParseException {


        Assert.assertTrue( homePage
                .AddProduct1ToCartBtn()
                .fillInfoAndAddForProduct1()
                .clickAddToCartBtn()
                .closeSuccessMsg()
                .getCartItemsQuantity()
                        .contains(
                                readJson(filePath,"ProductQty")),
                        "Item not added");
   }
}
