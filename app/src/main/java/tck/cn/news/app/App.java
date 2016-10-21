package tck.cn.news.app;

import android.app.Application;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/21.
 */

public class App extends Application {

    public static App INSTANCE;

    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
