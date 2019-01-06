package com.example.y700_15.news_lxmodel.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.y700_15.news_lxmodel.R;
import com.example.y700_15.news_lxmodel.bean.LeftClsBean;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHolder> {

    private List<LeftClsBean.Cls> list;
    private Context context;

    public LeftAdapter(List<LeftClsBean.Cls> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_item_layout,parent,false);

        LeftViewHolder leftViewHolder = new LeftViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolder holder, int position) {
        final LeftClsBean.Cls cls = list.get(position);
        holder.nameTv.setText(cls.name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemclickListener!=null){
                    itemclickListener.click(cls.cid);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();//三目运算符
    }

    class LeftViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTv;
        public LeftViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
        }
    }

    private ItemclickListener itemclickListener;

    public void setItemclickListener(ItemclickListener itemclickListener) {
        this.itemclickListener = itemclickListener;
    }

    public interface ItemclickListener{
        void click(String cid);
    }
}
