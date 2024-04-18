import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;

import javax.swing.text.Style;

public class StudentDB {
    private static final String url= "jdbc:mysql://localhost:3306/mydatabase";
    private static final String userName= "root";
    private static final String password= "!am@DMIN1174";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = DriverManager.getConnection(url, userName, password)) {
            Statement statement = con.createStatement();
            while (true) {
                System.out.println();
                System.out.println("STUDENTS RECORD");
                Scanner sc = new Scanner(System.in);
                System.out.println("1. Enter new student");
                System.out.println("2. View students");
                System.out.println("3. Update student");
                System.out.println("4. Delete Student");
                System.out.println("5. Export data to excel");
                System.out.println("6. Filter view");
                System.out.println("0. Exit");
                System.out.println("Choose an option");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> createStudent(statement, sc);
                    case 2 -> viewStudents(con, sc);
                    case 3 -> updateStudent(statement, sc);
                    case 4 -> deleteStudent(statement, sc);
                    case 5 -> writeExcel(statement,sc);
                    case 6 -> filterView(statement, sc);
                    case 0 -> {
                        exit();
                        return;
                    }
                    default -> System.out.println("Invalid Choice. Try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeExcel(Statement statement, Scanner scanner){
        try{
            ResultSet rs=statement.executeQuery("SELECT * FROM students");

            XSSFWorkbook workbook=new XSSFWorkbook();

            CellStyle style=workbook.createCellStyle();
            Font font=workbook.createFont();
            font.setBold(true);
            font.setItalic(true);
            style.setFont(font);

            XSSFSheet spreadsheet1=workbook.createSheet("Student db");


            XSSFRow row=spreadsheet1.createRow(1);
            XSSFCell cell;
//            CellStyle cellStyle=workbook.createCellStyle();


            cell=row.createCell(1);
            cell.setCellStyle(style);
            cell.setCellValue("ID");



            cell=row.createCell(2);
            cell.setCellStyle(style);
            cell.setCellValue("Name");

            cell=row.createCell(3);
            cell.setCellStyle(style);
            cell.setCellValue("Contact NUmber");
//            spreadsheet1.autoSizeColumn(3);

            cell=row.createCell(4);
            cell.setCellStyle(style);
            cell.setCellValue("Stream");

            int i=2;

            while (rs.next()){
                row = spreadsheet1.createRow(i);
                spreadsheet1.autoSizeColumn(1);
                spreadsheet1.autoSizeColumn(2);
                spreadsheet1.autoSizeColumn(3);
                spreadsheet1.autoSizeColumn(4);
                cell = row.createCell(1);
                cell.setCellValue(rs.getString("student_id"));

                cell = row.createCell(2);
                cell.setCellValue(rs.getString("student_name"));

                cell = row.createCell(3);
                cell.setCellValue(rs.getString("contact_number"));

                cell = row.createCell(4);
                cell.setCellValue(rs.getString("stream"));

                i++;
            }
            System.out.println("Enter file name:");
            String str=scanner.next();
            FileOutputStream output= new FileOutputStream(new File("d:/"+str+".xlsx"));
            workbook.write(output);
            output.close();

            System.out.println("Excel data has been written successfully!");


        } catch (SQLException | FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void createStudent(Statement statement,Scanner scanner){
        try{
            System.out.println("Enter name of student: ");
            String name=scanner.next();
            scanner.nextLine();
            System.out.println("Enter contact number: ");
            String  contactNumber= scanner.next();
            scanner.nextLine();
            System.out.println("Enter stream: ");
            String stream=scanner.next();
            scanner.nextLine();
//            System.out.println("Enter username:");
//            String userName=scanner.next();
//            scanner.nextLine();
//            System.out.println("Enter password:");
//            String password=scanner.next();
//            scanner.nextLine();

//            , '"+userName+"', '"+password+"'

            String sql="INSERT INTO students (student_name, contact_number, stream) VALUES ('"+name+"','"+contactNumber+"', '"+ stream+"');";
            int affectedRows= statement.executeUpdate(sql);
            if(affectedRows>0){
                System.out.println("Creation Successfull!");
            } else {
                System.out.println("Creation Failed!");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static void viewStudents(Connection connection,Scanner scanner){
        String sql="SELECT * FROM students LIMIT ? OFFSET ?";
        System.out.println("Enter size of page:");
        int pageSize=scanner.nextInt();
        System.out.println("Enter page number: ");
        int pageNumber=scanner.nextInt();
        int offset= (pageNumber-1)* pageSize;

//        System.out.println("Enter username:");
//        String user=scanner.next();
//        scanner.nextLine();
//        System.out.println("Enter password");
//        String pass=scanner.next();
//        scanner.nextLine();

//        if(validate(statement, user, pass)){
            try{

                PreparedStatement preparedStatement= connection.prepareStatement(sql);
                preparedStatement.setInt(1,pageSize);
                preparedStatement.setInt(2,offset);
                ResultSet rs= preparedStatement.executeQuery();
//                ResultSet rs=statement.executeQuery(sql);
                System.out.println("Students Table");
                while (rs.next()){
                    int studentId=rs.getInt("student_id");
                    String name=rs.getString("student_name");
                    String contact=rs.getString("contact_number");
                    String stream=rs.getString("stream");

                    System.out.println(studentId+"  "+name+"  "+contact+"  "+stream);
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
//        } else {
//            System.out.println("Invalid username or password!");
//        }

    }

    private static void filterView(Statement statement,Scanner scanner){
        try{
            System.out.println("Select the search option");
            System.out.println("1. search with roll");
            System.out.println("Enter name to search:");
            String str=scanner.next();
            String sql="SELECT * FROM students WHERE student_name LIKE '%"+str+"%';";
            ResultSet rs=statement.executeQuery(sql);

            System.out.println("Students Table");
            while (rs.next()){
                int studentId=rs.getInt("student_id");
                String name=rs.getString("student_name");
                String contact=rs.getString("contact_number");
                String stream=rs.getString("stream");

                System.out.println(studentId+"  "+name+"  "+contact+"  "+stream);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    private static void updateStudent(Statement statement,Scanner scanner){
        System.out.println("Enter student Id to update:");
        int studentId=scanner.nextInt();
        scanner.nextLine();

//        System.out.println("Enter username:");
//        String user=scanner.next();
//        scanner.nextLine();
//        System.out.println("Enter password");
//        String pass=scanner.next();
//        scanner.nextLine();

//        if(validate(statement,user,pass)){
            try{
                System.out.println("Enter new student name:");
                String newName=scanner.next();
                scanner.nextLine();
                System.out.println("Enter new contact number:");
                String newContact=scanner.next();
                System.out.println("Enter new stream:");
                String newStream=scanner.next();

                String sql="UPDATE students SET student_name='"+newName+"', contact_number='"+newContact+"', stream= '"+newStream+"';";
                int affectedRows=statement.executeUpdate(sql);
                if(affectedRows>0){
                    System.out.println("Updated Successfully!");
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
//        } else {
//            System.out.println("Invalid username or password!");
//        }

    }
    private static void deleteStudent(Statement statement,Scanner scanner){

//        System.out.println("Enter username:");
//        String user=scanner.next();
//        scanner.nextLine();
//        System.out.println("Enter password");
//        String pass=scanner.next();
//        scanner.nextLine();

//        if(validate(statement,user,pass)){
            System.out.println("Enter student id to delete:");
            int studentId=scanner.nextInt();

            String sql="DELETE FROM students WHERE student_id = "+studentId+";";
            try {
                int affectedRows=statement.executeUpdate(sql);
                if (affectedRows>0){
                    System.out.println("Deleted successfully!1");
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
//        } else {
//            System.out.println("Invalid username or password!");
//        }

    }
    private static boolean validate(Statement statement,String userName, String password){
        try{
            String sql="SELECT password FROM studentsLogin WHERE userName = '"+userName+"';";
            ResultSet rs=statement.executeQuery(sql);
            rs.next();
            String pass=rs.getString("password");
            if(pass.equals(password)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    private static void exit(){
        System.out.println("Thank you for using STUDENT RECORD!");
    }
}
