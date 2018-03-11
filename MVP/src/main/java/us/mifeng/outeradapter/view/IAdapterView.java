package us.mifeng.outeradapter.view;

import android.app.Activity;

import java.util.List;

/**
 * Created by 黑夜之火 on 2017/7/4.
 */

public interface IAdapterView {
    void onGetDataList(List<String>datas);
    void onLoadMoreData(String item);
    void toast(String msg);
    Activity onGetActivity();
    void onShowFooterView(boolean isShow);
}
