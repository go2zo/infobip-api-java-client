package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mt.send.SMSResponse;
import infobip.api.model.sms.mt.send.binary.SMSMultiBinaryRequest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * This is a generated class and is not intended for modification!
 */
public class SendMultipleBinarySms {
    private final Configuration configuration;

    public SendMultipleBinarySms(Configuration configuration) {
        this.configuration = configuration;
    }

    interface SendMultipleBinarySmsService {
        @POST("/sms/1/binary/multi")
        SMSResponse execute(@Body SMSMultiBinaryRequest bodyObject);
    }
    public SMSResponse execute(SMSMultiBinaryRequest bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        SendMultipleBinarySmsService service = retrofit.create(SendMultipleBinarySmsService.class);
        return service.execute(bodyObject);
    }
}
