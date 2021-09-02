package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile_Lilly_Reader {

    private Properties properties;
    private final String propertyFilePath = "configs//LillyDrogerie.properties";

    public ConfigFile_Lilly_Reader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowserVersion() {
        String browserVersion = properties.getProperty("browserVersion");
        if (browserVersion != null) return browserVersion;
        else throw new RuntimeException("browserVersion not specified in the Configuration.properties file.");
    }

    public int getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Integer.parseInt(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getUsername() {
        String username = properties.getProperty("usernameAtLillyShop");
        if (username != null) return username;
        else throw new RuntimeException("Username not specified in the Configuration.properties file.");
    }


    public String getPassword() {
        String password = properties.getProperty("passwordAtLillyShop");
        if (password != null) return password;
        else throw new RuntimeException("Password not specified in the Configuration.properties file.");
    }

    public String getTestDataResourcePath() {
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if (testDataResourcePath != null) return testDataResourcePath;
        else throw new RuntimeException(
                "Test Data Resource Path not specified in the Configuration.properties file for the " +
                        "Key:testDataResourcePath");
    }


}
