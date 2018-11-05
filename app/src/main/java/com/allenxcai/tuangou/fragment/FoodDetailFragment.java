package com.allenxcai.tuangou.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.allenxcai.tuangou.MainActivity;
import com.allenxcai.tuangou.R;
import com.allenxcai.tuangou.entity.FoodInfoResult;
import com.allenxcai.tuangou.entity.ItemRecyclerView;
import com.allenxcai.tuangou.util.DataUtil;
import com.allenxcai.tuangou.util.NetWorkAgent;
import com.bumptech.glide.Glide;

import java.util.List;

import static android.support.constraint.Constraints.TAG;


public class FoodDetailFragment extends Fragment {
    private ImageView iV_foodpic;
    private TextView tV_orPrice;
    private TextView tV_tPrice;
    private TextView tV_price;
    private TextView tV_desc;
    private TextView tV_name;
    private RatingBar rB_score;


    public FoodDetailFragment() {
    }

    public static FoodDetailFragment newInstance() {
        return new FoodDetailFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_food_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        iV_foodpic = getActivity().findViewById(R.id.homepage_menu2_iv_item_image);
        tV_orPrice = getActivity().findViewById(R.id.homepage_menu2_tv_item_price1);
        tV_tPrice = getActivity().findViewById(R.id.homepage_menu2_tv_item_price2);
        tV_price = getActivity().findViewById(R.id.homepage_menu2_tv_item_price3);
        tV_name = getActivity().findViewById(R.id.homepage_menu2_heard_tv);
        tV_desc = getActivity().findViewById(R.id.homepage_menu2_tv_item_desc);
        rB_score = getActivity().findViewById(R.id.rc_rate);
    }

    private void ShowFoodDetailPage(int position) {
        MainActivity mainActivity = (MainActivity) getContext();

        mainActivity.SwitchFragment("homePageFragment");

    }

    public void updateFoodDetail(String url, final int position) {

        NetWorkAgent.GetNetWorkData("http://www.imooc.com/api/shopping?type=12", new NetWorkAgent.OnGetNetWorkDataListener.SimpleGetNetWorkDataListener() {

            @Override
            public void onSuccess(int code, String netRawData) {

                List<FoodInfoResult.FoodInfoDetail> foodInfoResult = DataUtil.getFoodDetailList(netRawData);


                Glide.with(getContext()).load(foodInfoResult.get(position).getmImageUrl()).placeholder(R.mipmap.ic_launcher).centerCrop().into(iV_foodpic);

                tV_name.setText(foodInfoResult.get(position).getmName());
                tV_orPrice.setText(foodInfoResult.get(position).getmOriginalprice());
                tV_tPrice.setText(foodInfoResult.get(position).getmTprice());
                tV_price.setText(foodInfoResult.get(position).getmPrice());
                tV_desc.setText(foodInfoResult.get(position).getmDescription());


                Log.i(TAG, "onActivityCreated: 222");


            }

            @Override
            public void onFail(int code, FoodInfoResult foodInfoResult, String message) {

            }
        });

    }

}
