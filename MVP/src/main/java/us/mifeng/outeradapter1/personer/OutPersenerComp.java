package us.mifeng.outeradapter1.personer;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import us.mifeng.outeradapter1.view.IOuterView;

/**
 * Created by 黑夜之火 on 2017/7/5.
 */

public class OutPersenerComp implements IOutPersener{
    private IOuterView iOuterView;
    private List<String>list;
    public OutPersenerComp(IOuterView iOuterView){
        this.iOuterView = iOuterView;
        list = new ArrayList<>();
    }
    @Override
    public void loadData() {
        String[]strs = {"一马当先","一览众山小","天清一色","花开六月","小桥流水人家"};
        Collections.addAll(list,strs);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iOuterView.loadData(list);
            }
        },2000);
    }
    @Override
    public void loadMoreData(final String item) {
        iOuterView.showFootView(true);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iOuterView.loadMoredata(item);
            }
        },2000);
    }

    @Override
    public void showFootView(boolean isShow) {
        iOuterView.showFootView(isShow);
    }

    @Override
    public Activity getActivity() {
        return iOuterView.getActivity();
    }

    @Override
    public void toast(String str) {
        iOuterView.toast(str);
    }
}
