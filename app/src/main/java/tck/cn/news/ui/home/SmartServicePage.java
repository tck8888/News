package tck.cn.news.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import tck.cn.news.R;
import tck.cn.news.base.BasePage;

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
}
