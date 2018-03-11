package us.mifeng.fragment.presenter;

import us.mifeng.fragment.view.IFragmentView;

/**
 * Created by 黑夜之火 on 2017/6/27.
 */

public class FragmentPresenterCompl implements IFragmentPresenter {
    private IFragmentView iFragmentView;
    public FragmentPresenterCompl(IFragmentView iFragmentView){
        this.iFragmentView = iFragmentView;
    }
    @Override
    public void onItemClick(int position) {
        iFragmentView.onItemClick(position);
    }
}
