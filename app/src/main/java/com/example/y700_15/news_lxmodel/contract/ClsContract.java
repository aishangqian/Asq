package com.example.y700_15.news_lxmodel.contract;

import com.example.y700_15.news_lxmodel.bean.LeftClsBean;
import com.example.y700_15.news_lxmodel.bean.RightClsBean;
import com.example.y700_15.news_lxmodel.model.ClsModel;

import java.util.HashMap;
import java.util.List;

public interface ClsContract {

    abstract class ClsPresenter{

        public abstract void getLeftList(HashMap<String,String> params);
        public abstract void getRightList(HashMap<String,String> params);
    }

    public interface IClsModel{

        void getLeftList(HashMap<String,String> params, ClsModel.ClsModelCallback clsModelCallback);
        void getRightList(HashMap<String,String> params, ClsModel.ClsModelCallback clsModelCallback);
    }

    public interface IclsView{

        void leftSuccess(List<LeftClsBean.Cls> leftlist);
        void rightSuccess(List<RightClsBean.Cls> rightlist);
        void leftFailure(String error);
        void rightFailure(String error);
    }
}
