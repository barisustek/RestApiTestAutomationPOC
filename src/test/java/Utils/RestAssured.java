package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class RestAssured {

    private final RequestSpecification request;
    private Response response;
    private JsonPath jpath;
    private final String url;

    public RestAssured(String url) {

        this.url = url;
        this.request = given().header("Content-Type", "application/json").baseUri(this.url);

    }

    public RestAssured setRequestBody(String Body) {

        request.body(Body);
        return this;

    }

    public void sendGetRequest() {

        this.response = request.when().get();

    }

    public void sendPutRequest() {

        this.response = request.when().put();

    }

    public int getResponseStatusCode() {

        return response.statusCode();

    }

    public String getResponseSingleField(String path) {

        jpath = response.jsonPath();
        return jpath.get(path) ;

    }

    public ArrayList<String> getResponseAllFields() {

        jpath = response.jsonPath();
        return jpath.get() ;

    }

    public RestAssured setEndpoint(String endpoint) {

        request.baseUri(this.url + endpoint);
        return this;

    }

}