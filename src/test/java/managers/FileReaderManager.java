package managers;

import dataProvider.ConfigFile_BardBG_Reader;

public class FileReaderManager {


    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFile_BardBG_Reader configFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFile_BardBG_Reader getConfig_BardBG_Reader() {
        return (configFileReader == null) ? new ConfigFile_BardBG_Reader() : configFileReader;
    }

}
