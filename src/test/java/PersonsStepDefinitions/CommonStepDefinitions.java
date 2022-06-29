package PersonsStepDefinitions;

import Models.PersonsModel.PersonsRequestModel;
import Models.PersonsModel.PersonsResponseModel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.Map;

public class CommonStepDefinitions {

    PersonsSettings personsSettings;

    public CommonStepDefinitions(PersonsSettings personsSettings){
        this.personsSettings=personsSettings;
    }

    @Before()
    public void beforeTest() {

        personsSettings.wireMock.startWireMock();

    }

    @After()
    public void afterTest() {

        personsSettings.wireMock.resetWireMock();

    }

    @DataTableType
    public PersonsResponseModel createPersonsResponseModel(Map<String,String> tableItems){

        return PersonsResponseModel.createPersonsResponseModel(tableItems);

    }

    @DataTableType
    public PersonsRequestModel createPersonsRequestModel(Map<String,String> tableItems){

        return PersonsRequestModel.createPersonsRequestModel(tableItems);

    }

    @Then("^HTTP status code should be (.*) status code$")
    public void httpStatusCodeShouldBe(int statusCode) {

        Assert.assertEquals(statusCode,personsSettings.restAssured.getResponseStatusCode());

    }

    @Then("^HTTP status code should be (.*) and Message should be \"(.*)\"$")
    public void httpStatusCodeShouldBeAndMessageShouldBe(int statusCode, String message) {

        Assert.assertEquals(statusCode,personsSettings.restAssured.getResponseStatusCode());
        Assert.assertEquals(message,personsSettings.restAssured.getResponseSingleField("Message"));

    }

}
