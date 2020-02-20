package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.omni.campaign.Campaign;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetCampaignDetails {
    private final Configuration configuration;

    public GetCampaignDetails(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetCampaignDetailsService {
        @GET("/omni/1/campaigns/{campaignKey}")
        Campaign execute(@Path("campaignKey") String campaignKey);
    }
    public Campaign execute(String campaignKey) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetCampaignDetailsService service = retrofit.create(GetCampaignDetailsService.class);
        return service.execute(campaignKey);
    }
}
