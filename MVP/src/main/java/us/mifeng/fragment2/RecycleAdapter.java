package us.mifeng.fragment2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import us.mifeng.fragment2.event.IFragmentPersoner;
import us.mifeng.login.R;

/**
 * Created by 黑夜之火 on 2017/6/30.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{
    private List<String>list;
    private IFragmentPersoner iFragmentPersoner;
    public RecycleAdapter(IFragmentPersoner iFragmentPersoner){
        this.iFragmentPersoner = iFragmentPersoner;
        this.list = new ArrayList<>();
    }
    public void setListData(List<String>list){
        if (list!=null && list.size()>0&&iFragmentPersoner!=null){
            this.list.clear();
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }
    public String getItems(int postion){
        return list.get(postion);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview,null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(list.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFragmentPersoner.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_recyclerview_item);
        }
    }
}
