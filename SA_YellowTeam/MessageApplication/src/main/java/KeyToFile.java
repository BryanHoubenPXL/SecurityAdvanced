import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class KeyToFile {
    public KeyToFile() {

    }

    public void convert(String path, byte[] key) throws IOException {
        File filePath = new File(path);
        FileOutputStream outputStream = new FileOutputStream(filePath);
        outputStream.write(key);
        outputStream.flush();
        outputStream.close();
    }
}
