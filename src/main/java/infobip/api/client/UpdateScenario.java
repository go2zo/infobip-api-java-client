package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.omni.scenarios.Scenario;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * This is a generated class and is not intended for modification!
 */
public class UpdateScenario {
    private final Configuration configuration;

    public UpdateScenario(Configuration configuration) {
        this.configuration = configuration;
    }

    interface UpdateScenarioService {
        @PUT("/omni/1/scenarios/{scenarioKey}")
        Scenario execute(@Path("scenarioKey") String scenarioKey, @Body Scenario bodyObject);
    }
    public Scenario execute(String scenarioKey,Scenario bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        UpdateScenarioService service = retrofit.create(UpdateScenarioService.class);
        return service.execute(scenarioKey, bodyObject);
    }
}
