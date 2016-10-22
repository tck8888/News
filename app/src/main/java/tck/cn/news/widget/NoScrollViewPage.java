package tck.cn.news.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Description :自定义viewpage====实现viewpage不能滚动，子view可以响应触摸事件
 * <p>
 * Created by tck on 2016/10/22.
 */

public class NoScrollViewPage extends LazyViewPager {

    public NoScrollViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollViewPage(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
