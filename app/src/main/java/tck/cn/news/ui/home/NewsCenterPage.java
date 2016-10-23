package tck.cn.news.ui.home;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
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
import tck.cn.news.ui.menu.ActionPage;
import tck.cn.news.ui.menu.NewPage;
import tck.cn.news.ui.menu.PicPage;
import tck.cn.news.ui.menu.Topic;
import tck.cn.news.util.SpUtil;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class NewsCenterPage extends BasePage {

    private static final int KEY_UPDATE = 1000;
    private List<BasePage> mNewsCenterPage;
    private FrameLayout mNews_center_fl;


    private List<String> newsCenterMenuTitles = new ArrayList<>();//新闻中心列表的标题数据集合

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case KEY_UPDATE:
                    MenuFragment menuFragment = ((MainActivity) mContext).getMenuFragment();
                    menuFragment.initNewsCenterMenu(newsCenterMenuTitles);

                    //默认让新闻中心显示新闻页面
                    switchPage(0);
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
        View view = View.inflate(mContext, R.layout.news_center_frame, null);
        mNews_center_fl = (FrameLayout) view.findViewById(R.id.news_center_fl);

        initViewTitleBar(view);
        return view;
    }

    @Override
    public void initData() {
        String string = SpUtil.getString(Constant.NEW_CENTER, "");
        if (!TextUtils.isEmpty(string)) {
            parseJson(string);
        }

        getNetData();

    }

    private void getNetData() {
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
                System.out.println("解析数据");
                parseJson(json);

            }
        });
    }

    private void parseJson(String json) {

        isLoad = true;
        /**
         * 页面数据保存(一般使用数据库保存)
         */
        SpUtil.saveString(Constant.NEW_CENTER, json);

        Gson gson = new Gson();
        NewsCenterBean newsCenterBean = gson.fromJson(json, NewsCenterBean.class);
        List<NewsCenterBean.DataBean> data = newsCenterBean.getData();

        newsCenterMenuTitles.clear();

        for (NewsCenterBean.DataBean dataBean : data) {
            newsCenterMenuTitles.add(dataBean.getTitle());
        }

        /**
         * 创建新闻中心所有的页面对象
         */
        mNewsCenterPage = new ArrayList<>();
        mNewsCenterPage.add(new NewPage(mContext));
        mNewsCenterPage.add(new Topic(mContext));
        mNewsCenterPage.add(new PicPage(mContext));
        mNewsCenterPage.add(new ActionPage(mContext));

        mHandler.sendEmptyMessage(KEY_UPDATE);
    }


    public void switchPage(int position) {
        //动态设置标题
        mTxt_title.setText(newsCenterMenuTitles.get(position));
        System.out.println(newsCenterMenuTitles.get(position));
        BasePage basePage = mNewsCenterPage.get(position);

        mNews_center_fl.removeAllViews();
        mNews_center_fl.addView(basePage.getRootView());
    }
}
