package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mt.bulks.BulkRequest;
import infobip.api.model.sms.mt.bulks.BulkResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class RescheduleBulk {
    private final Configuration configuration;

    public RescheduleBulk(Configuration configuration) {
        this.configuration = configuration;
    }

    interface RescheduleBulkService {
        @PUT("/sms/1/bulks")
        BulkResponse execute(@Query("bulkId") String bulkId, @Body BulkRequest bodyObject);
    }
    public BulkResponse execute(String bulkId,BulkRequest bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        RescheduleBulkService service = retrofit.create(RescheduleBulkService.class);
        return service.execute(bulkId, bodyObject);
    }
}
