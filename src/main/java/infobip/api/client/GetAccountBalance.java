package infobip.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infobip.api.config.Configuration;
import infobip.api.config.TimeoutClientProvider;
import infobip.api.model.account.AccountBalance;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * This is a generated class and is not intended for modification!
 */
public class GetAccountBalance {
    private final Configuration configuration;

    public GetAccountBalance(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetAccountBalanceService {
        @GET("/account/1/balance")
        AccountBalance execute();
    }
    public AccountBalance execute() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new TimeoutClientProvider(configuration).get())
                .build();

        GetAccountBalanceService service = retrofit.create(GetAccountBalanceService.class);
        return service.execute();
    }
}
