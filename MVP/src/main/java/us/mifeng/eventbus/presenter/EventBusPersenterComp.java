package us.mifeng.eventbus.presenter;

import android.os.Handler;
import android.os.Looper;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import us.mifeng.eventbus.modle.EventGetData;
import us.mifeng.eventbus.modle.EventGetItem;
import us.mifeng.eventbus.view.IEventBusView;
import us.mifeng.login.R;

/**
 * Created by 黑夜之火 on 2017/7/3.
 */

public class EventBusPersenterComp implements IEventBusPresenter {
    private IEventBusView eventBusView;
    private List<String>list;
    public EventBusPersenterComp(IEventBusView iEventBusView){
        this.eventBusView = iEventBusView;
        this.list = new ArrayList<>();
    }
    @Override
    public void loadData() {
        String[]strs = eventBusView.getActivity().getResources().getStringArray(R.array.countries);
        Collections.addAll(list,strs);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                EventGetData getData = new EventGetData(list);
                EventBus.getDefault().post(getData);
            }
        },3000);
    }

    @Override
    public void onItemClick(int postion) {
        EventGetItem getItem = new EventGetItem(list.get(postion));
        EventBus.getDefault().post(getItem);
    }
}
