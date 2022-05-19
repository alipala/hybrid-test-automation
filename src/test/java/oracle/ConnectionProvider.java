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

    // This fields for CI/CD
    public static final String DB_URL = System.getenv("DATABASE_URL");
    public static final String DB_PASSWORD = System.getenv("DATABASE_PASSWORD");
    public static final String DB_USER = System.getenv("DATABASE_USER_NAME");


    /**
     * This class provides Oracle DB Connection
     * @return connection string
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

            conn = DriverManager.getConnection(DB_URL, DB_PASSWORD, DB_USER);
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
