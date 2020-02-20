package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mt.send.preview.PreviewRequest;
import infobip.api.model.sms.mt.send.preview.PreviewResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * This is a generated class and is not intended for modification!
 */
public class PreviewSms {
    private final Configuration configuration;

    public PreviewSms(Configuration configuration) {
        this.configuration = configuration;
    }

    interface PreviewSmsService {
        @POST("/sms/1/preview")
        PreviewResponse execute(@Body PreviewRequest bodyObject);
    }
    public PreviewResponse execute(PreviewRequest bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        PreviewSmsService service = retrofit.create(PreviewSmsService.class);
        return service.execute(bodyObject);
    }
}
