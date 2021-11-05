package coding.challenge.rest;

import coding.challenge.countries.CapitalCity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class CapitalCityRequest {
    private static String PATH = "https://restcountries.com/v3.1/name/";
    private final Client client;
    private final WebTarget target;

    private CapitalCityRequest(String countryInput) {
        String finalPATH = PATH+countryInput;
        client = ClientBuilder.newBuilder()
                .build();
        target = client.target(UriBuilder.fromPath(finalPATH).queryParam("fullText","true"));
    }

    public static CapitalCityRequest getInstance(String countryInput) {
        return new CapitalCityRequest(countryInput);
    }

    public CapitalCity getCapitalCity() {
        Response response = null;
        try {
            response = target.request().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        CapitalCity capitalCity = CapitalCityResponse.getInstance(response).getCountries();
        return capitalCity;
    }
}

