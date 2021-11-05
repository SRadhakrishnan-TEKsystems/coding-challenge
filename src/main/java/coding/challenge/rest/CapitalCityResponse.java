package coding.challenge.rest;

import coding.challenge.countries.CapitalCity;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import javax.ws.rs.core.Response;
import java.util.List;

public class CapitalCityResponse {
    private final String body;

    private CapitalCityResponse(Response response){
        body = response != null ? response.readEntity(String.class) : null;
    }

    public static CapitalCityResponse getInstance(Response response) {
        return new CapitalCityResponse(response);
    }

    public CapitalCity getCountries() {
        Gson gson = new Gson();
       List<CapitalCity> capitalCityList=gson.fromJson(body, new TypeToken<List<CapitalCity>>() {}.getType());
        return capitalCityList.get(0);
    }
}
