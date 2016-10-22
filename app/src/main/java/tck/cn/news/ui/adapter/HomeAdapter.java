package tck.cn.news.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tck.cn.news.base.BasePage;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class HomeAdapter extends PagerAdapter {

    private List<BasePage> mBasePages;
    private Context mContext;

    public HomeAdapter(List<BasePage> basePages, Context context) {
        mBasePages = basePages;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mBasePages == null ? 0 : mBasePages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BasePage basePage = mBasePages.get(position);
        container.addView(basePage.getRootView());
        return basePage.getRootView();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }
}
