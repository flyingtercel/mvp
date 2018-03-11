package us.mifeng.outeradapter;

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
import us.mifeng.outeradapter.adapter.AdapterPresenterComp;
import us.mifeng.outeradapter.adapter.CustomAdapter;
import us.mifeng.outeradapter.presenter.IAdapterPresenter;
import us.mifeng.outeradapter.view.IAdapterView;

public class AdapterActivityA extends AppCompatActivity implements IAdapterView,AdapterView.OnItemClickListener{

    private View footViewVisible;
    private IAdapterPresenter iAdapterPresenter;
    private CustomAdapter adapter;
    private View footView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_activity);
        ListView listView = (ListView) findViewById(R.id.list_home);
        listView.setOnItemClickListener(this);

        listView.setDivider(null);
        View loadEmpty = LayoutInflater.from(this).inflate(R.layout.item_empty_view,null);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.layout_home);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        viewGroup.addView(loadEmpty,layoutParams);
        listView.setEmptyView(loadEmpty);

        footView = LayoutInflater.from(this).inflate(R.layout.item_footer,null);
        listView.addFooterView(footView);
        footViewVisible = footView.findViewById(R.id.layout_visible);
        iAdapterPresenter = new AdapterPresenterComp(this);
        iAdapterPresenter.showFooterView(false);
        adapter = new CustomAdapter(iAdapterPresenter);
        listView.setAdapter(adapter);
        iAdapterPresenter.loadDatas();
    }

    @Override
    public void onGetDataList(List<String> datas) {
        adapter.setDatas(datas);

    }

    @Override
    public void onLoadMoreData(String item) {
        adapter.addItem(item);
        iAdapterPresenter.showFooterView(false);
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(this, "AdapterActivityA : "+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Activity onGetActivity() {
        return this;
    }

    @Override
    public void onShowFooterView(boolean isShow) {
        if (isShow) {
            footView.setVisibility(View.VISIBLE);
        } else {
            footView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        toast(adapter.getItem(position));
    }
}
