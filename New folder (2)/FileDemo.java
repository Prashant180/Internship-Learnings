import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        try {
            File newFile = new File("d:/FileHandling/NewFile1.txt");
            if (newFile.createNewFile()) {
                System.out.println("File created: "+newFile.getName());

            } else {
                System.out.println("File already exist");

            }

        } catch (IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
