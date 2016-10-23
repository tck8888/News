package tck.cn.news.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/23.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    public Context mContext;
    public List<T> mDatas;

    public MyBaseAdapter(Context context, List<T> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas==null?0:mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
