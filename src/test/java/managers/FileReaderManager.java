package managers;

import dataProvider.ConfigFile_Lilly_Reader;
import dataProvider.ConfigFile_BardBG_Reader;

public class FileReaderManager {


    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFile_BardBG_Reader configFileReader;
    private static ConfigFile_Lilly_Reader configLillyFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFile_BardBG_Reader getConfig_BardBG_Reader() {
        return (configFileReader == null) ? new ConfigFile_BardBG_Reader() : configFileReader;
    }

    public ConfigFile_Lilly_Reader CofigFile_Lilly_Reader() {
        return (configFileReader == null) ? new ConfigFile_Lilly_Reader() : configLillyFileReader;
    }

}
