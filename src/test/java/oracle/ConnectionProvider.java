package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionProvider class handles DB connection and print
 * further SQL exceptions in order to be used in tests.
 * Please have a look at the Oracle DB tests to see how ir works
 *
 * @author  Ali Pala
 * @version 1.0
 */

public final class ConnectionProvider {

    public static Connection conn = null;
    public static String URL = "jdbc:oracle:thin:tsu_super_user/tsu_super_user@(DESCRIPTION=(CONNECT_TIMEOUT=10)\n" +
            "(ADDRESS_LIST=(ADDRESS=(HOST=aras0001.ah.nl)(PORT=1540)(PROTOCOL=tcp)))(CONNECT_DATA=(SID=aras0001)))";
    public static final String DB_URL1 = "jdbc:oracle:thin:@//aras0001.ah.nl:1540/aras0001";
    public static final String DB_PASSWORD = "tsu_super_user";
    public static final String DB_USER ="tsu_super_user";

    // This fields for CI/CD
//    public static final String DB_URL = System.getenv("DATABASE_URL");
//    public static final String DB_PASSWORD = System.getenv("DATABASE_PASSWORD");
//    public static final String DB_USER = System.getenv("DATABASE_USER_NAME");
//    static String url = "jdbc:oracle:thin:tsu_super_user/tsu_super_user@(DESCRIPTION=(CONNECT_TIMEOUT=10)(ADDRESS_LIST=(ADDRESS=(HOST=aras0001.ah.nl)(PORT=1540)(PROTOCOL=tcp)))(CONNECT_DATA=(SID=aras0001)))";

    /**
     * This class provides Oracle DB Connection
     * @return connection string
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

            conn = DriverManager.getConnection(URL);
            if (conn != null) {
                System.out.println("Connected to DB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * This class is used for get detailed message in a row
     * @param ex Exception thrown from
     * @return Exception in case of any error occurs
     */
    public static SQLException printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                    //e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((SQLException)e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = ex.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
            }
        }
        return ex;
    }
}
