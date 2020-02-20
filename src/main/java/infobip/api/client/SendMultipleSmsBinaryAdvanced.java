package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mt.send.SMSResponse;
import infobip.api.model.sms.mt.send.binary.SMSAdvancedBinaryRequest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * This is a generated class and is not intended for modification!
 */
public class SendMultipleSmsBinaryAdvanced {
    private final Configuration configuration;

    public SendMultipleSmsBinaryAdvanced(Configuration configuration) {
        this.configuration = configuration;
    }

    interface SendMultipleSmsBinaryAdvancedService {
        @POST("/sms/1/binary/advanced")
        SMSResponse execute(@Body SMSAdvancedBinaryRequest bodyObject);
    }
    public SMSResponse execute(SMSAdvancedBinaryRequest bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        SendMultipleSmsBinaryAdvancedService service = retrofit.create(SendMultipleSmsBinaryAdvancedService.class);
        return service.execute(bodyObject);
    }
}
