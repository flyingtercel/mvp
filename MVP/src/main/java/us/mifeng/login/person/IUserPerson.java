package us.mifeng.login.person;

/**
 * Created by 黑夜之火 on 2017/6/26.
 */

public interface IUserPerson {
    void clear();
    void doLogin(String name,String pass);
    void progressVisible(int visible);
}
