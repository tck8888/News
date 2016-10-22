package tck.cn.news.base;

import android.content.Context;
import android.view.View;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public abstract class BasePage {

    protected Context mContext;
    private View mView;

    public BasePage(Context context) {
        //必须创建一个view对象
        this.mContext = context;
        mView = initView();
    }

    protected abstract View initView();

    public View getRootView() {
        return mView;
    }

}
