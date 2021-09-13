package managers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import dataProvider.ConfigFileReader;
import dataProvider.ConfigFileBardBGReader;

import java.util.Properties;

public class FileReaderManager {
    private static final Logger LOGGER = LogManager.getLogger(FileReaderManager.class);

    private static FileReaderManager fileReaderManager;
    private static ConfigFileBardBGReader configFileReader;
    private static ConfigFileReader configLillyFileReader;
    private Properties properties;
    private final String propertyFilePath = "src/test/resources/configs/Configuration.properties";


    public static FileReaderManager getInstance() {
        if (fileReaderManager == null) {
            synchronized (FileReaderManager.class) {
                if (fileReaderManager == null) {
                    LOGGER.debug("Creating an instance of FileReaderManager");
                    fileReaderManager = new FileReaderManager();
                }
            }
        }
        return fileReaderManager;
    }

    public ConfigFileBardBGReader getConfig_BardBG_Reader() {
        return (configFileReader == null) ? new ConfigFileBardBGReader() : configFileReader;
    }

    public ConfigFileReader configFileReader() {
        return (configLillyFileReader == null) ? new ConfigFileReader() : configLillyFileReader;
    }

}
