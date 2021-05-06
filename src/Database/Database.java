package Database;

import java.sql.*;

public class Database {

    private Connection connection;

    public Database(){
        connectToDB();
    }

    private void connectToDB(){
        String url = "jdbc:mysql://eu-cdbr-west-01.cleardb.com:3306/heroku_c56136e9e9704d8";
        String username = "b1141894708323";
        String password = "4150221d";

        System.out.println("Connecting to remote DB...");

        try{
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established!");

        }catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the Database!", e);
        }
    }

    // method mainly used for testing purposes
    public void getUsersTableFromDB(String query){
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                //Display values
                System.out.print("ID: " + rs.getInt("user_id"));
                System.out.print(", Username: " + rs.getString("username"));
                System.out.println(", Password: " + rs.getString("password"));
            }
        } catch (SQLException e){
            throw new IllegalStateException("Cannot retrieve table from Database!", e);
        }
    }

    public void closeConnectionDB(){
        try {
            connection.close();
            System.out.println("Connection to Database closed");
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to close Database connection!", e);
        }
    }
}
