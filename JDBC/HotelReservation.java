import java.sql.*;
import java.util.Scanner;
import java.util.SortedMap;

public class HotelReservation {
    private static final String url= "jdbc:mysql://localhost:3306/hotel_db";
    private static final String userName= "root";
    private static final String password= "!am@DMIN1174";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement statement=con.createStatement();
            while (true){
                System.out.println();
                System.out.println("HOTEL RESERVATION SYSTEM");
                Scanner sc=new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. View reservation");
                System.out.println("3. Get room number");
                System.out.println("4. Update reservation");
                System.out.println("5. Delete reservation");
                System.out.println("6. Exit");
                System.out.println("Choose an option");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        reserveRoom(statement,sc);
                        break;
                    case 2:
                        viewReservation(statement);
                        break;
                    case 3:
                        getRoomNumber(statement,sc);
                        break;
                    case 4:
                        updateReservation(con,sc);
                        break;
                    case 5:
                        deleteReservation(con,sc);
                        break;
                    case 6:
                        exit();
                        return;
                    default:
                        System.out.println("Invalid Choice. Try again.");
                }
            }

        }catch (SQLException | InterruptedException e){
            System.out.println(e.getMessage());
        }


    }
    private static void reserveRoom(Statement statement, Scanner scanner){
        try{
            System.out.println("Enter guest name: ");
            String name=scanner.next();
            scanner.nextLine();
            System.out.println("Enter room number: ");
            int roomNUmber=scanner.nextInt();
            System.out.println("Enter contact number: ");
            String contactNumber=scanner.next();

            String sql="INSERT INTO reservations (guest_name, room_number, contact_number) VALUES ('"+ name+ "', "+ roomNUmber +", '"+contactNumber+"');";


                int affectedRows= statement.executeUpdate(sql);

                if(affectedRows>0){
                    System.out.println("Reservation Successfull!");
                } else {
                    System.out.println("Reservation Failed!");
                }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static void viewReservation(Statement statement){
        String sql="SELECT reservation_id, guest_name, room_number, contact_number, reservation_date FROM reservations;";
        try(ResultSet rs=statement.executeQuery(sql)){
            System.out.println("Current Reservations:");
            while (rs.next()){
                int reservationId= rs.getInt("reservation_id");
                String  guestName= rs.getString("guest_name");
                int roomNumber= rs.getInt("room_number");
                String contactNumber= rs.getString("contact_number");
                String reservationDate= rs.getTimestamp("reservation_date").toString();

                System.out.println(reservationId+" "+guestName+" "+roomNumber+" "+contactNumber+" "+reservationDate);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static void getRoomNumber(Statement statement,Scanner scanner){
        System.out.println("Enter reservation id:");
        int reservationId= scanner.nextInt();
        System.out.println("Enter guest name:");
        String guestName= scanner.next();

        String sql="SELECT room_number FROM reservations WHERE reservation_id = "+reservationId+" AND guest_name='"+guestName+"'";

        try (ResultSet rs=statement.executeQuery(sql)){
            if(rs.next()){
                int roomNumber=rs.getInt("room_number");
                System.out.println("Room number for reservation id "+reservationId+" is:"+roomNumber);
            } else {
                System.out.println("Reservation not found!");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static void updateReservation(Connection connection, Scanner scanner){
        try{
            System.out.println("Enter reservation Id to update:");
            int reservationId=scanner.nextInt();
            scanner.nextLine();

//            if(!reservationExists(connection, reservationId)){
//                System.out.println("Reservation does not exist for given id");
//                return;
//            }
            System.out.println("Enter guest name: ");
            String newGuestName=scanner.next();
            System.out.println("Enter new room number:");
            int newRoomNumber= scanner.nextInt();
            System.out.println("Enter new contact number: ");
            String newContactNumber=scanner.next();

            String sql="UPDATE reservations SET guest_name = '"+newGuestName+"', room_number = "+newRoomNumber+", contact_number ='"+newContactNumber+"';";

            try(Statement statement=connection.createStatement()){
                int affectedRows= statement.executeUpdate(sql);
                if(affectedRows>0){
                    System.out.println("Reservation updated successfully!");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static void deleteReservation(Connection connection,Scanner scanner){
        try{
            System.out.println("Enter reservation Id to delete:");
            int reservationId=scanner.nextInt();

            String sql="DELETE FROM reservations WHERE reservation_id = " + reservationId +";";
            Statement statement=connection.createStatement();
            int affectedRows=statement.executeUpdate(sql);

            if(affectedRows>0){
                System.out.println("Deleted successfully!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void exit() throws InterruptedException{
        System.out.println("Exiting System");
        System.out.println();
        System.out.println("Thank you for using Hotel Reservation System!");
    }
}
