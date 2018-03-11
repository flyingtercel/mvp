package us.mifeng.login.person;

import android.os.Handler;
import android.os.Looper;

import us.mifeng.login.model.UserMode;
import us.mifeng.login.view.ILoginView;

/**
 * Created by 黑夜之火 on 2017/6/26.
 */

public class Personer implements IUserPerson {
    private ILoginView loginView;
    private Handler handler;
    private UserMode userMode;
    public Personer(ILoginView loginView){
        this.loginView = loginView;
        initView();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        loginView.clear();
    }

    @Override
    public void doLogin(String name, String pass) {
        boolean isLoginSuccess = false;
        final int code = userMode.isCheckLogin(name,pass);
        if (code==0){
            isLoginSuccess = true;
        }
        final boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.onLoginResult(result,code);
            }
        },2000);

    }

    @Override
    public void progressVisible(int visible) {
        loginView.setProgressVisible(visible);
    }
    private void initView() {
        userMode = new UserMode("mvp","mvp");
    }
}
