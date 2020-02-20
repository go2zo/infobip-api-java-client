package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.FormattedDate;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mo.logs.MOLogsResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetReceivedSmsLogs {
    private final Configuration configuration;

    public GetReceivedSmsLogs(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetReceivedSmsLogsService {
        @GET("/sms/1/inbox/logs")
        MOLogsResponse execute(@Query("to") String to, @Query("receivedSince") FormattedDate receivedSince, @Query("receivedUntil") FormattedDate receivedUntil, @Query("limit") Integer limit, @Query("keyword") String keyword);
    }
    public MOLogsResponse execute(String to, FormattedDate receivedSince, FormattedDate receivedUntil, Integer limit, String keyword) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetReceivedSmsLogsService service = retrofit.create(GetReceivedSmsLogsService.class);
        return service.execute(to, receivedSince, receivedUntil, limit, keyword);
    }
}
