package coding.challenge.rest;

public class CapitalCityRequest {

    private CapitalCityRequest(String countryInput) {

    }

    public static CapitalCityRequest getInstance(String countryInput) {
        return new CapitalCityRequest(countryInput);
    }

    public CapitalCityResponse getCapitalCity() {
        return null;
    }
}

