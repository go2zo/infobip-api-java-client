package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.FormattedDate;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mt.logs.SMSLogsResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetSentSmsLogs {
    private final Configuration configuration;

    public GetSentSmsLogs(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetSentSmsLogsService {
        @GET("/sms/1/logs")
        SMSLogsResponse execute(@Query("from") String from, @Query("to") String to, @Query("bulkId") String[] bulkId, @Query("messageId") String[] messageId, @Query("generalStatus") String generalStatus, @Query("sentSince") FormattedDate sentSince, @Query("sentUntil") FormattedDate sentUntil, @Query("limit") Integer limit, @Query("mcc") String mcc, @Query("mnc") String mnc);
    }
    public SMSLogsResponse execute(String from, String to, String[] bulkId, String[] messageId, String generalStatus, FormattedDate sentSince, FormattedDate sentUntil, Integer limit, String mcc, String mnc) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetSentSmsLogsService service = retrofit.create(GetSentSmsLogsService.class);
        return service.execute(from, to, bulkId, messageId, generalStatus, sentSince, sentUntil, limit, mcc, mnc);
    }
}
