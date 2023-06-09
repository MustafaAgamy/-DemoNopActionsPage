package search;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static utils.DataDrivenClass.readJson;

public class SearchTestTags extends BaseTests {
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\SearchData.json";


    @Test
    public void searchTestWithContainedWordAndTags() throws IOException, ParseException {

        Assert.assertTrue(homePage
                .searchInput(readJson(filePath, "searchData2"))
                .clickSearchBtn()
                .searchResultsIfNotContainTheWord()
                .switchToTabAndCompareProductsTags(
                        readJson(filePath, "Tag1"),
                        readJson(filePath, "Tag2"),
                        readJson(filePath, "Tag3")),
                "Incorrect Product Tags");

    }
}
