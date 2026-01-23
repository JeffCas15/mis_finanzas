import java.sql.*;


public class dbConnection {

    //credentials DB
    static String url = System.getenv("DB_URL");
    static String user = System.getenv("DB_USER");
    static String password = System.getenv("DB_PASSWORD");

    //Connection method
    public static Connection connectDb(){

        //connection variable
        Connection connect = null;

        try{
            connect = DriverManager.getConnection(url, user, password);
        } catch(SQLException e){
            e.printStackTrace();
        }

        return connect;
    }
}
