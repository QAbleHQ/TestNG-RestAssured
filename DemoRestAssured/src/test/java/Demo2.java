import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Demo2 {
    @Test
    public void display() throws IOException {
        FileReader reader = new FileReader("D:\\DemoRestAssured\\src\\test\\java\\config.properties");

        Properties p = new Properties();
        p.load(reader);

        given().get(p.getProperty("baseurl"))
                .then().statusCode(200)
                .body("data.id[1]", equalTo(8))
                .body("data.first_name", hasItems("Michael","Lindsay"))
                .log()
                .all();
    }
}



