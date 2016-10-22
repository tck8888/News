package tck.cn.news.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tck.cn.news.R;
import tck.cn.news.base.BaseFragment;
import tck.cn.news.base.BasePage;
import tck.cn.news.ui.activity.MainActivity;
import tck.cn.news.ui.adapter.HomeAdapter;
import tck.cn.news.ui.home.FuncationPage;
import tck.cn.news.ui.home.GoverPage;
import tck.cn.news.ui.home.NewsCenterPage;
import tck.cn.news.ui.home.SettingPage;
import tck.cn.news.ui.home.SmartServicePage;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.rb_function)
    RadioButton mRbFunction;
    @BindView(R.id.rb_news_center)
    RadioButton mRbNewsCenter;
    @BindView(R.id.rb_smart_service)
    RadioButton mRbSmartService;
    @BindView(R.id.rb_gov_affairs)
    RadioButton mRbGovAffairs;
    @BindView(R.id.rb_setting)
    RadioButton mRbSetting;
    @BindView(R.id.main_radio)
    RadioGroup mMainRadio;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        List<BasePage> homePages = new ArrayList<>();
        homePages.add(new FuncationPage(mContext));
        homePages.add(new NewsCenterPage(mContext));
        homePages.add(new SmartServicePage(mContext));
        homePages.add(new GoverPage(mContext));
        homePages.add(new SettingPage(mContext));

        HomeAdapter homeAdapter = new HomeAdapter(homePages, mContext);

        mViewPager.setAdapter(homeAdapter);

        mMainRadio.setOnCheckedChangeListener((group, checkedId) -> {

            switch (checkedId) {
                case R.id.rb_function:
                    mViewPager.setCurrentItem(0, false);
                    break;
                case R.id.rb_news_center:
                    mViewPager.setCurrentItem(1, false);
                    break;
                case R.id.rb_smart_service:
                    mViewPager.setCurrentItem(2, false);
                    break;
                case R.id.rb_gov_affairs:
                    mViewPager.setCurrentItem(3, false);
                    break;
                case R.id.rb_setting:
                    mViewPager.setCurrentItem(4, false);
                    break;
                default:
                    break;
            }
        });

        /**
         * 默认让首页选中
         */
        mMainRadio.check(R.id.rb_function);
    }


}
