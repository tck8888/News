package tck.cn.news.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

/**
 * Description :学习自定义viewpage===本项目暂不使用
 * <p>
 * Created by tck on 2016/10/21.
 */

public class CustomViewPage extends ViewPager {

    private static final float MIN_SCALE = 0.75f;
    Map<Integer, ImageView> childViews = new HashMap<>();
    private View mLeftView;
    private View mRightView;

    public CustomViewPage(Context context) {
        super(context);
    }

    public CustomViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void addChildView(ImageView imageView, int position) {
        childViews.put(position, imageView);
    }

    /**
     * 对应的子视图被销毁时，进行删除操作
     *
     * @param position
     */
    public void removeChildView(int position) {
        childViews.remove(position);
    }

    /**
     * 当页面滑动时，该方法被实时调用
     *
     * @param position     当前界面的索引值
     * @param offset       手指滑过的比例值（0,1）
     * @param offsetPixels 手指滑过的像素值(0,屏幕的宽度)
     */
    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        super.onPageScrolled(position, offset, offsetPixels);
        //获取a页面与b页面执行对应的动画
        mLeftView = childViews.get(position);
        mRightView = childViews.get(position + 1);

        //设置对应的动画
        startLauncherAnimation(mLeftView, mRightView, position, offset, offsetPixels);

    }

    private void startLauncherAnimation(View leftView, View rightView, int position, float offset, int offsetPixels) {

        /**
         * 根据当前手指过程中，实时获取的移动像素值计算出将要向左移动的像素值
         */
        if (rightView != null) {
            float translationX = -(rightView.getWidth() - offsetPixels);
            rightView.setTranslationX(translationX);
            //设置缩放动画
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * Math.abs(offset);

            rightView.setScaleX(scaleFactor);
            rightView.setScaleY(scaleFactor);
        }

        if (leftView != null) {
            leftView.bringToFront();
        }

    }
}
