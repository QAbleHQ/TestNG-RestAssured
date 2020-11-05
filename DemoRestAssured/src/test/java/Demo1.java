import com.sun.codemodel.JMethod;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1 {

    @Test
    public void print()
    {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("SatusCode is : " +response.statusCode());
        System.out.println("Data is: " +response.getBody().asString());
        System.out.println("HTTP Respose is: " +response.statusLine());


        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("I am Done");
    }
}

