package tck.cn.news.ui.fragment;


import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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
import tck.cn.news.widget.LazyViewPager;
import tck.cn.news.widget.NoScrollViewPage;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class HomeFragment extends BaseFragment implements LazyViewPager.OnPageChangeListener {

    @BindView(R.id.view_pager)
    NoScrollViewPage mViewPager;
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
    private List<BasePage> mHomePages;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mHomePages = new ArrayList<>();
        mHomePages.add(new FuncationPage(mContext));
        mHomePages.add(new NewsCenterPage(mContext));
        mHomePages.add(new SmartServicePage(mContext));
        mHomePages.add(new GoverPage(mContext));
        mHomePages.add(new SettingPage(mContext));

        HomeAdapter homeAdapter = new HomeAdapter(mHomePages, mContext);

        mViewPager.setAdapter(homeAdapter);

        mMainRadio.setOnCheckedChangeListener((group, checkedId) -> {

            switch (checkedId) {
                case R.id.rb_function:
                    mViewPager.setCurrentItem(0, false);
                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                    break;
                case R.id.rb_news_center:
                    mViewPager.setCurrentItem(1, false);
                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                    mMenuFragment.setMenuType(MenuFragment.NEWSCENTER);
                    break;
                case R.id.rb_smart_service:
                    mViewPager.setCurrentItem(2, false);
                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                    mMenuFragment.setMenuType(MenuFragment.SMARTSERVICE);
                    break;
                case R.id.rb_gov_affairs:
                    mViewPager.setCurrentItem(3, false);
                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                    mMenuFragment.setMenuType(MenuFragment.GOVAFFAIRS);
                    break;
                case R.id.rb_setting:
                    mViewPager.setCurrentItem(4, false);
                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                    break;
                default:
                    break;
            }
        });

        /**
         * 默认让首页选中
         */
        mMainRadio.check(R.id.rb_function);
        mViewPager.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        BasePage basePage = mHomePages.get(position);
        basePage.initData();
        if (!basePage.isLoad) {

            basePage.initData();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public NewsCenterPage getNewsCenterPage() {
        NewsCenterPage newsCenterPage = (NewsCenterPage) mHomePages.get(1);
        return newsCenterPage;
    }
}
