package us.mifeng.home.personer;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;

import us.mifeng.eventbus.EventBusActivity;
import us.mifeng.fragment.FragmentActivity;
import us.mifeng.fragment2.FragmentTwoActivity;
import us.mifeng.home.utils.ActivityHolder;
import us.mifeng.home.view.IHomeView;
import us.mifeng.login.MainActivity;
import us.mifeng.outeradapter.AdapterActivityA;
import us.mifeng.outeradapter1.OutAdapterActivityB;

/**
 * Created by 黑夜之火 on 2017/7/6.
 */

public class PersenerComp implements IPersener{
    private List<String>datas;
    private IHomeView iHomeView;
    private final ActivityHolder holder;

    public PersenerComp(IHomeView iHomeView){
        this.iHomeView = iHomeView;
        this.datas = new ArrayList<>();
        holder = new ActivityHolder();
    }
    @Override
    public void loadData() {
        holder.addActivity("login.MainActivity", MainActivity.class);
        holder.addActivity("fragment.FragmentActivity", FragmentActivity.class);
        holder.addActivity("FragmentTwoActivity", FragmentTwoActivity.class);
        holder.addActivity("eventbus.EventBusActivity", EventBusActivity.class);
        holder.addActivity("outeradapter.AdapterActivityA", AdapterActivityA.class);
        holder.addActivity("outeradapter1.OutAdapterActivityB", OutAdapterActivityB.class);
        Handler handler = new Handler(Looper.getMainLooper());
        datas.addAll(holder.getActivitys());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iHomeView.loadData(datas);
            }
        },2000);
    }

    @Override
    public void onItemClick(int postion) {
        Intent intent = new Intent(iHomeView.getActivity(),holder.getActivityClass(datas.get(postion)));
        iHomeView.getActivity().startActivity(intent);
    }
}
