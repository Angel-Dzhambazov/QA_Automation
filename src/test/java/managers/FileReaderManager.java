package managers;

import dataProvider.ConfigFileLillyReader;
import dataProvider.ConfigFileBardBGReader;

public class FileReaderManager {


    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileBardBGReader configFileReader;
    private static ConfigFileLillyReader configLillyFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileBardBGReader getConfig_BardBG_Reader() {
        return (configFileReader == null) ? new ConfigFileBardBGReader() : configFileReader;
    }

    public ConfigFileLillyReader CofigFile_Lilly_Reader() {
        return (configFileReader == null) ? new ConfigFileLillyReader() : configLillyFileReader;
    }

}
