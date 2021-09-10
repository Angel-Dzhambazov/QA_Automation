package managers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import dataProvider.ConfigFileLillyReader;
import dataProvider.ConfigFileBardBGReader;

import java.util.Properties;

public class FileReaderManager {
    private static final Logger LOGGER = LogManager.getLogger(FileReaderManager.class);

    private static FileReaderManager fileReaderManager;
    private static ConfigFileBardBGReader configFileReader;
    private static ConfigFileLillyReader configLillyFileReader;
    private Properties properties;
    private final String propertyFilePath = "src/test/resources/configs/Configuration.properties";


    public static FileReaderManager getInstance() {
        if (fileReaderManager == null) {
            synchronized (FileReaderManager.class) {
                if (fileReaderManager == null) {
                    fileReaderManager = new FileReaderManager();
                }
            }
        }
        return fileReaderManager;
    }

    public ConfigFileBardBGReader getConfig_BardBG_Reader() {
        return (configFileReader == null) ? new ConfigFileBardBGReader() : configFileReader;
    }

    public ConfigFileLillyReader CofigFile_Lilly_Reader() {
        return (configLillyFileReader == null) ? new ConfigFileLillyReader() : configLillyFileReader;
    }

}
