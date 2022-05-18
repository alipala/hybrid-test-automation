package stepdefinitions;

import oracle.ConnectionProvider;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DB_TC002_SELECT_DATA {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;
    public String tableName = null;
    public String condition = null;
    public String firstColumn = null;
    public String secondColumn = null;
    public String thirdColumn = null;
    public String fourthColumn = null;
    public String fifthColumn = null;

    @Given("connected to database for reading data")
    public void connected_to_database_for_reading_data(){
        try {
            conn = ConnectionProvider.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            ConnectionProvider.printSQLException(e);
            e.printStackTrace();
        }
    }

    @When("select all from table with a condition")
    public void select_all_from_table_with_a_condition(DataTable dataTable) {

        List<Map<String, String>> table = dataTable.asMaps();
        for (Map<String, String> itemOf : table) {
            tableName = itemOf.get("table");
            condition = itemOf.get("where");
        }

        try {
            String SQL_SELECT = "SELECT * FROM " + tableName + " WHERE " + condition;
            ps = conn.prepareStatement(SQL_SELECT);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            ConnectionProvider.printSQLException(e);
            e.printStackTrace();
        }

    }
    @Then("should see the correct results of select")
    public void should_see_the_correct_results_of_select(DataTable dataTable) throws SQLException {

        List<Map<String, String>> table = dataTable.asMaps();

        for (Map<String, String> itemOf : table) {
            firstColumn = itemOf.get("first_column");
            secondColumn = itemOf.get("second_column");
            thirdColumn = itemOf.get("third_column");
            fourthColumn = itemOf.get("fourth_column");
            fifthColumn = itemOf.get("fifth_column");
        }

        try {
            while(resultSet.next()) {
                SoftAssertions softly = new SoftAssertions();
                softly.assertThat(resultSet.getString(1)).isEqualTo(firstColumn);
                softly.assertThat(resultSet.getString(2)).isEqualTo(secondColumn);
                softly.assertThat(resultSet.getString(3)).isEqualTo(thirdColumn);
                softly.assertThat(resultSet.getString(4)).isEqualTo(fourthColumn);
                softly.assertThat(resultSet.getString(5)).isEqualTo(fifthColumn);
                softly.assertAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (resultSet != null) {
                resultSet.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
