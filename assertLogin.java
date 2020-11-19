package assertations;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.json.simple.parser.JSONParser;
import requests.Login;
import utils.getConfigData;
import java.io.IOException;
import java.util.logging.Logger;

public class assertLogin {
    Logger log= Logger.getLogger(getConfigData.class.getName());
    public JSONObject jsonResbody=null;
    public String resbody=null;

    public String verifyloginsucessfully() throws IOException {
    JSONParser jsonParser = new JSONParser();
    try {
        log.info("Get Login file" );
        Login loginResponse=new Login();
        loginResponse.getLogin();
        log.info("Verify Respose body getting expected value or not" );
        if (!loginResponse.response.isSuccessful()) throw new Exception("Unexpected code " + loginResponse.response);

        log.info("Parse json response file" );
        jsonResbody = (JSONObject) jsonParser.parse(loginResponse.response.body().string());
        resbody=jsonResbody.toJSONString();

        log.info("Verify Response details" );
        Assert.assertEquals(200, loginResponse.response.code());
        System.out.println("Response code is " +loginResponse.response.code()+"!");
        Assert.assertEquals(true, jsonResbody.get("userStatus"));
        System.out.println("Verified User Status is 'True'!!");
        Assert.assertEquals("Ankit", jsonResbody.get("userName"));
        System.out.println("Verified User Name is "+jsonResbody.get("userName")+"!!");
        Assert.assertEquals("Login Successfully!!!", jsonResbody.get("message"));
        System.out.println("Verified User Status is 'Login Successfully!!!'.");
     }
    catch (Exception e)
    {
        e.printStackTrace();
    }
        return resbody;
    }
}
