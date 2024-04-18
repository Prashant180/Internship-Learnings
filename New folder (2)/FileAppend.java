import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileAppend {
    public static void main(String[] args) {
        String path = "d:/FileHandling/NewFile.txt";
        String text="File Handling Tutorial.";

        try {
            Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
