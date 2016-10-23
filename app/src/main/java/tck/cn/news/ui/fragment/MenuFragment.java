package tck.cn.news.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import tck.cn.news.R;
import tck.cn.news.base.BaseFragment;
import tck.cn.news.ui.activity.MainActivity;
import tck.cn.news.ui.adapter.MenuAdapter;
import tck.cn.news.ui.home.NewsCenterPage;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class MenuFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    @BindView(R.id.tv_menu_classify)
    TextView mTvMenuClassify;
    @BindView(R.id.lv_menu_news_center)
    ListView mLvMenuNewsCenter;
    @BindView(R.id.lv_menu_smart_service)
    ListView mLvMenuSmartService;
    @BindView(R.id.lv_menu_govaffairs)
    ListView mLvMenuGovaffairs;

    //显示新闻中心列表
    public static final int NEWSCENTER = 0;
    //显示智慧服务列表
    public static final int SMARTSERVICE = 1;

    //显示智慧服务的列表
    public static final int GOVAFFAIRS = 2;
    private int type = NEWSCENTER;

    private List<String> newsTitles = new ArrayList<>();
    private MenuAdapter mNewsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_left_menu;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mLvMenuNewsCenter.setOnItemClickListener(this);
    }

    public void initNewsCenterMenu(List<String> newsCenterMenuTitles) {
        newsTitles.clear();
        newsTitles.addAll(newsCenterMenuTitles);

        //得到界面中新闻中心的listview并设置适配器即可

        if (mNewsAdapter == null) {
            mNewsAdapter = new MenuAdapter(mContext, newsTitles);
            mLvMenuNewsCenter.setAdapter(mNewsAdapter);
        } else {
            mNewsAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.lv_menu_news_center:
                //记录当前点击的索引传递给适配器，适配器刷新，getView方法中判断
                mNewsAdapter.setClickPosition(position);
                //关闭侧滑菜单
                slidingMenu.toggle();
                /**
                 * 控制新闻中心界面的切换
                 */
                NewsCenterPage newsCenterPage = ((MainActivity) mContext).getHomeFragment().getNewsCenterPage();
                newsCenterPage.switchPage(position);
                break;
        }
    }

    public void setMenuType(int menuType) {
        mLvMenuSmartService.setVisibility(View.GONE);
        mLvMenuGovaffairs.setVisibility(View.GONE);
        mLvMenuNewsCenter.setVisibility(View.GONE);
        this.type = menuType;

        switch (menuType) {
            case NEWSCENTER:
                mLvMenuNewsCenter.setVisibility(View.VISIBLE);
                break;
            case SMARTSERVICE:
                List<String> smartTitles = new ArrayList<>();
                smartTitles.add("智慧服务1");
                smartTitles.add("智慧服务2");
                smartTitles.add("智慧服务3");
                MenuAdapter smartAdapter = new MenuAdapter(mContext, smartTitles);
                mLvMenuSmartService.setAdapter(smartAdapter);
                mLvMenuSmartService.setVisibility(View.VISIBLE);
                break;
            case GOVAFFAIRS:
                List<String> govaTitles = new ArrayList<>();
                govaTitles.add("政务指南1");
                govaTitles.add("政务指南2");
                govaTitles.add("政务指南3");
                MenuAdapter govaAdapter = new MenuAdapter(mContext, govaTitles);
                mLvMenuGovaffairs.setAdapter(govaAdapter);
                mLvMenuGovaffairs.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
}
