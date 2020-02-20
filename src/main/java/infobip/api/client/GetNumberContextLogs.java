package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.FormattedDate;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.nc.logs.NumberContextLogsResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetNumberContextLogs {
    private final Configuration configuration;

    public GetNumberContextLogs(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetNumberContextLogsService {
        @GET("/number/1/logs")
        NumberContextLogsResponse execute(@Query("to") String to, @Query("bulkId") String[] bulkId, @Query("messageId") String[] messageId, @Query("generalStatus") String generalStatus, @Query("sentSince") FormattedDate sentSince, @Query("sentUntil") FormattedDate sentUntil, @Query("limit") Integer limit, @Query("mcc") String mcc, @Query("mnc") String mnc);
    }
    public NumberContextLogsResponse execute(String to, String[] bulkId, String[] messageId, String generalStatus, FormattedDate sentSince, FormattedDate sentUntil, Integer limit, String mcc, String mnc) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetNumberContextLogsService service = retrofit.create(GetNumberContextLogsService.class);
        return service.execute(to, bulkId, messageId, generalStatus, sentSince, sentUntil, limit, mcc, mnc);
    }
}
