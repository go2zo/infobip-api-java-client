package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mt.bulks.status.BulkStatusResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetBulkStatus {
    private final Configuration configuration;

    public GetBulkStatus(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetBulkStatusService {
        @GET("/sms/1/bulks/status")
        BulkStatusResponse execute(@Query("bulkId") String bulkId);
    }
    public BulkStatusResponse execute(String bulkId) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetBulkStatusService service = retrofit.create(GetBulkStatusService.class);
        return service.execute(bulkId);
    }
}
