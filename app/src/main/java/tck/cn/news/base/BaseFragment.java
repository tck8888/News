package tck.cn.news.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import tck.cn.news.ui.activity.MainActivity;
import tck.cn.news.ui.fragment.MenuFragment;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public abstract class BaseFragment extends RxFragment {

    protected Context mContext;
    private Unbinder mUnbinder;
    public SlidingMenu slidingMenu;
    public MenuFragment mMenuFragment;

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        slidingMenu = ((MainActivity) mContext).getSlidingMenu();
        mMenuFragment = ((MainActivity) mContext).getMenuFragment();

        initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
