import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.*;

public class CopyingFiles {

    File source = new File("src\\old\\строки.jpg");
    File dest = new File("src\\new\\строки.jpg");

    public static void copy(File source, File dest) throws IOException {

        try {
            Files.copy(source.toPath(), dest.toPath(), REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static void copyAllFiles(List<File> list, String newPath) throws IOException {
        File dest = new File(newPath);
        CopingWithThreads.checkDestDirectory(dest);
        if (list.size() > 0) {
            for (File file : list) {
                File source = file;
                File destDir = new File(dest, source.getName());
                CopyingFiles.copy(source, destDir);
            }
        } else {
            System.out.println("Directory is empty");
        }
    }

    public static List<File> getFilesInDir(String path) {
        List<File> arrFiles = new ArrayList<>();
        Path dir = Paths.get(path);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                arrFiles.add(new File(file.toString()));
            }

        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }
        return arrFiles;
    }

}

