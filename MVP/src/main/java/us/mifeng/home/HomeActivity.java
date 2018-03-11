package us.mifeng.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import us.mifeng.home.personer.PersenerComp;
import us.mifeng.home.view.IHomeView;
import us.mifeng.login.R;

public class HomeActivity extends AppCompatActivity implements IHomeView,AdapterView.OnItemClickListener{
    private List<String>list = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private PersenerComp comp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,
                R.layout.list_item_activity,R.id.activity_name,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        //设置空的视图
        View emptyView = LayoutInflater.from(this).inflate(R.layout.item_empty_view,null);
        ViewGroup layout = (ViewGroup) findViewById(R.id.list_home);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        layout.addView(emptyView,layoutParams);
        listView.setEmptyView(emptyView);

        comp = new PersenerComp(this);
        comp.loadData();
    }

    @Override
    public void loadData(List<String> datas) {
        if (datas!=null && datas.size()>0){
            list.clear();
            list.addAll(datas);
            adapter.notifyDataSetChanged();
        }
    }
    @Override
    public Activity getActivity() {
        return this;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        comp.onItemClick(position);
    }
}
