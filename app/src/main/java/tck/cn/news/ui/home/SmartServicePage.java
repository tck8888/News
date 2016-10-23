package tck.cn.news.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tck.cn.news.R;
import tck.cn.news.base.BasePage;
import tck.cn.news.ui.activity.MainActivity;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class SmartServicePage extends BasePage {
    public SmartServicePage(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        TextView textView = new TextView(mContext);

        textView.setText(R.string.tab_smart_service);
        return textView;
    }

    @Override
    public void initData() {
        List<String> smartTitles = new ArrayList<>();
        ((MainActivity) mContext).getMenuFragment().initNewsCenterMenu(smartTitles);
    }

}
