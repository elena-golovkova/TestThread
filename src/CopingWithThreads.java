import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;

public class CopingWithThreads {
    File source = new File("src\\old\\");
    File dest = new File("src\\new");

    public static void checkDestDirectory(File dest) {
        if (!dest.exists()) {
            dest.mkdir();
        }
        if (!dest.isDirectory()) {
            throw new RuntimeException("You can't copy file in file");
        }

    }

    public static void copy(String oldPath, String newPath) {

        ThreadGroup copyGroup = new ThreadGroup("CopyGroup");

        File dest = new File(newPath);
        checkDestDirectory(dest);
        File[] listFilesToCopy = listFiles(oldPath);
        for (int i = 0; i < listFilesToCopy.length; i++) {
            File source = listFilesToCopy[i];
            File destDir = new File(dest, source.getName());
            while(copyGroup.activeCount() > 5){
                try {
                    System.out.println("sleep");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            new Thread(copyGroup, new CopyThread(source, destDir)).start();
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

    public static File[] listFiles(String path) {
        File file = new File(path);
        checkDestDirectory(file);
        File[] arr = file.listFiles();
        return arr;
    }

}
