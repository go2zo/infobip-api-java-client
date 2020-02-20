package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.omni.reports.OMNIReportsResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetOMNIReports {
    private final Configuration configuration;

    public GetOMNIReports(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetOMNIReportsService {
        @GET("/omni/1/reports")
        OMNIReportsResponse execute(@Query("bulkId") String bulkId, @Query("messageId") String messageId, @Query("limit") Integer limit, @Query("channel") String channel);
    }
    public OMNIReportsResponse execute(String bulkId, String messageId, Integer limit, String channel) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetOMNIReportsService service = retrofit.create(GetOMNIReportsService.class);
        return service.execute(bulkId, messageId, limit, channel);
    }
}
