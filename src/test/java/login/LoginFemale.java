package login;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utils.DataDrivenClass.readJson;

import java.io.IOException;

public class LoginFemale extends BaseTests {
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\RegisterData.json";

    @Test
    public void loginFemaleTest() throws IOException, ParseException {

        Assert.assertTrue( homePage
                .clickLoginBtn()
                .fillLoginInfo(
                        readJson(filePath, "emailF"),
                        readJson(filePath, "passwordF"))
                .clickConfLoginBtn()
                .clickLogoutBtn()
                .getWelcomeMsg()
                        .contains("Welcome to our store"),
                        "FemaleUser Login Unsuccessful");

    }
}
