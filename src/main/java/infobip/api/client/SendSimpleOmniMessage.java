package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.omni.send.OmniResponse;
import infobip.api.model.omni.send.OmniSimpleRequest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * This is a generated class and is not intended for modification!
 */
public class SendSimpleOmniMessage {
    private final Configuration configuration;

    public SendSimpleOmniMessage(Configuration configuration) {
        this.configuration = configuration;
    }

    interface SendSimpleOmniMessageService {
        @POST("/omni/1/text")
        OmniResponse execute(@Body OmniSimpleRequest bodyObject);
    }
    public OmniResponse execute(OmniSimpleRequest bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        SendSimpleOmniMessageService service = retrofit.create(SendSimpleOmniMessageService.class);
        return service.execute(bodyObject);
    }
}
