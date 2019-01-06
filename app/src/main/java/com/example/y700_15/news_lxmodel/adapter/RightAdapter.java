package com.example.y700_15.news_lxmodel.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.y700_15.news_lxmodel.R;
import com.example.y700_15.news_lxmodel.bean.RightClsBean;
import com.example.y700_15.news_lxmodel.bean.RightItemAdapter;

import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {

    private List<RightClsBean.Cls> list;
    private Context context;

    public RightAdapter(List<RightClsBean.Cls> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.right_item_layout,parent,false);

        RightAdapter.RightViewHolder leftViewHolder = new RightAdapter.RightViewHolder(view);

        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder, int position) {

        RightClsBean.Cls cls = list.get(position);

        List<RightClsBean.Cls.Pcls> list = cls.list;

        holder.rv.setLayoutManager(new GridLayoutManager(context,3));
        holder.rv.setAdapter(new RightItemAdapter(list,context));

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class RightViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTv;
        private RecyclerView rv;
        public RightViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
            rv = itemView.findViewById(R.id.rv);
        }
    }
}
