package tck.cn.news.base;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import tck.cn.news.R;
import tck.cn.news.ui.activity.MainActivity;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public abstract class BasePage {

    protected Context mContext;
    private View mView;

    public boolean isLoad = false;//当前页面是否已经加载过数据
    public TextView mTxt_title;
    private final SlidingMenu mSlidingMenu;

    public BasePage(Context context) {
        //必须创建一个view对象
        this.mContext = context;
        mView = initView();
        mSlidingMenu = ((MainActivity) mContext).getSlidingMenu();
    }

    protected abstract View initView();

    public abstract void initData();

    public void initViewTitleBar(View view) {
        Button btn_left = (Button) view.findViewById(R.id.btn_left);
        btn_left.setVisibility(View.GONE);

        ImageButton imgbtn_left = (ImageButton) view.findViewById(R.id.imgbtn_left);
        imgbtn_left.setImageResource(R.drawable.img_menu);
        imgbtn_left.setOnClickListener(v -> {
            mSlidingMenu.toggle();
        });

        mTxt_title = (TextView) view.findViewById(R.id.txt_title);

    }

    public View getRootView() {
        return mView;
    }

}
