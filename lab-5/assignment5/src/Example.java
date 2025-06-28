import java.sql.Connection;
import java.sql.DriverManager;

public class Example {
    private static final String URL = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
    private static final String USER = "COMP228_F23_piy_113";
    private static final String PASSWORD = "password";
    public static void main(String[] args){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("db connected");
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
