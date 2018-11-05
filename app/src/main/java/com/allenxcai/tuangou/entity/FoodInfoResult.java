package com.allenxcai.tuangou.entity;

import java.util.List;

/**
 * Project:TuanGou
 * Author:Allenxcai
 * Date:2018/10/16/016
 * Description:
 */

public class FoodInfoResult {
    private int mStatus;
    private List<FoodInfo> mFoodInfos;
    private List<FoodInfoDetail> mFoodInfosDetail;

    public FoodInfoResult() {
    }

    public FoodInfoResult(int mStatus, List<FoodInfo> mFoodInfos,List<FoodInfo> mFoodInfosDetail) {
        this.mStatus = mStatus;
        this.mFoodInfos = mFoodInfos;
        this.mFoodInfos = mFoodInfosDetail;
    }

    public int getmStatus() {
        return mStatus;
    }

    public void setmStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public List<FoodInfo> getmFoodInfos() {
        return mFoodInfos;
    }

    public void setmFoodInfos(List<FoodInfo> mFoodInfos) {
        this.mFoodInfos = mFoodInfos;
    }

    public List<FoodInfoDetail> getmFoodInfosDetail() {
        return mFoodInfosDetail;
    }

    public void setmFoodInfosDetail(List<FoodInfoDetail> mFoodInfosDetail) {
        this.mFoodInfosDetail = mFoodInfosDetail;
    }

    public static class FoodInfo {

        private int mID;
        private String mName;
        private String mImageUrl;
        private String mCount;
        private String mDescription;
        private String mAction;
        private String mPrice;

        public FoodInfo() {
        }

        public FoodInfo(int mID, String mName, String mImageUrl, String mCount, String mDescription, String mAction, String mPrice) {
            this.mID = mID;
            this.mName = mName;
            this.mImageUrl = mImageUrl;
            this.mCount = mCount;
            this.mDescription = mDescription;
            this.mAction = mAction;
            this.mPrice = mPrice;
        }

        public int getmID() {
            return mID;
        }

        public void setmID(int mID) {
            this.mID = mID;
        }

        public String getmName() {
            return mName;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }

        public String getmImageUrl() {
            return mImageUrl;
        }

        public void setmImageUrl(String mImageUrl) {
            this.mImageUrl = mImageUrl;
        }

        public String getmCount() {
            return mCount;
        }

        public void setmCount(String mCount) {
            this.mCount = mCount;
        }

        public String getmDescription() {
            return mDescription;
        }

        public void setmDescription(String mDescription) {
            this.mDescription = mDescription;
        }

        public String getmAction() {
            return mAction;
        }

        public void setmAction(String mAction) {
            this.mAction = mAction;
        }

        public String getmPrice() {
            return mPrice;
        }

        public void setmPrice(String mPrice) {
            this.mPrice = mPrice;
        }
    }
    public static class FoodInfoDetail {

        private int mID;
        private String mName;
        private String mImageUrl;
        private String mOriginalprice;
        private String mDescription;
        private String mTprice;
        private String mPrice;
        private String mMsg;

        public FoodInfoDetail() {
        }

        public FoodInfoDetail(int mID, String mName, String mImageUrl, String mOriginalprice, String mDescription, String mTprice, String mPrice, String mMsg) {
            this.mID = mID;
            this.mName = mName;
            this.mImageUrl = mImageUrl;
            this.mOriginalprice = mOriginalprice;
            this.mDescription = mDescription;
            this.mTprice = mTprice;
            this.mPrice = mPrice;
            this.mMsg = mMsg;
        }

        public int getmID() {
            return mID;
        }

        public void setmID(int mID) {
            this.mID = mID;
        }

        public String getmName() {
            return mName;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }

        public String getmImageUrl() {
            return mImageUrl;
        }

        public void setmImageUrl(String mImageUrl) {
            this.mImageUrl = mImageUrl;
        }

        public String getmOriginalprice() {
            return mOriginalprice;
        }

        public void setmOriginalprice(String mOriginalprice) {
            this.mOriginalprice = mOriginalprice;
        }

        public String getmDescription() {
            return mDescription;
        }

        public void setmDescription(String mDescription) {
            this.mDescription = mDescription;
        }

        public String getmTprice() {
            return mTprice;
        }

        public void setmTprice(String mTprice) {
            this.mTprice = mTprice;
        }

        public String getmPrice() {
            return mPrice;
        }

        public void setmPrice(String mPrice) {
            this.mPrice = mPrice;
        }

        public String getmMsg() {
            return mMsg;
        }

        public void setmMsg(String mMsg) {
            this.mMsg = mMsg;
        }
    }


}

