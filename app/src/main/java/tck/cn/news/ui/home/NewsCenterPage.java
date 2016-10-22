package tck.cn.news.ui.home;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tck.cn.news.R;
import tck.cn.news.app.Constant;
import tck.cn.news.base.BasePage;
import tck.cn.news.model.NewsCenterBean;
import tck.cn.news.ui.activity.MainActivity;
import tck.cn.news.ui.fragment.MenuFragment;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class NewsCenterPage extends BasePage {

    private static final int KEY_UPDATE = 1000;

    private List<String> newsCenterMenuTitles = new ArrayList<>();//新闻中心列表的标题数据集合

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case KEY_UPDATE:
                    MenuFragment menuFragment = ((MainActivity) mContext).getMenuFragment();
                    menuFragment.initNewsCenterMenu(newsCenterMenuTitles);
                    break;
                default:
                    break;
            }
        }
    };

    public NewsCenterPage(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        TextView textView = new TextView(mContext);

        textView.setText(R.string.tab_news_center);
        return textView;
    }

    @Override
    public void initData() {

        Request request = new Request.Builder().url(Constant.NEW_CENTER).build();

        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                //请求失败
                System.out.println("请求失败");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String json = response.body().string();
                System.out.println(json);
                parseJson(json);

            }
        });
    }

    private void parseJson(String json) {
        Gson gson = new Gson();
        NewsCenterBean newsCenterBean = gson.fromJson(json, NewsCenterBean.class);
        List<NewsCenterBean.DataBean> data = newsCenterBean.getData();

        newsCenterMenuTitles.clear();

        for (NewsCenterBean.DataBean dataBean : data) {
            newsCenterMenuTitles.add(dataBean.getTitle());
        }

        mHandler.sendEmptyMessage(KEY_UPDATE);
    }

}
