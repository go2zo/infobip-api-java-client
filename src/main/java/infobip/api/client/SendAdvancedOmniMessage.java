package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.omni.send.OmniAdvancedRequest;
import infobip.api.model.omni.send.OmniResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * This is a generated class and is not intended for modification!
 */
public class SendAdvancedOmniMessage {
    private final Configuration configuration;

    public SendAdvancedOmniMessage(Configuration configuration) {
        this.configuration = configuration;
    }

    interface SendAdvancedOmniMessageService {
        @POST("/omni/1/advanced")
        OmniResponse execute(@Body OmniAdvancedRequest bodyObject);
    }
    public OmniResponse execute(OmniAdvancedRequest bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        SendAdvancedOmniMessageService service = retrofit.create(SendAdvancedOmniMessageService.class);
        return service.execute(bodyObject);
    }
}
