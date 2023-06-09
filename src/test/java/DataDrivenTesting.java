import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataDrivenTesting {

    JSONObject registerData;
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\RegisterData.json";

    @Test
    public void testData() throws ParseException, IOException {
        registerData = (JSONObject) new JSONParser().parse(new FileReader(filePath));
        System.out.println(registerData.get("lNameM"));
    }
}
