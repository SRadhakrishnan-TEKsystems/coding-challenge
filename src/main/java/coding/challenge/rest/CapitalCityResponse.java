package coding.challenge.rest;

import javax.ws.rs.core.Response;

public class CapitalCityResponse {
    private final String body;

    private CapitalCityResponse(Response response){
        body = response != null ? response.readEntity(String.class) : null;
    }

    public static CapitalCityResponse getInstance(Response response) {
        return new CapitalCityResponse(response);
    }

    public CapitalCityResponse getCountries() {
        return null;
    }
}
