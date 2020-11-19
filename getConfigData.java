package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import java.util.logging.*;

public class getConfigData {
    Logger log= Logger.getLogger(getConfigData.class.getName());
    public Response response=null;
    public JSONObject jsonbasefile =null;
    public JSONObject jsonendfile = null;
    public JSONObject jsonloginfile =null;
    public String url = null;
    public JSONArray City = null;
    public String loginend=null;
    public String EmailId = null;
    public String Password = null;
    public String actualurl = null;

    public void getparsefile() throws IOException {

        JSONParser jsonParser = new JSONParser();
        try {

            OkHttpClient client = new OkHttpClient();
            jsonbasefile = (JSONObject) jsonParser.parse(new FileReader(".\\config.json"));
            jsonendfile = (JSONObject) jsonParser.parse(new FileReader(".\\src\\test\\java\\endPoints\\EndPoints.json"));
            jsonloginfile = (JSONObject) jsonParser.parse(new FileReader(".\\src\\test\\java\\data\\login.json"));
        }
        catch (Exception e) {
            e.printStackTrace(); }
    }
    public Object[] getParseData() throws IOException
    {
        getparsefile();
        url = (String) jsonbasefile.get("baseurl");
        City = (JSONArray) jsonloginfile.get("city");
        loginend = (String) jsonendfile.get("loginpoint");
        EmailId = (String) jsonloginfile.get("emailid");
        Password = (String) jsonloginfile.get("passwd");

        return new Object[]{url,City,loginend,EmailId,Password};
    }
    public String getEndpoint(String endpoint) throws IOException {
        getparsefile();
        getParseData();
        if(endpoint.equals("login"))
            actualurl = url + loginend;
        return actualurl;
    }
}







