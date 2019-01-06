package com.example.y700_15.news_lxmodel.model;

import com.example.y700_15.news_lxmodel.api.ProductApi;
import com.example.y700_15.news_lxmodel.contract.ClsContract;
import com.example.y700_15.news_lxmodel.net.OkhttpCallback;
import com.example.y700_15.news_lxmodel.net.OkhttpUtils;

import java.util.HashMap;

public class ClsModel implements ClsContract.IClsModel {


    @Override
    public void getLeftList(HashMap<String, String> params, final ClsModelCallback clsModelCallback) {
        OkhttpUtils.getmInstance().doPost(ProductApi.LEFT_URL, params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                if (clsModelCallback!=null){
                    clsModelCallback.leftFailure(msg);
                }
            }

            @Override
            public void success(String result) {
                if (clsModelCallback!=null){
                    clsModelCallback.leftSuccess(result);
                }
            }
        });
    }

    @Override
    public void getRightList(HashMap<String, String> params, final ClsModelCallback clsModelCallback) {
        OkhttpUtils.getmInstance().doPost(ProductApi.RIGHT_URL, params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                if (clsModelCallback!=null){
                    clsModelCallback.rightFailure(msg);
                }
            }

            @Override
            public void success(String result) {
                if (clsModelCallback!=null){
                    clsModelCallback.rightSUccess(result);
                }
            }
        });
    }

    public interface ClsModelCallback{
        void leftSuccess(String result);
        void rightSUccess(String result);
        void leftFailure(String error);
        void rightFailure(String error);
    }
}
