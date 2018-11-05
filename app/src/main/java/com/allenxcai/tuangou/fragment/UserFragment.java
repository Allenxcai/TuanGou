package com.allenxcai.tuangou.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.allenxcai.tuangou.R;

/**
 *
 */
public class UserFragment extends Fragment {
    protected GridView mGridView;

    //GridView图标资源
    protected  int [] mGridViewIons={R.mipmap.fly1,R.mipmap.car, R.mipmap.autombile1,R.mipmap.cake,
            R.mipmap.food,R.mipmap.watch, R.mipmap.cp,R.mipmap.phone};
    protected  String [] mGridViewText;

    public UserFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       mGridViewText=this.getActivity().getResources().getStringArray(R.array.HomePage_GridView_Items);

    }
}
