package tests;
import okhttp3.Response;
import org.testng.annotations.Test;

public class LogingWithValidCredentials {
    utils.getConfigData config=new utils.getConfigData();
    requests.Login login=new requests.Login();
    assertations.assertLogin verifylogin= new assertations.assertLogin();

    @Test
    public void login() throws Exception {

       String URL =config.getEndpoint("login");
       System.out.println("My Endpoint is : \n" + URL);

       Response res=login.getLogin();
       System.out.println("Response is :\n"+res);

       String loginResponse=verifylogin.verifyloginsucessfully();
        System.out.println("Response login :\n" +loginResponse);





    //   login.getjsonDataStructure("login","city");
       // login.getDataFromResponse("Username");
        //  verifyProperty(,"FirstName","Nidhi Panchal");

     }
    }



