import java.sql.*;
public class Database {
    public static void main(String[] args) throws ClassNotFoundException {

        String url= "jdbc:mysql://localhost:3306/mydatabase";
        String userName= "root";
        String password= "!am@DMIN1174";
        String query="UPDATE employees SET job_title = 'Full Stack Developer', salary= 90000.0 WHERE id = 2;";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con= DriverManager.getConnection(url,userName,password);
            System.out.println("Connection established successfully");
            Statement statement= con.createStatement();
            int rowsAffected=statement.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("Update Successfull. "+rowsAffected+" rows affected");
            } else {
                System.out.println("Update failed");
            }

            ResultSet rs=statement.executeQuery("select * from employees;");
            while (rs.next()){
                int id= rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                double salary=rs.getDouble("salary");
                System.out.println();
                System.out.println("Id: "+id);
                System.out.println("Name: "+name);
                System.out.println("Job Title: "+job_title);
                System.out.println("Salary: "+ salary);
            }
            rs.close();
            statement.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
