package us.mifeng.outeradapter1.view;

import android.app.Activity;

import java.util.List;

/**
 * Created by 黑夜之火 on 2017/7/5.
 */

public interface IOuterView {
    void loadData(List<String>datas);
    void loadMoredata(String item);
    Activity getActivity();
    void showFootView(boolean isShow);
    void toast(String str);
}
