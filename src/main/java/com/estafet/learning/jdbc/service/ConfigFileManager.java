package com.estafet.learning.jdbc.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileManager {
    private static final Logger LOGGER = LogManager.getLogger(ConfigFileManager.class);

    private static ConfigFileManager configFileManager;
    private Properties properties;
    private final String propertyFilePath = "src/main/java/com/estafet/learning/resources/configuration.properties";


    public static ConfigFileManager getInstance() {
        if (configFileManager == null) {
            synchronized (ConfigFileManager.class) {
                if (configFileManager == null) {
                    LOGGER.debug("Creating an instance of FileReaderManager");
                    configFileManager = new ConfigFileManager();
                }
            }
        }
        return configFileManager;
    }

    public String getMysqlJDBC() {
        String mysqlJDBC = getProperties().getProperty("mysqlJDBC");
        if (mysqlJDBC != null) return mysqlJDBC;
        else throw new RuntimeException("mysqlJDBC not specified in the configuration.properties file.");
    }

    public String getMysqlUser() {
        String mysqlUser = getProperties().getProperty("mysqlUser");
        if (mysqlUser != null) return mysqlUser;
        else throw new RuntimeException("mysqlUser not specified in the configuration.properties file.");
    }

    public String getMysqlPassword() {
        String mysqlPassword = getProperties().getProperty("mysqlPassword");
        if (mysqlPassword != null) return mysqlPassword;
        else throw new RuntimeException("mysqlPassword not specified in the configuration.properties file.");
    }

    private Properties getProperties() {
        if (properties == null) {
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
        return properties;
    }

    public String getOracleJDBC() {
        String oracleJDBC = getProperties().getProperty("oracleJDBC");
        if (oracleJDBC != null) return oracleJDBC;
        else throw new RuntimeException("oracleJDBC not specified in the configuration.properties file.");
    }

    public String getOracleUser() {
        String oracleUserName = getProperties().getProperty("oracleUserName");
        if (oracleUserName != null) return oracleUserName;
        else throw new RuntimeException("oracleUserName not specified in the configuration.properties file.");
    }

    public String getOraclePassword() {
        String oraclePassword = getProperties().getProperty("oraclePassword");
        if (oraclePassword != null) return oraclePassword;
        else throw new RuntimeException("oraclePassword not specified in the configuration.properties file.");
    }

    public String getPostgreJDBC() {
        String postgreJDBC = getProperties().getProperty("postgre");
        if (postgreJDBC != null) return postgreJDBC;
        else throw new RuntimeException("postgre not specified in the configuration.properties file.");
    }

    public String getPostgreUser() {
        String postgreUserName = getProperties().getProperty("postgreUserName");
        if (postgreUserName != null) return postgreUserName;
        else throw new RuntimeException("postgreUserName not specified in the configuration.properties file.");
    }

    public String getPostgrePassword() {
        String postgrePassword = getProperties().getProperty("postgrePassword");
        if (postgrePassword != null) return postgrePassword;
        else throw new RuntimeException("postgrePassword not specified in the configuration.properties file.");
    }
}
