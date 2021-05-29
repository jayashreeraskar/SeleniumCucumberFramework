package Manager;


public class FileReaderManager
{
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private  static ConfigFile_Reader configFileReader;

	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	 public ConfigFile_Reader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFile_Reader() : configFileReader;
	 }



}
