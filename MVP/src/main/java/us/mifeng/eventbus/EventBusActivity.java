package us.mifeng.eventbus;

import android.app.ActionBar;
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
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import us.mifeng.eventbus.modle.EventGetData;
import us.mifeng.eventbus.modle.EventGetItem;
import us.mifeng.eventbus.presenter.EventBusPersenterComp;
import us.mifeng.eventbus.view.IEventBusView;
import us.mifeng.login.R;

public class EventBusActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,IEventBusView{
    private List<String> data = new ArrayList<>();
    private EventBusPersenterComp eventBusPersenterComp;
    private ArrayAdapter<String> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        //注册EventBus
        EventBus.getDefault().register(this);
        //查找控件
        listView = (ListView) findViewById(R.id.list_home);
        //设置监听事件
        listView.setOnItemClickListener(this);

        View loadingView = LayoutInflater.from(this).inflate(R.layout.item_empty_view,null);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.layout_home);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        viewGroup.addView(loadingView,layoutParams);
        listView.setEmptyView(loadingView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

        eventBusPersenterComp = new EventBusPersenterComp(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        eventBusPersenterComp.loadData();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        eventBusPersenterComp.onItemClick(position);
    }

    @Override
    public Activity getActivity() {
        return this;
    }
    @Subscribe
    public void onEventData(EventGetData eventGetData){
        if (eventGetData!=null&&eventGetData.getEventData()!=null&&eventGetData.getEventData().size()>0){
            this.data.clear();
            this.data.addAll(eventGetData.getEventData());
            this.adapter.notifyDataSetChanged();
        }
    }
    @Subscribe
    public void OnEventItemList(EventGetItem eventGetItem){
        if (eventGetItem!=null&&eventGetItem.getItemData()!=null){
            Toast.makeText(this,eventGetItem.getItemData(),Toast.LENGTH_SHORT).show();
        }
    }

}
