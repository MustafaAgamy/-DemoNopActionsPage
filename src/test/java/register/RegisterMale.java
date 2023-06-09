package register;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utils.DataDrivenClass.readJson;

import java.io.IOException;

public class RegisterMale extends BaseTests {
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\RegisterData.json";


    @Test
    public void registerMaleTest() throws IOException, ParseException {


        Assert.assertTrue(homePage
                .clickRegisterBtn()
                .fillRegisterInfoMale(
                        readJson(filePath, "fNameM"),
                        readJson(filePath, "lNameM"),
                        readJson(filePath, "birthDayM"),
                        readJson(filePath, "birthMonthM"),
                        readJson(filePath, "birthYearM"),
                        readJson(filePath, "emailM"),
                        readJson(filePath, "passwordM"),
                        readJson(filePath, "confPasswordM"))
                .clickConfRegister()
                .getResultMsg()
                        .contains("Your registration completed"),
                        "MaleUser Register Unsuccessful");
    }
}
