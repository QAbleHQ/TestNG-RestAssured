package requests;
import utils.getConfigData;
import okhttp3.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.logging.Logger;

public class Login {
    Logger log= Logger.getLogger(getConfigData.class.getName());
    utils.getConfigData config = new getConfigData();
    public JSONObject jsonResbody=null;
    public Response response=null;

    public Response getLogin() throws Exception {
        log.info("Get config file" );
        JSONParser jsonParser = new JSONParser();
        try {
            Object[] returnval= config.getParseData();
            config.getEndpoint("login");
            OkHttpClient client = new OkHttpClient();

            log.info("Push Email id & password for Login" );
            RequestBody formBody = new FormBody.Builder()
                    .add("email", config.EmailId)
                    .add("pwd", config.Password)
                    .build();

            log.info("Get Request on baseURL" );
            Request request = new Request.Builder()
                    .url(config.actualurl)
                    .post(formBody)
                    .build();

            response = client.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Get Response" );
    return response;
    }

//   public ArrayList<String> getjsonDataStructure(String jsonfilename, String param) {
//        if (jsonfilename.equals("login") & param.equals("city")) {
//            System.out.println("City list from json file : ");
//            for (Object c : config.City) {
//                System.out.println(c + ""); }
//        } return config.City;
//   }

   public String getDataFromResponse(String resvar)
   {
       if(resvar.equalsIgnoreCase("username"))
       {
       System.out.println("Username is :" +jsonResbody.get("userName"));
       }
       if(resvar.equalsIgnoreCase("userid"))
       {
           System.out.println("Username is :" +jsonResbody.get("userID"));
       }
       if(resvar.equalsIgnoreCase("message"))
       {
           System.out.println("Username is :" +jsonResbody.get("message"));
       }
       if(resvar.equalsIgnoreCase("userstatus"))
       {
           System.out.println("Username is :" +jsonResbody.get("userStatus"));
       }
      return resvar;
   }
}


        //implement log4j
        //print all logs


