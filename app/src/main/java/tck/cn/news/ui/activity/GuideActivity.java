package tck.cn.news.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tck.cn.news.R;
import tck.cn.news.base.BaseActivity;
import tck.cn.news.ui.adapter.GuideAdapter;

/**
 * 引导界面的简单实现
 */
public class GuideActivity extends BaseActivity {

    @BindView(R.id.viewpage)
    ViewPager mViewpage;
    private int[] imageResIds = {R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};
    private List<ImageView> mImageViewList;
    private GuideAdapter mGuideAdapter;

    @Override
    protected void iniData() {
        mImageViewList = new ArrayList<>();
        for (int i = 0; i < imageResIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageResIds[i]);
            mImageViewList.add(imageView);
        }

        mGuideAdapter = new GuideAdapter(mImageViewList);

        mViewpage.setAdapter(mGuideAdapter);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

}
