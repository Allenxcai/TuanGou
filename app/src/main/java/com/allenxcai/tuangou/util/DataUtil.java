package com.allenxcai.tuangou.util;

import com.allenxcai.tuangou.entity.FoodInfoResult;
import com.allenxcai.tuangou.entity.ItemGridView;
import com.allenxcai.tuangou.entity.ItemRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Project:TuanGou
 * Author:Allenxcai
 * Date:2018/10/14/014
 * Description:
 */
public class DataUtil {

    public static List<ItemGridView> get_HomePage_GridViewItems(int icons[], String names[]) {

        List<ItemGridView> itemGridViewLists = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            ItemGridView itemGridViewList = new ItemGridView(icons[i], names[i]);
            itemGridViewLists.add(itemGridViewList);

        }
        return itemGridViewLists;

    }

    public static List<FoodInfoResult.FoodInfo> getFoodInfoList(String result) {
        FoodInfoResult foodInfoResult = new FoodInfoResult();
        try {

            JSONObject jsonObject = new JSONObject(result);
            List<FoodInfoResult.FoodInfo> FoodInfoList = new ArrayList<>();
            int status = jsonObject.getInt("status");
            JSONArray foodInfos = jsonObject.getJSONArray("data");

            foodInfoResult.setmStatus(status);

            if (foodInfos != null && foodInfos.length() > 0) {
                for (int index = 0; index < foodInfos.length(); index++) {
                    JSONObject foodInfo = (JSONObject) foodInfos.get(index);
                    FoodInfoResult.FoodInfo foodInfoItem = new FoodInfoResult.FoodInfo();

                    foodInfoItem.setmID(foodInfo.getInt("id"));
                    foodInfoItem.setmName(foodInfo.getString("name"));
                    foodInfoItem.setmImageUrl(foodInfo.getString("img"));
                    foodInfoItem.setmPrice(foodInfo.getString("price"));
                    foodInfoItem.setmCount(foodInfo.getString("count"));
                    foodInfoItem.setmDescription(foodInfo.getString("description"));
                    foodInfoItem.setmAction(foodInfo.getString("action"));

                    FoodInfoList.add(foodInfoItem);

                }
                foodInfoResult.setmFoodInfos(FoodInfoList);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return foodInfoResult.getmFoodInfos();
    }

    public static List<FoodInfoResult.FoodInfoDetail> getFoodDetailList(String result) {
        FoodInfoResult foodInfoResult = new FoodInfoResult();

        try {
            JSONObject jsonObject = new JSONObject(result);
            int status = jsonObject.getInt("status");

            foodInfoResult.setmStatus(status);

            FoodInfoResult.FoodInfoDetail foodInfoItem = new FoodInfoResult.FoodInfoDetail();
            List<FoodInfoResult.FoodInfoDetail> FoodInfoList = new ArrayList<>();


            JSONObject foodInfo = jsonObject.getJSONObject("data");
            foodInfoItem.setmID(foodInfo.getInt("id"));
            foodInfoItem.setmName(foodInfo.getString("name"));
            foodInfoItem.setmImageUrl(foodInfo.getString("img"));
            foodInfoItem.setmPrice(foodInfo.getString("price"));
            foodInfoItem.setmTprice(foodInfo.getString("tPrice"));
            foodInfoItem.setmDescription(foodInfo.getString("description"));
            foodInfoItem.setmOriginalprice(foodInfo.getString("originalprice"));
            FoodInfoList.add(foodInfoItem);


            foodInfoResult.setmFoodInfosDetail(FoodInfoList);


        } catch (
                JSONException e) {
            e.printStackTrace();
        }

        return foodInfoResult.getmFoodInfosDetail();
    }


}
