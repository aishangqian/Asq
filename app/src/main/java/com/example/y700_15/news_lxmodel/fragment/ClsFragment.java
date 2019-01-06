package com.example.y700_15.news_lxmodel.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.y700_15.news_lxmodel.R;
import com.example.y700_15.news_lxmodel.adapter.LeftAdapter;
import com.example.y700_15.news_lxmodel.adapter.RightAdapter;
import com.example.y700_15.news_lxmodel.bean.LeftClsBean;
import com.example.y700_15.news_lxmodel.bean.RightClsBean;
import com.example.y700_15.news_lxmodel.bean.RightItemAdapter;
import com.example.y700_15.news_lxmodel.contract.ClsContract;
import com.example.y700_15.news_lxmodel.presenter.ClsPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClsFragment extends Fragment implements ClsContract.IclsView,LeftAdapter.ItemclickListener {

    private ClsPresenter clsPresenter;
    private LeftAdapter leftAdapter;

    @BindView(R.id.rv_left)
    RecyclerView leftRv;
    @BindView(R.id.rv_right)
    RecyclerView rightRv;

    private String cid = "1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cls_layout,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData(){
        leftRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rightRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        clsPresenter = new ClsPresenter( this);

        getLeft();

        clsPresenter.getLeftList(new HashMap<String, String>());

    }

    public void getLeft(){
        HashMap<String,String> p2 = new HashMap<>();
        p2.put("cid",cid);
        clsPresenter.getRightList(p2);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void leftSuccess(List<LeftClsBean.Cls> leftlist) {

        if (leftAdapter==null){
            leftAdapter = new LeftAdapter(leftlist,getActivity());
            leftRv.setAdapter(leftAdapter);
            leftAdapter.setItemclickListener(this);

        }else {
            leftAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void rightSuccess(List<RightClsBean.Cls> rightlist) {
        rightRv.setAdapter(new RightAdapter(rightlist,getActivity()));
    }

    @Override
    public void leftFailure(String error) {

    }

    @Override
    public void rightFailure(String error) {

    }

    /**
     * left 点击
     * @param cid
     */
    @Override
    public void click(String cid) {
        getLeft();
    }
}
