package PersonsStepDefinitions;

import Utils.ConfigReader;
import Utils.RestAssured;
import Utils.WireMock;
import com.google.gson.Gson;

public class PersonsSettings {

    ConfigReader configReader = new ConfigReader();

    public Gson gson = new Gson();
    public WireMock wireMock = new WireMock(configReader.getWireMockPortNumber());
    public RestAssured restAssured = new RestAssured(configReader.getRestAssuredUrl());

}
