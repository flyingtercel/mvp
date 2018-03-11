package us.mifeng.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import us.mifeng.fragment.presenter.IFragmentPresenter;
import us.mifeng.login.R;

/**
 * Created by 黑夜之火 on 2017/6/27.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<String>datas;
    private IFragmentPresenter iFragmentPresenter;

    public MyAdapter(IFragmentPresenter iFragmentPresenter){
        this.iFragmentPresenter = iFragmentPresenter;
        this.datas = new ArrayList<>();
    }
    public void setDatas(List<String>datas){
        if (datas!=null&&datas.size()>0){
            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }
    }
    public String getItems(int position){
        return this.datas.get(position);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview,null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(datas.get(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFragmentPresenter.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_recyclerview_item);
        }
    }
}
