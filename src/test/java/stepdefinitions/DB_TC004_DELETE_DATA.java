package stepdefinitions;

import oracle.ConnectionProvider;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.List;
import java.util.Map;

import static oracle.TableColumns.valueOf;

public class DB_TC004_DELETE_DATA {

//    Connection conn = null;
//    PreparedStatement ps = null;
//    Statement stmt = null;
//    ResultSet resultSet = null;
//    public String tableName = null;
//    public String condition = null;
//    public String firstColumn = null;
//    public String secondColumn = null;
//    public String thirdColumn = null;

    @Given("connect to database for deleting data")
    public void connect_to_database_for_deleting_data(){
//        try {
//            conn = ConnectionProvider.getConnection();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            ConnectionProvider.printSQLException(e);
//            e.printStackTrace();
//        }
    }

    @When("send a delete query")
    public void send_a_delete_query(@NotNull DataTable dataTable) {
//        List<Map<String, String>> table = dataTable.asMaps();
//        for (Map<String, String> itemOf : table) {
//            tableName = itemOf.get("table");
//            condition = itemOf.get("condition");
//            firstColumn = itemOf.get("first_column");
//            secondColumn = itemOf.get("second_column");
//            thirdColumn = itemOf.get("third_column");
//        }
//
//        try {
//            // Query
//            String SQL_DELETE = "DELETE " + tableName + " WHERE " + condition + "";
//
//            ps = conn.prepareStatement(SQL_DELETE);
//            int row = ps.executeUpdate();
//            ps.close();
//            conn.close();
//
//        } catch (SQLException e) {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Then("should not see the deleted rows anymore")
    public void should_not_see_the_deleted_rows_anymore(DataTable dataTable) throws SQLException {
//        List<Map<String, String>> table = dataTable.asMaps();
//        for (Map<String, String> tableItemOf : table) {
//            tableName = tableItemOf.get("table");
//            condition = tableItemOf.get("condition");
//        }
//
//        try {
//            String SQL_SELECT = "SELECT * FROM " + tableName + " WHERE " + condition;
//            ps = conn.prepareStatement(SQL_SELECT);
//            int affectedRowCount = ps.executeUpdate();
//            Assertions.assertThat(affectedRowCount).isEqualTo(1);
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            if (ps != null) {
//                ps.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
    }
}
