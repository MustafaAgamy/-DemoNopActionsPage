package login;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utils.DataDrivenClass.readJson;

import java.io.IOException;

public class LoginMale extends BaseTests {
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\RegisterData.json";

    @Test
    public void loginMaleTest() throws IOException, ParseException {

        Assert.assertTrue(homePage
                .clickLoginBtn()
                .fillLoginInfo(
                        readJson(filePath, "emailM"),
                        readJson(filePath, "passwordM"))
                .clickConfLoginBtn()
                .clickLogoutBtn()
                .getWelcomeMsg()
                        .contains("Welcome to our store"),
                        "MaleUser Login Unsuccessful");
    }
}
