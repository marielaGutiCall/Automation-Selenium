package session;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private static GetProperties instance = null;
    private String host;
    private String browser;

    private GetProperties(){
        Properties properties = new Properties();
        String nameFile = "boaWebsite.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);
        if(inputStream != null){
            try {
                properties.load(inputStream);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        host = properties.getProperty("host");
        browser = properties.getProperty("browser");
    }
    public static GetProperties getInstance(){
        if (instance == null) instance = new GetProperties();
        return instance;
    }

    public String getHost() {
        return host;
    }

    public String getBrowser()  {
        return browser;
    }
}
