package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.omni.campaign.Campaign;
import infobip.api.model.omni.campaign.Destinations;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * This is a generated class and is not intended for modification!
 */
public class AddDestination {
    private final Configuration configuration;

    public AddDestination(Configuration configuration) {
        this.configuration = configuration;
    }

    interface AddDestinationService {
        @PUT("/omni/2/campaigns/{campaignKey}/destinations")
        Campaign execute(@Path("campaignKey") String campaignKey, @Body Destinations bodyObject);
    }
    public Campaign execute(String campaignKey,Destinations bodyObject) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        AddDestinationService service = retrofit.create(AddDestinationService.class);
        return service.execute(campaignKey, bodyObject);
    }
}
