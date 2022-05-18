package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import oracle.ConnectionProvider;
import org.assertj.core.api.SoftAssertions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static oracle.TableColumns.valueOf;



public class DB_TC005_INVALID_DATA {

//    Connection conn = null;
//    PreparedStatement ps = null;
//    public String table = null;
//    public SQLException oracleException = null;

    @Given("connect to database for invalid data")
    public void connect_to_database_for_invalid_data() {
//        try {
//            conn = ConnectionProvider.getConnection();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            ConnectionProvider.printSQLException(e);
//            e.printStackTrace();
//        }
    }

    @When("try to update {string} set {string} where {string}")
    public void try_to_update_set_where(String table, String condition, String data) {

//        String SQL_UPDATE = "UPDATE " + table + " SET " + valueOf(table).getSecondColumn() + " = ? WHERE " + condition + "";
//        try {
//            // set the prepared statement parameters
//            ps = conn.prepareStatement(SQL_UPDATE);
//            ps.setString(1, data);
//            ps.executeQuery();
//        } catch (SQLException e) {
//            oracleException = ConnectionProvider.printSQLException(e);
//        }
    }

    @Then("should see the error state {string} code {string} message {string}")
    public void should_see_the_error_state_code_message(String sqlstate, String errorcode, String message) {
//        SoftAssertions softly = new SoftAssertions();
//        softly.assertThat(oracleException.getSQLState()).isEqualTo(sqlstate);
//        softly.assertThat(oracleException.getErrorCode()).isEqualTo(Integer.valueOf(errorcode));
//        softly.assertThat(oracleException.getMessage()).containsIgnoringCase(message);
//        softly.assertAll();

    }
}
