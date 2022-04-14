package stepDefinitions;

import DBFramework.Actor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import reportConfig.Log;

import java.sql.SQLException;
import java.text.ParseException;

public class DBActorTable extends Actor {
    String actorId = null;
    @Given("I connect DB")
    public void i_connect_db() throws SQLException {
        connect();
        Log.info("connecting DB");
    }
    @When("I Add an actor with {string} and {string} table")
    public void i_add_an_actor_with_and_table(String actorName, String actorLastname) throws SQLException, ParseException {
        actorId = addActor(actorName,actorLastname);
        Assert.assertTrue(!actorId.isEmpty());
        Log.info("Adding a new actor");
    }
    @Then("I should see the actor in actor table")
    public void i_should_see_the_actor_in_actor_table() throws SQLException {
        boolean result = search(actorId);
        Assert.assertTrue(result);
        Log.info("Listing an Actor");
    }
    @When("I update actor name with {string}")
    public void i_update_actor_name_with(String actorName) throws SQLException {
        update(actorId,actorName);
        Log.info("updateActor info");
    }

    @When("I delete actor")
    public void i_delete_actor() throws SQLException {
        delete(actorId);
        Log.info("Delete an actor");
    }
    @Then("I shouldn't see the actor")
    public void i_shouldn_t_see_the_actor() throws SQLException {
        boolean result = search(actorId);
        Assert.assertFalse(result);
        Log.info("Checking deleted actor not exist in the actor table");
    }

    @Then("I disconnect from DB")
    public void i_disconnect_from_db() throws SQLException {
        disconnect();
    }
}
