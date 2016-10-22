package tck.cn.news.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tck.cn.news.R;
import tck.cn.news.base.BasePage;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class SettingPage extends BasePage {

    public SettingPage(Context context) {
        super(context);
    }

    @Override
    protected View initView() {

        ListView lv = new ListView(mContext);
        List<String> strings = initData();
        ArrayAdapter adpater = new ArrayAdapter(mContext, android.R.layout.test_list_item, strings);
        lv.setAdapter(adpater);

        return lv;
    }

    private List<String> initData() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            strings.add(i + "");
        }
        return strings;
    }
}
