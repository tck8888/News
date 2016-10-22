package tck.cn.news.ui.fragment;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import tck.cn.news.R;
import tck.cn.news.base.BaseFragment;
import tck.cn.news.ui.adapter.MenuAdapter;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class MenuFragment extends BaseFragment {

    @BindView(R.id.tv_menu_classify)
    TextView mTvMenuClassify;
    @BindView(R.id.lv_menu_news_center)
    ListView mLvMenuNewsCenter;
    @BindView(R.id.lv_menu_smart_service)
    ListView mLvMenuSmartService;
    @BindView(R.id.lv_menu_govaffairs)
    ListView mLvMenuGovaffairs;

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
    }

    public void initNewsCenterMenu(List<String> newsCenterMenuTitles) {
        newsTitles.clear();
        newsTitles.addAll(newsCenterMenuTitles);

        //得到界面中新闻中心的listview并设置适配器即可

        if (mNewsAdapter==null){
            mNewsAdapter = new MenuAdapter(mContext,newsTitles);
            mLvMenuNewsCenter.setAdapter(mNewsAdapter);
        } else {
            mNewsAdapter.notifyDataSetChanged();
        }
    }
}
