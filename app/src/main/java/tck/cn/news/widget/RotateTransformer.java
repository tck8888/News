package tck.cn.news.widget;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Description :向导页面的旋转动画效果
 * <p>
 * Created by tck on 2016/10/21.
 */

public class RotateTransformer implements ViewPager.PageTransformer {

    //最大的旋转角度
    private static final float MAX_RADUIS = 25f;

    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        /**
         * 根据当前的position的取值范围在区分a页面与b页面并设置不同的动画
         */
        if (position < -1) {
            view.setRotation(0);
        } else if (position <= 0) {
            /**
             * A页面的取值范围[0,-1]
             * A页面旋转动画[0,-25]
             */
            view.setRotation(position * MAX_RADUIS);
            view.setPivotX(pageWidth / 2);
            view.setPivotY(pageHeight);
        } else if (position <= 1) {
            /**
             *  B页面取值范围[1,0]
             *  B页面旋转动画[25,0]
             */
            view.setRotation(position * MAX_RADUIS);
            view.setPivotX(pageWidth / 2);
            view.setPivotY(pageHeight);
        } else {
            view.setRotation(0);
        }
    }
}
