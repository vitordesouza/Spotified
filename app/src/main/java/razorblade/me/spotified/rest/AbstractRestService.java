package razorblade.me.spotified.rest;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import razorblade.me.spotified.rest.exception.HttpRestException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alexandre on 14/08/16.
 */
public class AbstractRestService {

    private static final String BASE_URL = "https://api.spotify.com/v1/";

    //    private static final String BASE_URL = "http://www.mocky.io/v2/";
    private Retrofit retrofit;
    private Context mContext;


    public AbstractRestService(Context mContext) {
        this.mContext = mContext;
    }

    public Object initializeRestService(Class clazz) {

        OkHttpClient.Builder client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);

               /* if (response.code() >= 400)
                    throw new HttpRestException(response.message(), response.code());*/

                return response;
            }
        });


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        return retrofit.create(clazz);
    }

    public interface OnResponse<T> {
        void success(T t);

        void error(HttpRestException restException);
    }
}
