package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mt.reports.SMSReportResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetSentSmsDeliveryReports {
    private final Configuration configuration;

    public GetSentSmsDeliveryReports(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetSentSmsDeliveryReportsService {
        @GET("/sms/1/reports")
        SMSReportResponse execute(@Query("bulkId") String bulkId, @Query("messageId") String messageId, @Query("limit") Integer limit);
    }
    public SMSReportResponse execute(String bulkId, String messageId, Integer limit) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetSentSmsDeliveryReportsService service = retrofit.create(GetSentSmsDeliveryReportsService.class);
        return service.execute(bulkId, messageId, limit);
    }
}
