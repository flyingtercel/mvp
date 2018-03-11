package us.mifeng.fragment2.persion;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;

import us.mifeng.login.R;

/**
 * Created by 黑夜之火 on 2017/6/30.
 */

public class DataPersionComp implements IDataPersion {
    private Context context;
    private ArrayList<String>list;
    private final Handler handler;

    public DataPersionComp(Context context){
        this.context = context;
        list = new ArrayList<>();
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void loadData() {
        String[]ss = context.getResources().getStringArray(R.array.countries);
        Collections.addAll(list,ss);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                DataComp dc = new DataComp(list);
                EventBus.getDefault().post(dc);
            }
        },1000);
    }
}
