package com.example.y700_15.news_lxmodel.bean;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.y700_15.news_lxmodel.R;

import java.util.List;

public class RightItemAdapter extends RecyclerView.Adapter<RightItemAdapter.RightViewHolder> {

    private List<RightClsBean.Cls.Pcls> list;
    private Context context;

    public RightItemAdapter(List<RightClsBean.Cls.Pcls> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_subitem_layout,parent,false);

        RightItemAdapter.RightViewHolder leftViewHolder = new RightItemAdapter.RightViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder, int position) {

        RightClsBean.Cls.Pcls pcls = list.get(position);

        holder.nameTv.setText(pcls.name);

        Glide.with(context).load(pcls.icon).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();//三目运算符
    }

    class RightViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTv;
        private ImageView iv;

        public RightViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
