package stepdefinitions;

import oracle.ConnectionProvider;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.List;
import java.util.Map;

import static oracle.TableColumns.*;

public class DB_TC003_UPDATE_DATA {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;
    public String tableName = null;
    public String condition = null;
    public String firstColumn = null;
    public String secondColumn = null;
    public String thirdColumn = null;

    @Given("connect to database for updating data")
    public void connect_to_database_for_updating_data() {
        try {
            conn = ConnectionProvider.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            ConnectionProvider.printSQLException(e);
            e.printStackTrace();
        }
    }

    @When("send an update query")
    public void send_an_update_query(@NotNull DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        for (Map<String, String> itemOf : table) {
            tableName = itemOf.get("table");
            condition = itemOf.get("condition");
            firstColumn = itemOf.get("first_column");
            secondColumn = itemOf.get("second_column");
            thirdColumn = itemOf.get("third_column");
        }

        try {
            String SQL_UPDATE = "UPDATE " + tableName + " SET "  + valueOf(tableName).getFirstColumn() + " = ?, "
                    + valueOf(tableName).getSecondColumn() + " = ?, " + valueOf(tableName).getThirdColumn() + " = ? WHERE " + condition + "";

            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, firstColumn);
            ps.setString(2, secondColumn);
            ps.setString(3, thirdColumn);
            ps.executeUpdate();
        } catch (SQLException e) {
            ConnectionProvider.printSQLException(e);
            e.printStackTrace();
        }
    }

    @Then("should see the correct results")
    public void should_see_the_correct_results_of_l0verkoopartikelen(@NotNull DataTable dataTable) throws SQLException {
        List<Map<String, String>> table = dataTable.asMaps();
        for (Map<String, String> itemOf : table) {
            tableName = itemOf.get("table");
            condition = itemOf.get("condition");
            firstColumn = itemOf.get("first_column");
            secondColumn = itemOf.get("second_column");
            thirdColumn = itemOf.get("third_column");
        }

        String SQL_SELECT = "SELECT * FROM " + tableName + " WHERE " + condition;
        ps = conn.prepareStatement(SQL_SELECT);
        resultSet = ps.executeQuery();

        SoftAssertions softly = new SoftAssertions();
        try {
            while(resultSet.next()) {
                softly.assertThat(resultSet.getString(valueOf(tableName).getFirstColumn())).isEqualTo(firstColumn);
                softly.assertThat(resultSet.getString(valueOf(tableName).getSecondColumn())).isEqualTo(secondColumn);
                softly.assertThat(resultSet.getString(valueOf(tableName).getThirdColumn())).isEqualTo(thirdColumn);
                softly.assertAll();
            }
        }  catch (Exception e){
            e.printStackTrace();
        } finally {

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
