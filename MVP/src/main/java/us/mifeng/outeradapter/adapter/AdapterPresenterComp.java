package us.mifeng.outeradapter.adapter;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import us.mifeng.outeradapter.presenter.IAdapterPresenter;
import us.mifeng.outeradapter.view.IAdapterView;

/**
 * Created by 黑夜之火 on 2017/7/4.
 */

public class AdapterPresenterComp implements IAdapterPresenter {
    List<String>datas;
    IAdapterView iAdapterView;
    public AdapterPresenterComp(IAdapterView iAdapterView){
        this.iAdapterView = iAdapterView;
        this.datas = new ArrayList<>();
    }
    @Override
    public void loadDatas() {
        String[]countries = new String[]{"Kaede Akatsuki","Loves","Neko Tattsun","Deeply"};
        Collections.addAll(datas,countries);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iAdapterView.onGetDataList(datas);
            }
        },3000);
    }

    @Override
    public void loadMoreData(final String item) {
        showFooterView(true);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iAdapterView.onLoadMoreData(item);
            }
        },2000);
    }

    @Override
    public Activity getActivity() {
        return iAdapterView.onGetActivity();
    }

    @Override
    public void showFooterView(boolean isShow) {
        iAdapterView.onShowFooterView(isShow);
    }
}
