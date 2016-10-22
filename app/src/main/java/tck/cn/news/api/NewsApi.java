package tck.cn.news.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import tck.cn.news.model.Topic;

/**
 * Description :请求地址：http://v.juhe.cn/toutiao/index
 * 请求参数：type=&key=1982e48d495bb67a733e3ddef6b3be83
 * 请求方式：GET
 * <p>
 * Created by tck on 2016/10/22.
 */

public interface NewsApi {

    @GET("toutiao/index")
    Observable<Topic> getTopic(@Query("type") String type, @Query("type") String key);
}
