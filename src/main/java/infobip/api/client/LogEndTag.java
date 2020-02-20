package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.conversion.EndTagResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * This is a generated class and is not intended for modification!
 */
public class LogEndTag {
    private final Configuration configuration;

    public LogEndTag(Configuration configuration) {
        this.configuration = configuration;
    }

    interface LogEndTagService {
        @POST("/ct/1/log/end/{messageId}")
        EndTagResponse execute(@Path("messageId") String messageId);
    }
    public EndTagResponse execute(String messageId) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        LogEndTagService service = retrofit.create(LogEndTagService.class);
        return service.execute(messageId);
    }
}
