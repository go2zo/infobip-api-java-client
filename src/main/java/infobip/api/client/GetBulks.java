package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mt.bulks.BulkResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetBulks {
    private final Configuration configuration;

    public GetBulks(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetBulksService {
        @GET("/sms/1/bulks")
        BulkResponse execute(@Query("bulkId") String bulkId);
    }
    public BulkResponse execute(String bulkId) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetBulksService service = retrofit.create(GetBulksService.class);
        return service.execute(bulkId);
    }
}
