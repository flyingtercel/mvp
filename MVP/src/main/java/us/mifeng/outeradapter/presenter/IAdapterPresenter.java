package us.mifeng.outeradapter.presenter;

import android.app.Activity;

/**
 * Created by 黑夜之火 on 2017/7/4.
 */

public interface IAdapterPresenter {
    void loadDatas();
    void loadMoreData(String item);
    Activity getActivity();
    void showFooterView(boolean isShow);
}
