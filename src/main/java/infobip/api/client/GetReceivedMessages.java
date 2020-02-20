package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mo.reports.MOReportResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetReceivedMessages {
    private final Configuration configuration;

    public GetReceivedMessages(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetReceivedMessagesService {
        @GET("/sms/1/inbox/reports")
        MOReportResponse execute(@Query("limit") Integer limit);
    }
    public MOReportResponse execute(Integer limit) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetReceivedMessagesService service = retrofit.create(GetReceivedMessagesService.class);
        return service.execute(limit);
    }
}
