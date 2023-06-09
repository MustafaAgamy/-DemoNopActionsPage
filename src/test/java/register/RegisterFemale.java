package register;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import static utils.DataDrivenClass.readJson;

public class RegisterFemale extends BaseTests {
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\RegisterData.json";

    @Test
    public void registerFemaleTest() throws IOException, ParseException {

        Assert.assertTrue(homePage
                .clickRegisterBtn()
                .fillRegisterInfoFeMale(readJson(filePath, "fNameF"),
                        readJson(filePath, "lNameF"),
                        readJson(filePath, "birthDayF"),
                        readJson(filePath, "birthMonthF"),
                        readJson(filePath, "birthYearF"),
                        readJson(filePath, "emailF"),
                        readJson(filePath, "passwordF"),
                        readJson(filePath, "confPasswordF"))
                .clickConfRegister()
                .getResultMsg()
                        .contains("Your registration completed"),
                        "FemaleUser Register Unsuccessful");
    }
}
