package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.omni.scenarios.Scenario;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetSpecificScenario {
    private final Configuration configuration;

    public GetSpecificScenario(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetSpecificScenarioService {
        @GET("/omni/1/scenarios/{scenarioKey}")
        Scenario execute(@Path("scenarioKey") String scenarioKey);
    }
    public Scenario execute(String scenarioKey) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetSpecificScenarioService service = retrofit.create(GetSpecificScenarioService.class);
        return service.execute(scenarioKey);
    }
}
