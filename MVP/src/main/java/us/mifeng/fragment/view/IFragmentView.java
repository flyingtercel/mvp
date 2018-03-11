package us.mifeng.fragment.view;

import android.app.Activity;

/**
 * Created by 黑夜之火 on 2017/6/27.
 */

public interface IFragmentView {
    public Activity getActivity();
    public void onItemClick(int position);
}
