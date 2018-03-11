package us.mifeng.outeradapter1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import us.mifeng.login.R;
import us.mifeng.outeradapter1.personer.IOutPersener;

/**
 * Created by 黑夜之火 on 2017/7/5.
 */

public class MyAdapter extends BaseAdapter {
    private IOutPersener iOutPersener;
    private List<String>list;
    public MyAdapter(IOutPersener iOutPersener){
        this.iOutPersener = iOutPersener;
        this.list = new ArrayList<>();
    }
    public void setDatas(List<String>datas){
        if (datas!=null&&datas.size()>0){
            list.clear();
            list.addAll(datas);
            notifyDataSetChanged();
        }
    }
    public void addItem(String item){
        list.add(item);
        notifyDataSetChanged();
    }
    public void addMoreData(String item){
        iOutPersener.loadMoreData(item);

    }
    public void removeData(int positon){
        if (list!=null && list.size()>positon){
            list.remove(positon);
            notifyDataSetChanged();
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_outteradapter,null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        vh.text.setText(list.get(position));
        vh.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoreData("new"+list.get(position));
            }
        });
        vh.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeData(position);
            }
        });
        return convertView;
    }
    class ViewHolder{
        TextView text;
        TextView add;
        TextView delete;
        public ViewHolder(View view){
            text = (TextView) view.findViewById(R.id.tv_outter_adapter_text);
            add = (TextView) view.findViewById(R.id.tv_outter_adapter_add);
            delete = (TextView) view.findViewById(R.id.tv_outter_adapter_delete);
        }
    }
}
