import java.io.*;
import java.util.Properties;

public class Demo3 {
    public static void main(String args[]) throws IOException {
        FileReader reader = new FileReader("D:\\DemoRestAssured\\src\\test\\java\\config.properties");

        Properties p = new Properties();
        p.load(reader);

        System.out.println("UserName is: " +p.getProperty("user"));
        System.out.println("Password is: " +p.getProperty("password"));
        System.out.println("URL is: " +p.getProperty("baseurl"));
    }
}
