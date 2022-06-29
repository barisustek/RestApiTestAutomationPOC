package Utils;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.Rule;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class WireMock {

    @Rule
    private final WireMockServer wireMockServer ;

    public WireMock(int port){

        wireMockServer = new WireMockServer(options().port(port));

    }

    public void startWireMock(){

        wireMockServer.start();

    }

    public void resetWireMock(){

        while (wireMockServer.isRunning()){
            wireMockServer.shutdownServer();
        }

    }

    public void stubPutResponse(String url, String bodyList, int status){

        wireMockServer.stubFor(put(urlEqualTo(url))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(bodyList).withStatus(status)));

    }

    public void stubGetResponse(String url, String bodyList, int status){

        wireMockServer.stubFor(get(urlEqualTo(url))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(bodyList).withStatus(status)));

    }

}
