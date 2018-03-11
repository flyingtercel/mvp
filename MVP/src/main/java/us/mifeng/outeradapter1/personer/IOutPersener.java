package us.mifeng.outeradapter1.personer;

import android.app.Activity;

/**
 * Created by 黑夜之火 on 2017/7/5.
 */

public interface IOutPersener {
    void loadData();
    void loadMoreData(String item);
    void showFootView(boolean isShow);
    Activity getActivity();
    void toast(String str);
}
