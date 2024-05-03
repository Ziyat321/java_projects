package file_directory;

import java.io.File;
import java.util.List;

public class FileUtilMain {

    public static void main(String[] args) {

        String parentDirectory = "./src/file_directory/text_files";

        FileUtil fileUtil = new FileUtil(parentDirectory);
        List<String> fileNames = fileUtil.findFilesByName("file_1");
        System.out.println(fileNames);

    }

}
