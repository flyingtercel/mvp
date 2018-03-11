package us.mifeng.login.view;

/**
 * Created by 黑夜之火 on 2017/6/26.
 */

public interface ILoginView {
    void clear();
    void setProgressVisible(int visible);
    void onLoginResult(boolean result,int code);

}
