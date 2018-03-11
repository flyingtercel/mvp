package us.mifeng.fragment2.event;

import us.mifeng.fragment2.view.IFragmentViewListener;

/**
 * Created by 黑夜之火 on 2017/6/30.
 */

public class IFragmentViewParstner implements IFragmentPersoner{
    private IFragmentViewListener viewListener;
    public IFragmentViewParstner(IFragmentViewListener viewListener){
        this.viewListener = viewListener;
    }

    @Override
    public void onItemClick(int postion) {
        viewListener.onItemClick(postion);
    }
}
