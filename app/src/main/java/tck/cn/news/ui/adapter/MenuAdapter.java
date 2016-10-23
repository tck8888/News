package tck.cn.news.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tck.cn.news.R;
import tck.cn.news.base.MyBaseAdapter;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class MenuAdapter extends MyBaseAdapter<String> {

    private int mClickPosition;//记录当前被选中的条目

    public MenuAdapter(Context context, List<String> datas) {
        super(context, datas);
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

        if (mClickPosition == position) {
            holder.tv.setTextColor(Color.RED);
            holder.iv.setImageResource(R.drawable.menu_arr_select);
        } else {
            holder.tv.setTextColor(Color.WHITE);
            holder.iv.setImageResource(R.drawable.menu_arr_normal);
        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView iv;
        TextView tv;
    }

    public void setClickPosition(int position) {
        mClickPosition = position;
        notifyDataSetChanged();
    }
}
