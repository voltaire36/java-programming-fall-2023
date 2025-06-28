import java.sql.*;


public class DatabaseConnector {

    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    static final String DB_URL = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";

    static final String USER = "COMP228_F23_piy_113";
    static final String PASS = "password";


public static ResultSet getEmployeesByManager(String manager) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "SELECT * FROM Employee WHERE manager = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, manager);

        rs = pstmt.executeQuery();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        close(conn, pstmt, rs);
        throw new SQLException("JDBC Driver not found.");
    } catch (SQLException e) {
        e.printStackTrace();
        close(conn, pstmt, rs);
        throw e;
    }
    return rs;
}

private static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
    try {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}

