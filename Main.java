//import javax.management.Query;
//import javax.swing.plaf.nimbus.State;
import java.util.*;
import java.sql.*;
public class Main {
//    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String url = "jdbc:mysql://localhost:3306/lenden";
    private static final String username = "root";

    private static final String password = "1234nitesh@#$";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

//        try{
//                Connection connection = DriverManager.getConnection(url, username, password);
//                Statement statement = connection.createStatement();
//                String query = "select * from students";
//                ResultSet resultSet = statement.executeQuery(query);
//                while(resultSet.next()){
//                    int id = resultSet.getInt("id");
//                    String name = resultSet.getString("name");
//                    int age = resultSet.getInt("age");
//                    double marks = resultSet.getDouble("marks");
//                    System.out.println("ID: "+ id);
//                    System.out.println("NAME: "+ name);
//                    System.out.println("AGE: "+ age);
//                    System.out.println("MARKS: "+ marks);
//                }
//
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//

//        try{
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//            String query = String.format("insert into students(name, age, marks) values('%s', %o, %f)", "Rahul", 23, 74.6);
//           int rowAffected = statement.executeUpdate(query);
//           if(rowAffected>0){
//               System.out.println("Data Inserted Successfully!");
//           }else{
//               System.out.println("Data not Inserted");
//           }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());

//        update
//        try{
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
////            String query = String.format("update students set marks= %f where id =%d", 89.5,2);
//            String query = String.format("delete from students where id = 3");
//            int rowAffected = statement.executeUpdate(query);
//            if(rowAffected>0){
////                System.out.println("Data updated Successfully!");
//                System.out.println("Data deleted Successfully!");
//            }else{
////                System.out.println("Data not updated");
//                System.out.println("Data not deleted");
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());


        /*PREPRED STATEMENT*/

//        try{
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
////
//            String query = "insert into students (name, aage , marks) values(?, ?, ?)";
//            PreparedStatement preparedStatement = connection.preparedStatement(query);
//            preparedStatement.setString(1, "Ankita");
//            preparedStatement.setInt(2, 34);
//            preparedStatement.setDouble(3, 56.4);
//            int rowAffected = preparedStatement.executeUpdate();
//            if(rowAffected>0){
////                System.out.println("Data updated Successfully!");
//                System.out.println("Data deleted Successfully!");
//            }else{
////                System.out.println("Data not updated");
//                System.out.println("Data not deleted");
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());

//        try{
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
////
//            String query = "insert into students (name, aage , marks) values(?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,1);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                System.out.println("Marks not found!");
//            } else {
//                double marks = resultSet.getDouble("marks");
//                System.out.println("Marks: " + marks);
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());


//        try{
//            Connection connection = DriverManager.getConnection(url, username, password);
////            Statement statement = connection.createStatement();
//            String query ="update students set marks= %f where id %d =?";
//            PreparedStatement preparedStatement= connection.prepareStatement(query);
//            preparedStatement.setDouble(1,87.5);
//            preparedStatement.setInt(2,3);
//            int rowsAffected = preparedStatement.executeUpdate();
//            if(rowsAffected>0){
//                System.out.println("Data updated Successfully!");
//            }else{
//                System.out.println("Data not updated");
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());


//        Batch procesing

//        try{
//            Connection connection = DriverManager.getConnection(url,username,password);
//            Statement statement= connection.createStatement();
//            Scanner sc=new Scanner(System.in);
//            while(true){
//                System.out.println("Enter name");
//                String name =sc.next();
//                System.out.println("Enter age");
//                int age= sc.nextInt();
//                System.out.println("Enter Marks");
//                double marks=sc.nextDouble();
//                System.out.println("Enter more Data(Y/N): ");
//                String choice =sc.next();
//                String query = String.format("insert into students(name,age ,marks) values('%s', %d, %f)", name, age, marks);
//                statement.addBatch(query);
//                if(choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//            int[] arr = statement.executeBatch();
////            if(rowsAffected>0){
////                System.out.println("Data updated");
////            }else{
////                System.out.println("Data not Updated");
////            }
//            for(int i =0; i<arr.length; i++){
//                if(arr[i] == 0){
//                    System.out.println("query: "+i+ "not executed Successfully!");
//                }
//            }
//
//        }catch(SQlExecution e){
//            System.out.println(e.getMessage());
//        }

//        Batch proecessing with prepared Statement

//        try{
//            Connection connection = DriverManager.getConnection(url,username,password);
//            String query ="insert into students(name,age ,marks) values(?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            Scanner sc=new Scanner(System.in);
//            while(true){
//                System.out.println("Enter name");
//                String name =sc.next();
//                System.out.println("Enter age");
//                int age= sc.nextInt();
//                System.out.println("Enter Marks");
//                double marks=sc.nextDouble();
//                System.out.println("Enter more Data(Y/N): ");
//                String choice =sc.next();
//                preparedStatement.setString(1, "name");
//                preparedStatement.setInt(2,age);
//                preparedStatement.setDouble(3,marks);
//
//                preparedStatement.addBatch();
//                if(choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//            int[] arr = preparedStatement.executeBatch();
////            if(rowsAffected>0){
////                System.out.println("Data updated");
////            }else{
////                System.out.println("Data not Updated");
////            }
//            for(int i =0; i<arr.length; i++){
//                if(arr[i] == 0){
//                    System.out.println("query: "+i+ "not executed Successfully!");
//                }
//            }
//
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//    }


//        exceptional handling
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            String debit_query = "update accounts set = balance - ? where account_number ";
            String credit_query = "update account set = balance + ? where account_number";
            PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);
            Scanner sc = new Scanner (System.in);
            System.out.println("Enter the account number:");
            int account_number = sc.nextInt();
            System.out.println("Enter Amount:");
            double amount = sc.nextDouble();
            debitPreparedStatement.setDouble(1, amount);
            debitPreparedStatement.setInt(2, account_number);
            creditPreparedStatement.setDouble(1, amount);
            creditPreparedStatement.setInt(2, 102);
//            if(isSufficient(connection, 101, amount))
                if(isSufficient(connection, account_number, amount)){
                    connection.commit();
                    System.out.println("Trsnsaction Successfull");
//                int affectedRows1 = debitPreparedStatement.executeUpdate();
//                int affectedRows2 = creditPreparedStatement.executeUpdate();
//                debitPreparedStatement.executeUpdate();
//                creditPreparedStatement.executeUpdate();
            }else {
                    connection.rollback();
                    System.out.println("transaction failed");
//                System.out.println("Insufficient balance!!");
            }
//            debitPreparedStatement.executeUpdate();
//           creditPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static boolean isSufficient(Connection connection, int account_number, double amount) {
        try {
            String query = "select balance from accounts where account_number= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, account_number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                double current_balance = resultSet.getDouble("balance");
                if(amount > current_balance){
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    return false;
    }
}
