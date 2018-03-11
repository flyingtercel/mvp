package us.mifeng.outeradapter1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import us.mifeng.login.R;
import us.mifeng.outeradapter1.adapter.MyAdapter;
import us.mifeng.outeradapter1.personer.IOutPersener;
import us.mifeng.outeradapter1.personer.OutPersenerComp;
import us.mifeng.outeradapter1.view.IOuterView;

public class OutAdapterActivityB extends AppCompatActivity implements IOuterView,AdapterView.OnItemClickListener{

    private MyAdapter adapter;
    private IOutPersener persener;
    private View footView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_adapter_b);
        ListView listView = (ListView) findViewById(R.id.listView);
        persener = new OutPersenerComp(this);
        adapter = new MyAdapter(persener);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        footView = LayoutInflater.from(this).inflate(R.layout.item_footer,null);
        listView.addFooterView(footView);
        persener.showFootView(false);

        //当布局为空是显示进度条
        listView.setDivider(null);
        View emptyView = LayoutInflater.from(this).inflate(R.layout.item_empty_view,null);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.layout_home);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        viewGroup.addView(emptyView,params);
        listView.setEmptyView(emptyView);

        //加载数据
        persener.loadData();
    }

    @Override
    public void loadData(List<String> datas) {
        adapter.setDatas(datas);
    }

    @Override
    public void loadMoredata(String item) {
        adapter.addItem(item);
        persener.showFootView(false);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showFootView(boolean isShow) {
        if (isShow){
            footView.setVisibility(View.VISIBLE);
        }else{
            footView.setVisibility(View.GONE);
        }
    }

    @Override
    public void toast(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        persener.toast(adapter.getItem(position));
    }
}
