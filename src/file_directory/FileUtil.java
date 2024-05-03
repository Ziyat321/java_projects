package file_directory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileUtil {

    private File parentDirectory;

    public FileUtil(String directoryName) {
        parentDirectory = new File(directoryName);
        if(!(parentDirectory.exists() && parentDirectory.isDirectory())){
            parentDirectory = null;
        }
    }


    public List<String> findFilesByName(String fileName) {
        List<String> fileList = new ArrayList<>();
        fileSearcher(fileName, parentDirectory, fileList);
        return fileList;
    }

    private void fileSearcher(String fileName, File directory, List<String> fileList){
        if(directory != null){
            File[] files = directory.listFiles();
            if(files != null){
                for (File file : files) {
                    if(file.isFile()) {
                        String fileName1 = file.getName();
                        if(fileName1.contains(fileName)){
                            fileList.add(fileName1);
                        }
                    } else if(file.isDirectory()) {
                        fileSearcher(fileName, file, fileList);
                    }
                }
            }
        }
    }

    public File getParentDirectory() {
        return parentDirectory;
    }
}
