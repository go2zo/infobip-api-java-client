package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mt.bulks.status.BulkStatusResponse;
import infobip.api.model.sms.mt.bulks.status.UpdateStatusRequest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class ManageBulkStatus {
    private final Configuration configuration;

    public ManageBulkStatus(Configuration configuration) {
        this.configuration = configuration;
    }

    interface ManageBulkStatusService {
        @PUT("/sms/1/bulks/status")
        BulkStatusResponse execute(@Query("bulkId") String bulkId, @Body UpdateStatusRequest bodyObject);
    }
    public BulkStatusResponse execute(String bulkId,UpdateStatusRequest bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        ManageBulkStatusService service = retrofit.create(ManageBulkStatusService.class);
        return service.execute(bulkId, bodyObject);
    }
}
