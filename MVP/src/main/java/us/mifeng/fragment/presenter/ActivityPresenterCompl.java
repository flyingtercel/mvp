package us.mifeng.fragment.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import us.mifeng.fragment.event.FragmentGetDatasEvent;
import us.mifeng.login.R;

/**
 * Created by 黑夜之火 on 2017/6/27.
 */

public class ActivityPresenterCompl implements IActivityPresenter {

    private Context context;
    public ActivityPresenterCompl(Context context){
        this.context = context;
    }
    @Override
    public void loadDatas() {
        String[]countries= context.getResources().getStringArray(R.array.countries);
        final List<String>datas = new ArrayList<>();
        Collections.addAll(datas,countries);
        Log.i("tag","=============>"+datas.toString());

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentGetDatasEvent getDatasEvent = new FragmentGetDatasEvent(datas);
                EventBus.getDefault().post(getDatasEvent);
            }
        },1000);
    }

}
