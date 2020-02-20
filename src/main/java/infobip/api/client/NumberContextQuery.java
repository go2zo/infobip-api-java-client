package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.nc.query.NumberContextRequest;
import infobip.api.model.nc.query.NumberContextResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * This is a generated class and is not intended for modification!
 */
public class NumberContextQuery {
    private final Configuration configuration;

    public NumberContextQuery(Configuration configuration) {
        this.configuration = configuration;
    }

    interface NumberContextQueryService {
        @POST("/number/1/query")
        NumberContextResponse execute(@Body NumberContextRequest bodyObject);
    }
    public NumberContextResponse execute(NumberContextRequest bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        NumberContextQueryService service = retrofit.create(NumberContextQueryService.class);
        return service.execute(bodyObject);
    }
}
