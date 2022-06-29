package PersonsStepDefinitions;

import Models.PersonsModel.PersonsResponseModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;

public class GetPersons {

    PersonsSettings personsSettings;

    public GetPersons(PersonsSettings personsSettings){
        this.personsSettings=personsSettings;
    }

    @Given("^GET \"(.*)\" endpoint returns (.*) and body list$")
    public void getEndpointReturnsList(String url,int status,List<PersonsResponseModel> personsList){

        personsSettings.wireMock.stubGetResponse(url,personsSettings.gson.toJson(personsList),status);

    }

    @When("^GET \"(.*)\" endpoint is called")
    @When("^GET \"(.*)\" endpoint is called without parameters$")
    public void getEndpointIsCalledWithoutParameters(String endpoint) {

        personsSettings.restAssured
                .setEndpoint(endpoint)
                .sendGetRequest();

    }

    @And("Persons should be")
    public void personsShouldBe(List<PersonsResponseModel> personsList) {

        Assert.assertEquals(personsSettings.gson.toJsonTree(personsSettings.restAssured.getResponseAllFields()),
                            personsSettings.gson.toJsonTree(personsList));

    }

}
