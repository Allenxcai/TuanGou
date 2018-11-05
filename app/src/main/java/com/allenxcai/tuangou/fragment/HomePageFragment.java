package com.allenxcai.tuangou.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.allenxcai.tuangou.MainActivity;
import com.allenxcai.tuangou.R;
import com.allenxcai.tuangou.adapter.GridViewAdapter;
import com.allenxcai.tuangou.adapter.RecViewAdapter;
import com.allenxcai.tuangou.entity.FoodInfoResult;
import com.allenxcai.tuangou.entity.ItemRecyclerView;
import com.allenxcai.tuangou.util.DataUtil;
import com.allenxcai.tuangou.util.NetWorkAgent;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

/**
*HomePage
 */
public class HomePageFragment extends Fragment {


    protected GridView mGridView;
    protected RecyclerView mRecView;
    private GridViewAdapter gridAdapter;
    private RecViewAdapter recViewAdapter;
    ViewGroup viewGroup;

    //GridView图标资源
    protected  int [] mGridViewIons={R.mipmap.fly1,R.mipmap.car, R.mipmap.autombile1,R.mipmap.cake,
            R.mipmap.food,R.mipmap.watch, R.mipmap.cp,R.mipmap.phone};

    protected  String [] mGridViewText;

    protected  List<ItemRecyclerView> mRecyclerViewItems = new ArrayList<ItemRecyclerView>();


    public HomePageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       this.viewGroup=container;
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mGridViewText=this.getActivity().getResources().getStringArray(R.array.HomePage_GridView_Items);

        mGridView =getView().findViewById(R.id.homepage_gridview);
        mRecView =getView().findViewById(R.id.homepage_recyclerview);

        gridAdapter =new GridViewAdapter(getActivity(), DataUtil.get_HomePage_GridViewItems(mGridViewIons,mGridViewText));
        mGridView.setAdapter(gridAdapter);


        Log.i(TAG, "onActivityCreated: 111");
        mRecView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        recViewAdapter = new RecViewAdapter(getActivity(),viewGroup,mRecyclerViewItems);


        recViewAdapter.setItemClickListener(new RecViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
              //  Toast.makeText(getContext(), " "+position,Toast.LENGTH_SHORT).show();

                ShowFoodDetailPage(position);


            }
        });

        mRecView.setAdapter(recViewAdapter);


        NetWorkAgent.GetNetWorkData("http://www.imooc.com/api/shopping?type=11", new NetWorkAgent.OnGetNetWorkDataListener.SimpleGetNetWorkDataListener(){

            @Override
            public void onSuccess(int code, String netRawData) {

                List<FoodInfoResult.FoodInfo> foodInfoResult =DataUtil.getFoodInfoList(netRawData);

                for (int i = 0; i <foodInfoResult.size() ; i++) {

                    ItemRecyclerView itemRecyclerView =new ItemRecyclerView();

                    itemRecyclerView.setiV_Path(foodInfoResult.get(i).getmImageUrl());
                    itemRecyclerView.setAction(foodInfoResult.get(i).getmAction());
                    itemRecyclerView.setCount(foodInfoResult.get(i).getmCount());
                    itemRecyclerView.setName(foodInfoResult.get(i).getmName());
                    itemRecyclerView.setPrice(foodInfoResult.get(i).getmPrice());
                    itemRecyclerView.setDescription(foodInfoResult.get(i).getmDescription());
                    mRecyclerViewItems.add(itemRecyclerView);

 //                   recViewAdapter.setRecyclerViewLists(mRecyclerViewItems);
                   //recViewAdapter.notifyDataSetChanged();
                    recViewAdapter.notifyItemInserted(mRecyclerViewItems.size()-1);

                    Log.i(TAG, "onActivityCreated: 222");                }



            }

            @Override
            public void onFail(int code, FoodInfoResult foodInfoResult, String message) {

            }
        });



    }

    private void ShowFoodDetailPage(int position) {
        MainActivity mainActivity =(MainActivity)getContext();

        mainActivity.SwitchFragment("foodInfoFragment");

        FoodDetailFragment foodDetailFragment=(FoodDetailFragment)getFragmentManager().findFragmentByTag("foodInfoFragment");
        foodDetailFragment.updateFoodDetail("http://www.imooc.com/api/shopping?type=12",0);



    }


}
