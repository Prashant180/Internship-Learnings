import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileRead {
    public static void main(String[] args) {
        try{
            File obj=new File("d:/FileHandling/NewFile.txt");
            Path path= Paths.get("d:/FileHandling/NewFile.txt");
            System.out.println(new Date(obj.lastModified()));
            System.out.println(obj.length());
            byte[] arr= Files.readAllBytes(path);

//            System.out.println(Arrays.toString(arr));
//            List<String > listString=new ArrayList<>();

            String longestWord="";
            String current;

            Scanner reader=new Scanner(obj);
            while (reader.hasNext()){
                current=reader.next();
                if(current.length()>longestWord.length()){
                    longestWord=current;
                }

                String data=reader.nextLine();
                System.out.println(data);
//                listString.add(data);
            }
            System.out.println("Longest word :" +longestWord);
//            String[] arrayString=listString.toArray(new String[0]);

//            for (String str:arrayString) {
//                System.out.println(str);
//            }

        } catch (IOException e){
            System.out.println("An error has occured");
            e.printStackTrace();
        }
    }
}
