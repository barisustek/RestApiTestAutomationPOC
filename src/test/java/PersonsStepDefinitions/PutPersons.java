package PersonsStepDefinitions;

import Models.PersonsModel.PersonsRequestModel;
import Models.PersonsModel.PersonsResponseModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;

public class PutPersons {

    PersonsSettings personsSettings;

    public PutPersons(PersonsSettings personsSettings){
        this.personsSettings=personsSettings;
    }

    @Given("^PUT \"(.*)\" endpoint returns (.*) and body list$")
    public void putEndpointReturns(String url,int statusCode, List<PersonsResponseModel> personsList) {

        personsSettings.wireMock.stubPutResponse(url,personsSettings.gson.toJson(personsList),statusCode);

    }

    @When("^PUT \"(.*)\" endpoint is called$")
    public void putEndpointIsCalled(String endpoint,List<PersonsRequestModel> personsList) {

        personsSettings.restAssured
                .setRequestBody(personsSettings.gson.toJson(personsList))
                .setEndpoint(endpoint)
                .sendPutRequest();

    }

    @Then("^PUT \"(.*)\" endpoint returns (.*) status code and Message is \"(.*)\"$")
    public void putEndpointReturnsStatusCodeAndMessageIs(String url, int statusCode, String message) {

        HashMap<String,String> responseMessage = new HashMap<>();
        responseMessage.put("Message",message);

        personsSettings.wireMock.stubPutResponse(url,personsSettings.gson.toJson(responseMessage),statusCode);

    }

}
