package tck.cn.news.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tck.cn.news.R;
import tck.cn.news.base.BaseActivity;
import tck.cn.news.ui.adapter.GuideAdapter;
import tck.cn.news.util.DensityUtil;
import tck.cn.news.widget.RotateTransformer;

/**
 * 引导界面的简单实现
 */
public class GuideActivity extends BaseActivity {

    @BindView(R.id.viewpage)
    ViewPager mViewpage;
    @BindView(R.id.iv_focus)
    ImageView mIvFocus;
    @BindView(R.id.linearlayout)
    LinearLayout mLinearlayout;
    @BindView(R.id.jump)
    Button mJump;
    @BindView(R.id.activity_guide)
    RelativeLayout mActivityGuide;

    private int[] imageResIds = {R.mipmap.tutorial_1_bg, R.mipmap.tutorial_2_bg, R.mipmap.tutorial_app_bg};
    private List<ImageView> mImageViewList;
    private GuideAdapter mGuideAdapter;

    /**
     * 底部点之间的间距
     */
    private int mPointMargin;

    @Override
    protected void iniData() {
        /**
         * 添加图片
         */
        mImageViewList = new ArrayList<>();
        for (int i = 0; i < imageResIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageResIds[i]);
            mImageViewList.add(imageView);
        }

        mGuideAdapter = new GuideAdapter(mImageViewList);
        mViewpage.setAdapter(mGuideAdapter);
        /**
         * 设置viewpage切换动画
         */
        mViewpage.setPageTransformer(true, new RotateTransformer());
        mViewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //当手指移动时，实时地将选中点进行x轴的平移操作
                mIvFocus.setTranslationX((positionOffset + position) * mPointMargin);
            }

            @Override
            public void onPageSelected(int position) {
                if (position == mImageViewList.size() - 1) {
                    mJump.setVisibility(View.VISIBLE);
                } else {
                    mJump.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        /**
         * 等界面绘制完成后才去拿对应的值（getleft,getwidth,getheight都是在view显示之后去获取）
         */
        mIvFocus.postDelayed(new Runnable() {
            @Override
            public void run() {
                //获取2点之间的间距
                mPointMargin = mLinearlayout.getChildAt(1).getLeft() - mLinearlayout.getChildAt(0).getLeft();
            }
        }, 10);

    }

    @Override
    protected void initView() {

        /**
         * 动态的添加小圆点
         */
        for (int i = 0; i < imageResIds.length; i++) {
            ImageView point = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DensityUtil.dip2px(this, 30),
                    DensityUtil.dip2px(this, 30));
            if (i != 0) {
                layoutParams.leftMargin = DensityUtil.dip2px(this, 10);
            }
            point.setLayoutParams(layoutParams);
            point.setBackgroundResource(R.mipmap.ic_unselect);

            mLinearlayout.addView(point);
        }


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }


    @OnClick(R.id.jump)
    public void onClick() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
