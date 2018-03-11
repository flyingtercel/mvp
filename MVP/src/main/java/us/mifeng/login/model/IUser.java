package us.mifeng.login.model;

/**
 * Created by 黑夜之火 on 2017/6/26.
 */

public interface IUser {
    String getName();
    String getPass();
    int isCheckLogin(String name,String pass);
}
