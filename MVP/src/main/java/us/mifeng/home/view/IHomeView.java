package us.mifeng.home.view;

import android.app.Activity;

import java.util.List;

/**
 * Created by 黑夜之火 on 2017/7/6.
 */

public interface IHomeView {
    void loadData(List<String>datas);
    Activity getActivity();
}
