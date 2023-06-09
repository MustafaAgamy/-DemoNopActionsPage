package search;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static utils.DataDrivenClass.readJson;

public class SearchTestWord extends BaseTests {
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\SearchData.json";


    @Test
    public void searchTestWithContainedWord() throws IOException, ParseException {

        Assert.assertTrue(homePage
                .searchInput(
                        readJson(filePath, "searchData1"))
                .clickSearchBtn()
                .searchResultsIfContainTheWord(),
                "Incorrect ProductName");
    }
}
