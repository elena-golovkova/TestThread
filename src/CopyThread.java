import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopyThread extends Thread {
    private File source;
    private File destDir;

    public CopyThread(File source, File destDir) {
        this.source = source;
        this.destDir = destDir;
    }

    public CopyThread() {
    }

    public File getSource() {
        return source;
    }

    public void setSource(File source) {
        this.source = source;
    }

    public File getDestDir() {
        return destDir;
    }

    public void setDestDir(File destDir) {
        this.destDir = destDir;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " starts working");
            Files.copy(source.toPath(), destDir.toPath(), REPLACE_EXISTING);
            System.out.println(Thread.currentThread().getName() + " ends working");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
