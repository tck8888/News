package tck.cn.news.ui.activity;


import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import tck.cn.news.R;
import tck.cn.news.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void iniData() {

    }

    @Override
    protected void initView() {
        SlidingMenu menu = new SlidingMenu(this);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        menu.setMode(SlidingMenu.LEFT);
        //把滑动菜单添加进所有的Activity中，可选值SLIDING_CONTENT ， SLIDING_WINDOW
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);

        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.main_slidingmenu_width);

        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);

        //为侧滑菜单设置布局
        menu.setMenu(R.layout.leftmenu);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
