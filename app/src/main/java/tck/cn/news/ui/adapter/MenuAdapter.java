package tck.cn.news.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tck.cn.news.R;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class MenuAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mDatas;

    public MenuAdapter(Context context, List<String> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.layout_item_menu, null);
            holder = new ViewHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.iv_menu_item);
            holder.tv = (TextView) convertView.findViewById(R.id.tv_menu_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(mDatas.get(position));
        return convertView;
    }

    private static class ViewHolder {
        ImageView iv;
        TextView tv;
    }
}
