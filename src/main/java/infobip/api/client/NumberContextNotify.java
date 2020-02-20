package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.nc.notify.NumberContextRequest;
import infobip.api.model.nc.notify.NumberContextResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * This is a generated class and is not intended for modification!
 */
public class NumberContextNotify {
    private final Configuration configuration;

    public NumberContextNotify(Configuration configuration) {
        this.configuration = configuration;
    }

    interface NumberContextNotifyService {
        @POST("/number/1/notify")
        NumberContextResponse execute(@Body NumberContextRequest bodyObject);
    }
    public NumberContextResponse execute(NumberContextRequest bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        NumberContextNotifyService service = retrofit.create(NumberContextNotifyService.class);
        return service.execute(bodyObject);
    }
}
