package tck.cn.news.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description : 所有的activity的基类
 * <p>
 * Created by tck on 2016/10/21.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        initView();
        iniData();
    }

    protected abstract void iniData();

    protected abstract void initView();


    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
