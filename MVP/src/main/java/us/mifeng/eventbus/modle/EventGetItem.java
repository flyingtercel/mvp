package us.mifeng.eventbus.modle;

/**
 * Created by 黑夜之火 on 2017/7/3.
 */

public class EventGetItem {
    private String ss;
    public EventGetItem(String ss){
        this.ss = ss;
    }
    public String getItemData(){
        return ss;
    }
}
