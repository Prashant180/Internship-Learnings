import java.io.File;
import java.io.IOException;

public class FileList {
    public static void main(String[] args) {
        File directory= new File("d:/FileHandling");

        if(directory.exists() && directory.isDirectory()){
            System.out.println();
            File[] files=directory.listFiles();
            if (files != null ){
                System.out.println("List of files and directories in "+ directory.getAbsolutePath() + ":");
                for (File f:files) {
                    System.out.println(f.getName());
                }
            } else {
                System.out.println("The directory is empty");
            }
        } else {
            System.out.println("Invalid directory path");
        }

    }
}
