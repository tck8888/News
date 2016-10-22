package tck.cn.news.util;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import tck.cn.news.api.NewsApi;
import tck.cn.news.app.Constant;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class NewsRetrofit {


    private final NewsApi mNewsApi;

    public NewsRetrofit() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(20, TimeUnit.SECONDS);
        client.setReadTimeout(15, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_ERL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        mNewsApi = retrofit.create(NewsApi.class);
    }

    public NewsApi getGirlApi() {
        return mNewsApi;
    }

}
