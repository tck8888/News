package tck.cn.news.ui.menu;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import tck.cn.news.base.BasePage;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/23.
 */

public class NewPage extends BasePage {

    public NewPage(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("新闻");
        return textView;
    }

    @Override
    public void initData() {

    }
}
