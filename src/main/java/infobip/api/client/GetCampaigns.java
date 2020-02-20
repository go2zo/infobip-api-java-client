package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.omni.campaign.CampaignsResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetCampaigns {
    private final Configuration configuration;

    public GetCampaigns(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetCampaignsService {
        @GET("/omni/1/campaigns")
        CampaignsResponse execute(@Query("limit") Integer limit, @Query("page") Integer page);
    }
    public CampaignsResponse execute(Integer limit, Integer page) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetCampaignsService service = retrofit.create(GetCampaignsService.class);
        return service.execute(limit, page);
    }
}
