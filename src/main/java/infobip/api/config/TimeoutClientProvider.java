package infobip.api.config;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TimeoutClientProvider {
	private final Configuration configuration;

	private Interceptor interceptor;

	public TimeoutClientProvider(Configuration configuration) {
		this.configuration = configuration;
	}

	public OkHttpClient get() {
		final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		httpClient.addInterceptor(getInterceptor());

		OkHttpClient okHttpClient = httpClient
				.callTimeout(configuration.getReadTimeout(), TimeUnit.MILLISECONDS)
				.connectTimeout(configuration.getConnectionTimeout(), TimeUnit.MILLISECONDS)
				.build();

		return okHttpClient;
	}

	public TimeoutClientProvider setInterceptor(Interceptor interceptor) {
		this.interceptor = interceptor;
		return this;
	}

	private Interceptor getInterceptor() {
		if (interceptor == null) {
			interceptor = new Interceptor() {
				@Override
				public Response intercept(Chain chain) throws IOException {
					Request original = chain.request();

					// Customize the request
					Request request = original.newBuilder()
							.header("Authorization", configuration.getAuthorizationHeader())
							.header("User-Agent", "Java-Client-Library")
							.method(original.method(), original.body())
							.build();

					Response response = chain.proceed(request);

					// Customize or return the response
					return response;
				}
			};
		}
		return interceptor;
	}
}
