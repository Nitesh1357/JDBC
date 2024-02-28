import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;

public class HotelReservationSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String username = "root";
    private static final String password = "1234nitesh@#$";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            while (true) {
                System.out.println();
                System.out.println("Hotel Management System");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. view Reservation");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservation");
                System.out.println("5. Delete Reservation");
                System.out.println("0. Exit");
                System.out.println("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        reserveRoom(connection, scanner);
                        break;
                    case 2:
                        viewReservations(connection);
                        break;
                    case 3:
                        getRoomNumber(connection, scanner);
                        break;
                    case 4:
                        updateReservation(connection, scanner);
                        break;
                    case 5:
                        exit();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice . try Again.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static void reserveRoom(Connection connection, Scanner scanner) {
        try {
            System.out.println("Enter guest name: ");
            String guestName = scanner.next();
            scanner.nextLine();
            System.out.println(" Enter room number");
            int roomNumber = scanner.nextInt();
            System.out.println(" Enter contact number");
            String contactNumber = scanner.next();

            String sql = "insert into reservation (guest_name,, room_number, contact_number)" + "values ('" + guestName + "', " + roomNumber + " , '" + contactNumber + "')";
            try (Statement statement = connection.createStatement()) {
                int affectedRows = statement.executeUpdate(sql);
                if (affectedRows > 0) {
                    System.out.println("Reservation successfully");
                } else {
                    System.out.println("Reservation Failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void viewReservations(Connection connection) throws SQLException {
        String sql = "Select reservation_id, guest_name, room_number, contact_number, reservation_date From reservations";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("Current Reservation");
            System.out.println("+----------------+-------------+-------------+----------------+-------------------+");
            System.out.println("+ Reservation Id |   Guest     | Room Number | Contact Number | Reservation Date +");
            System.out.println("+----------------+-------------+-------------+----------------+-------------------+");
            while (resultSet.next()) {
                int reservationId = resultSet.getInt("reservation_id");
                String guestName = resultSet.getString("guest_name");
                int roomNumber = resultSet.getInt("room_number");
                String contactNumber = resultSet.getString("contact_number");
                String reservationDate = resultSet.getTimestamp("reservation_date").toString();

                System.out.printf("| %-14d | %-11s | %-11d | %-14s | %-17s | \n", reservationId, guestName, roomNumber, contactNumber, reservationDate);
            }
            System.out.println("+------------------+-------------+------+-----+-------------------+-------------------+");
        }
    }

    private static void getRoomNumber(Connection connection, Scanner scanner) {
        try {
            System.out.println("Enter reservation ID: ");
            int reservationId = scanner.nextInt();
            System.out.println("Enter Guest Name: ");
            String guestName = scanner.nextLine();

            String sql = "SELECT room_number FROM reservations" +
                    "WHERE reservation_id = " + reservationId + "AND guest_name = '" + guestName + "'";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                if (resultSet.next()) {
                    int roomNumber = resultSet.getInt("room_number");
                    System.out.println("Room number for reservation ID" + reservationId + "and Guest " + guestName + "is: " + roomNumber);
                } else {
                    System.out.println("Reservation not Found for the given ID and guest name.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateReservation(Connection connection, Scanner scanner) {
        try {
            System.out.println("Enter reservation ID to Update: ");
            int reservationId = scanner.nextInt();
            scanner.nextLine();

            if (!reservationExists(connection, reservationId)) {
                System.out.println("Reservation not found for the given ID");
                return;
            }

            System.out.println("Enter new guest name");
            String newGuestName = scanner.nextLine();
            System.out.println("Enter new room number");
            int newRoomNumber = scanner.nextInt();
            System.out.println("Enter new contact number");
            String newContactNumber = scanner.next();

            String sql = "UPDATE reservations SET guest_name = '" + newGuestName + "', " + "room_number=" + newRoomNumber + ", " + "contact_number = '" + newContactNumber + "' " + "WHERE reservation _id = " + reservationId;
            try (Statement statement = connection.createStatement()) {
                int affectedRows = statement.executeUpdate(sql);

                if (affectedRows > 0) {
                    System.out.println("Reservation updated successfully!");
                } else {
                    System.out.println("Reservation updated failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        private static void deleteReservation(Connection connection, Scanner scanner) {
            try {
                System.out.println("Enter reservation ID to delete: ");
                int reservationId = scanner.nextInt();

                if (!reservationExists(connection, reservationId)) {
                    System.out.println("Reservation not found for the found for the given ID");
                    return;
                }
                String sql = "Delete from reservation where reservation_id= " + reservationId;
                try (Statement statement = connection.createStatement()) {
                    int affectedRows = statement.executeUpdate(sql);

                    if (affectedRows > 0) {
                        System.out.println("Reservation deleted successfully!");
                    } else {
                        System.out.println("Reservation deletion failed!");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            private static boolean reservationExists(Connection connection, int reservationId){
                try {
                    String sql = "SELECT reservation_id FROM reservations WHERE reservations_id = " + reservationId;

                    try(Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sql)){
                        return resultSet.next();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                    return false;
                }
                }
            public static void exit() throws InterruptedException{
                System.out.print("exiting System");
                int i = 5 ;
                while (i!=0){
                    System.out.print(".");
                    Thread.sleep(450);
                    i--;
                }
                System.out.println();
                System.out.println("Thank you for using Hotel Reservation System!!!");
        }
}
