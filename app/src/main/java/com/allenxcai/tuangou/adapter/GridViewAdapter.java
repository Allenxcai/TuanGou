package com.allenxcai.tuangou.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.allenxcai.tuangou.R;
import com.allenxcai.tuangou.entity.ItemGridView;

import java.util.List;

/**
 * Project:TuanGou
 * Author:Allenxcai
 * Date:2018/10/14/014
 * Description:
 */
public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private List<ItemGridView> gridviewLists;

    public GridViewAdapter(Context context, List<ItemGridView> gridviewLists) {
        this.context = context;
        this.gridviewLists = gridviewLists;
    }


    @Override
    public int getCount() {
        return null!=gridviewLists? gridviewLists.size():0;
    }

    @Override
    public Object getItem(int position) {
        return gridviewLists.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_gridview, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_gridview_iv);
            holder.textView = (TextView) convertView.findViewById(R.id.item_gridview_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ItemGridView gridviewList = gridviewLists.get(position);
        holder.textView.setText(gridviewList.getText());
        holder.imageView.setImageResource(gridviewList.getImageView());


        return convertView;
    }


    public class ViewHolder {
        ImageView imageView;
        TextView textView;
    }


    public void setData(List<ItemGridView> list) {
        gridviewLists = list;
        notifyDataSetChanged();
    }
}
