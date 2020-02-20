package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.sms.mt.send.SMSResponse;
import infobip.api.model.sms.mt.send.textual.SMSTextualRequest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * This is a generated class and is not intended for modification!
 */
public class SendSingleTextualSms {
    private final Configuration configuration;

    public SendSingleTextualSms(Configuration configuration) {
        this.configuration = configuration;
    }

    interface SendSingleTextualSmsService {
        @POST("/sms/1/text/single")
        SMSResponse execute(@Body SMSTextualRequest bodyObject);
    }
    public SMSResponse execute(SMSTextualRequest bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        SendSingleTextualSmsService service = retrofit.create(SendSingleTextualSmsService.class);
        return service.execute(bodyObject);
    }
}
