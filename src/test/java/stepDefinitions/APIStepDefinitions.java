package stepDefinitions;

import API.APIResources;
import API.TestBaseAPI;
import API.pet.AddNewPet_Payload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;
import static utils.ConfigsReader.getProperty;

import java.io.FileNotFoundException;

public class APIStepDefinitions extends TestBaseAPI {
    RequestSpecification requestSpec;
    Response response;
    String animalId;
    @Given("Building test base")
    public void building_test_base() throws FileNotFoundException {
        requestSpec = given().spec(setUp());
    }
    @When("Check pets {string} with {string} method with {string} API")
    public void check_pets_with_method_with_api(String data, String method, String API) {
        APIResources api = APIResources.valueOf(API);
        if (method.equals("GET"))
         response = requestSpec.queryParam("status",data).
                 when().get(api.getSource());
    }
    @Then("The API get success with status code {int}")
    public void the_api_get_success_with_status_code(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("Get the first available pet's id")
    public void get_the_first_available_pet_s_id() {
        animalId = getKeyValue(response,"id[1]");
    }
    @When("Check the pet info with {string} method with {string} API")
    public void check_the_path_info_with_method_with_api(String method, String API) {
        APIResources api = APIResources.valueOf(API);
        if (animalId != null){
            if (method.equals("GET")){
                response = requestSpec.when().get(api.getSource()+animalId);
            }
        }
    }

    @When("Check the pet info with {string} method and {string} API and id = {string}")
    public void check_the_pet_info_with_method_and_api_and_id(String method, String API, String id) {
        APIResources api = APIResources.valueOf(API);

            if (method.equals("GET")){
                response = requestSpec.when().get(api.getSource()+id);

        }
    }

    @Then("The API get invalid Id supplied with code status {int}")
    public void the_api_get_invalid_id_supplied_with_code_status(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }

    @Given("Authorization for the action")
    public void authorization_for_the_action() {
        requestSpec = requestSpec.header("key",getProperty("key"));
    }

    @Given("Add a new pet with addNewPet Payload and {string} method and {string} API")
    public void add_a_new_pet_with_add_new_pet_payload_and_method_and_api(String method, String API) throws JsonProcessingException {
        APIResources api = APIResources.valueOf(API);
        if (method.equals("POST")){
            ObjectMapper objectMapper = new ObjectMapper();
            String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(AddNewPet_Payload.addNewPet());

            response = requestSpec.body(payload).when().post(api.getSource());
        }
    }

    @Given("Authorization for the action with wrong credential")
    public void authorization_for_the_action_with_wrong_credential() {
        requestSpec = requestSpec.header("key",getProperty("invalidKey"));
    }
    @Then("The API get invalid input status code {int}")
    public void the_api_get_invalid_input_status_code(int statusCode) {
       assertEquals(response.getStatusCode(), statusCode);
    }

    @Given("Add a new pet with addNewPetWrong Payload and {string} method and {string} API")
    public void add_a_new_pet_with_add_new_pet_wrong_payload_and_method_and_api(String method, String API) throws JsonProcessingException {
        APIResources api = APIResources.valueOf(API);
        if (method.equals("POST")){
            ObjectMapper objectMapper = new ObjectMapper();
            String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(AddNewPet_Payload.addNewPetWrong());
            System.out.println(payload);

            response = requestSpec.body(payload).when().post(api.getSource());
            System.out.println(response.getStatusCode());
        }
    }

}
