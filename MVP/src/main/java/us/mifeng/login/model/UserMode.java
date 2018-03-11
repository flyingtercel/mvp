package us.mifeng.login.model;

/**
 * Created by 黑夜之火 on 2017/6/26.
 */

public class UserMode implements IUser{

    private String name;
    private String pass;
    public UserMode(String name,String pass){
        this.name = name;
        this.pass = pass;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public int isCheckLogin(String name, String pass) {
        if (name!=null && pass!=null &&name.equals(getName())&&pass.equals(getPass())){
            return 0;
        }
        return -1;
    }
}
