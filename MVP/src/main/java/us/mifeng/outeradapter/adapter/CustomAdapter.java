package us.mifeng.outeradapter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import us.mifeng.login.R;
import us.mifeng.outeradapter.presenter.IAdapterPresenter;

/**
 * Created by 黑夜之火 on 2017/7/4.
 */

public class CustomAdapter extends BaseAdapter {
    private IAdapterPresenter iAdapterPresenter;
    private List<String>datas;
    public CustomAdapter(IAdapterPresenter iAdapterPresenter){
        this.iAdapterPresenter = iAdapterPresenter;
        this.datas = new ArrayList<>();
    }
    public void setDatas(List<String>datas){
        if (datas!=null && datas.size()>0){
            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }
    }
    public void addItem(String item){
        datas.add(item);
        notifyDataSetChanged();
    }
    public void removeItem(int postion){
        if (postion>=0&&postion<datas.size()){
            datas.remove(postion);
            notifyDataSetChanged();
        }
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public String getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_outteradapter,null);
            vh = new ViewHolder();
            vh.text = (TextView) convertView.findViewById(R.id.tv_outter_adapter_text);
            vh.add = (TextView) convertView.findViewById(R.id.tv_outter_adapter_add);
            vh.deleter = (TextView) convertView.findViewById(R.id.tv_outter_adapter_delete);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        vh.text.setText(datas.get(position).toString());
        vh.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iAdapterPresenter.loadMoreData("new"+datas.get(position).toString());
            }
        });
        vh.deleter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });



        return convertView;
    }
    class ViewHolder{
        TextView text,add,deleter;
    }
}
