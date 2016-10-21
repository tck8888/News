package tck.cn.news.util;

import android.content.Context;
import android.content.SharedPreferences;

import tck.cn.news.app.App;

/**
 * Description :关于sharedPreferences的一个工具类
 * <p>
 * Created by tck on 2016/10/21.
 */

public class SpUtil {
    private static final String SP_NAME = "config";

    public static void saveBoolean(String key, boolean value) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    public static Boolean getBoolean(String key, boolean deValue) {
        return getSharedPreferences().getBoolean(SP_NAME, deValue);
    }

    private static SharedPreferences getSharedPreferences() {
        return App.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }
}
