import java.util.Scanner;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

public class index {
    private static String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static String user = "root";
    private static String password = "aks147@sql07";

    public static void main(String[] args) throws SQLException, Exception, ClassNotFoundException {
        
       
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        // Statement stmt = conn.createStatement();
        System.out.println("Connecting to");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hotel Reservation System....");
        System.out.println();
        System.out.println("Enter 1 for new reservation :");
        System.out.println("Enter 2 for check reservation :");
        System.out.println("Enter 3 for new get room number :");
        System.out.println("Enter 4 for update reservation :");
        System.out.println("Enter 5 for delete reservation :");
        System.out.println("Enter 6 for exit :");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                newReservation(conn, scanner);
                break;
            case 2:
                checkReservation(conn);
                break;
            case 3:
                getRoom(conn, scanner);
                break;
            case 4:
                updateReservation(conn, scanner);
                break;
            case 5:
                deleteReservation(conn, scanner);
                break;
            case 6:
                exit();
                break;
            default:
                System.out.println("Invalid operation!!");

        }

    }


    //------New Reservation------------------

    public static void newReservation(Connection connection, Scanner scanner) throws SQLException {
        System.out.println(" ");
        System.out.println("Enter Reservation id :");
        int reservationid = scanner.nextInt();
        System.out.println("Enter Guest name :");
        String guestName = scanner.next();
        scanner.nextLine();
        System.out.println("Enter Room Number :");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        String query = "insert into reservation values (" + reservationid + ",'" + guestName + "'," + roomNumber + ");";

        Statement st = connection.createStatement();

        int rs = st.executeUpdate(query);

        if (rs >= 1) {
            System.out.println("Reservation Successfully Added");
        } else {
            System.out.println("Reservation Failed");
        }
    }

    //---------Check Reservation Data-------------
    public static void checkReservation(Connection connection) throws SQLException {

        String query = "SELECT * FROM reservation;";

        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println("Reservation ID : " + rs.getInt("reservation_id") + " ");
            System.out.println("Guest Name : " + rs.getString("guest_name") + " ");
            System.out.println("Room Number : " + rs.getInt("room_number") + " ");
            System.out.println("------------------------------------------");
            // System.out.print("Reservation Date :"+ rs.getString("reservation_date"));
        }

    }

    //-----Get Room by reservation ID ------------------
    public static void getRoom(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter Reservation Id : ");
        int id = scanner.nextInt();

        String query = "select room_number from reservation where reservation_id =" + id + ";";

        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println("Room Number : " + rs.getInt("room_number"));
        }

    }

    //-----------Update Reservation using reservation ID -----------------
    public static void updateReservation(Connection connection, Scanner scanner) throws SQLException {
        Statement st = connection.createStatement();

        System.out.println("Enter Reservation Id : ");
        int id = scanner.nextInt();

        String query0 = "select * from reservation where reservation_id = " + id + ";";
        ResultSet rs = st.executeQuery(query0);

        if (rs.next() == false) {
            System.out.println("Data with Reservation Id : " + id + " is not found");
        }

        System.out.println("Enter new Guest name :");
        String guestName = scanner.next();
        scanner.nextLine();

        String query = "update reservation set guest_name = '" + guestName + "' where reservation_id = " + id + ";";

        int rc = st.executeUpdate(query);

        if (rc >= 1) {
            System.out.println("Updation on Reservation Id : " + id + " is Successful");
            System.out.println("Guest Name change to : " + guestName);
        } else {
            System.out.println("Unable to Update");
        }
    }

    //----------Delete reservation using reservation ID ------------------
    public static void deleteReservation(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter Reservation Id : ");
        int id = scanner.nextInt();

        String query = "delete from reservation where reservation_id = " + id + ";";

        Statement st = connection.createStatement();

        int result = st.executeUpdate(query);

        if (result >= 1) {
            System.out.println("Reservation with " + id + " is deleted successfully");
        } else {
            System.out.println("Unable to delete reservation");
        }

    }

    public static void exit() {
        System.out.println("........................EXIT..........................");
        System.out.println("  ");
    }
}
