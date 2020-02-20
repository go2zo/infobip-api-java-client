package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.omni.scenarios.Scenario;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * This is a generated class and is not intended for modification!
 */
public class CreateScenario {
    private final Configuration configuration;

    public CreateScenario(Configuration configuration) {
        this.configuration = configuration;
    }

    interface CreateScenarioService {
        @POST("/omni/1/scenarios")
        Scenario execute(@Body Scenario bodyObject);
    }
    public Scenario execute(Scenario bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        CreateScenarioService service = retrofit.create(CreateScenarioService.class);
        return service.execute(bodyObject);
    }
}
