

package com.allenxcai.tuangou.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.allenxcai.tuangou.R;
import com.allenxcai.tuangou.entity.ItemRecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

/**
 * Project:TuanGou
 * Author:Allenxcai
 * Date:2018/10/15/015
 * Description:
 */
public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> implements View.OnClickListener {
    private List<ItemRecyclerView> recyclerViewLists;
    static int position;

    Context context;
    ViewGroup viewGroup;

    private OnItemClickListener mOnItemClickListener;

    public RecViewAdapter(Context context, ViewGroup viewGroup, List<ItemRecyclerView> recyclerViewLists) {
        this.recyclerViewLists = recyclerViewLists;
        this.context = context;
        this.viewGroup = viewGroup;
    }


    public void setRecyclerViewLists(List<ItemRecyclerView> recyclerViewLists) {
        this.recyclerViewLists = recyclerViewLists;
    }

    @NonNull
    @Override
    public RecViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        Log.i(TAG, "onCreateViewHolder: 3333 ");

        view.setOnClickListener(this);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewAdapter.ViewHolder viewHolder, final int i) {

        Log.i(TAG, "onCreateViewHolder: 4444 ");
        ItemRecyclerView itemRecyclerView = recyclerViewLists.get(i);
        //viewHolder.imageView.setImageBitmap(BitmapFactory.decodeFile(itemRecyclerView.getiV_Path()));
        Glide.with(context).load(itemRecyclerView.getiV_Path()).placeholder(R.mipmap.ic_launcher).centerCrop().into(viewHolder.imageView);

        viewHolder.textView1.setText(itemRecyclerView.getName());
        viewHolder.textView2.setText(itemRecyclerView.getDescription());
        viewHolder.textView3.setText(itemRecyclerView.getPrice());
        viewHolder.textView4.setText(itemRecyclerView.getAction());
        viewHolder.textView5.setText(itemRecyclerView.getCount());

        viewHolder.itemView.setTag(i);


    }


    @Override
    public int getItemCount() {
        return recyclerViewLists.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {

            mOnItemClickListener.onItemClick((int)v.getTag());
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View recyclerView;
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView;
            position = getAdapterPosition();
            imageView = itemView.findViewById(R.id.item_recyclerview_iv);
            textView1 = itemView.findViewById(R.id.item_recyclerview_tv1);
            textView2 = itemView.findViewById(R.id.item_recyclerview_tv2);
            textView3 = itemView.findViewById(R.id.item_recyclerview_tv3);
            textView4 = itemView.findViewById(R.id.item_recyclerview_tv4);
            textView5 = itemView.findViewById(R.id.item_recyclerview_tv5);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener){

        mOnItemClickListener = itemClickListener;
    }


}
