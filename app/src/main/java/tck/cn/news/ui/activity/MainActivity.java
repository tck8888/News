package tck.cn.news.ui.activity;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import tck.cn.news.R;
import tck.cn.news.ui.fragment.HomeFragment;
import tck.cn.news.ui.fragment.MenuFragment;

public class MainActivity extends SlidingFragmentActivity {

    private MenuFragment mMenuFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置了 主界面的菜单界面
        setBehindContentView(R.layout.activity_menu);

        //得到侧滑菜单对象slidingmenu
        SlidingMenu slidingMenu = getSlidingMenu();
        //设置显示模式
        slidingMenu.setMode(SlidingMenu.LEFT);
        //设置触摸模式

        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        //设置侧滑菜单显示后，内容界面所剩余的宽度
        slidingMenu.setBehindOffsetRes(R.dimen.main_slidingmenu_width);

        //设置侧滑菜单阴影效果
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);


        //将左边菜单帧布局替换为fragment
        mMenuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu, mMenuFragment).commit();
        //.将内容界面进行展示
        HomeFragment homeFragement = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, homeFragement).commit();
    }

    //控制内容界面进行界面切换
    public void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, fragment).commit();
    }

    //将显示在界面上的左侧的菜单fragment返回
    public MenuFragment getMenuFragment() {
        return mMenuFragment;
    }
}
