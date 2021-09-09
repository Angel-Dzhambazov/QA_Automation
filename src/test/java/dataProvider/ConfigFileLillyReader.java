package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileLillyReader {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/configs/Configuration.properties";

    public ConfigFileLillyReader() {
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
        String url = properties.getProperty("urlLillyDrogerie");
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

    public String getPhoneNumber() {
        String phoneNumber = properties.getProperty("phoneNumber");
        if (phoneNumber != null) return phoneNumber;
        else throw new RuntimeException("phoneNumber not specified in the Configuration.properties file.");
    }

    public String getTown() {
        String town = properties.getProperty("town");
        if (town != null) return town;
        else throw new RuntimeException("town not specified in the Configuration.properties file.");
    }

    public String getAddress() {
        String address = properties.getProperty("address");
        if (address != null) return address;
        else throw new RuntimeException("address not specified in the Configuration.properties file.");
    }
}
