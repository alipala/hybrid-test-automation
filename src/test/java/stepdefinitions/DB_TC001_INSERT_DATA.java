package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;

public class DB_TC001_INSERT_DATA {

//    Connection conn = null;
//    Statement stmt = null;
//    ResultSet resultSet = null;

    @Given("connected to database")
    public void connected_to_database() throws SQLException, ClassNotFoundException {
//        conn = ConnectionProvider.getConnection();
    }

    @When("run the insert into query")
    public void run_the_insert_into_query() throws SQLException {
//        stmt = conn.createStatement();
//        resultSet = stmt.executeQuery("SELECT * FROM L0COLLI where omschr = 'steenbreek'");
    }

    @Then("should see the results of select operation")
    public void should_see_the_results_of_select_operation() throws SQLException{
//        try {
//            while (resultSet.next()) {
//                System.out.println("Result set retrieved");
//                // Retrieve the data of a specific column
//                System.out.print(resultSet.getString(1));
//                System.out.print(" " + resultSet.getString(2));
//                System.out.print(" " + resultSet.getString(3));
//                System.out.println(" " + resultSet.getString(4));
//
//                assertThat(resultSet.getString(4)).contains("86872");
//
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            if (stmt != null) {
//                stmt.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
    }

}
