package tck.cn.news.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Description :向导页面的viewPage的适配器
 * <p>
 * Created by tck on 2016/10/21.
 */

public class GuideAdapter extends PagerAdapter {

    private List<ImageView> guideList;

    public GuideAdapter(List<ImageView> guideList) {
        this.guideList = guideList;
    }

    @Override
    public int getCount() {
        return guideList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = guideList.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
