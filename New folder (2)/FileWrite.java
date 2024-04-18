import java.io.*;

public class FileWrite {
    public static void main(String[] args) {
        try{
            FileWriter writer=new FileWriter("d:/FileHandling/NewFile.txt",true);
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String data=reader.readLine();


//            writer.append("File Handling practice!!!" );
//            bufferedWriter.write(data);
//            writer.append( data);
            writer.close();
            System.out.println("Successfully written");

        } catch (IOException e) {
            System.out.println("The error occured:");
            e.printStackTrace();
        }
    }
}
