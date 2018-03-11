package us.mifeng.eventbus.modle;

import java.util.List;

/**
 * Created by 黑夜之火 on 2017/7/3.
 */

public class EventGetData {
    private List<String>list;
    public EventGetData(List<String>list){
        this.list = list;
    }
    public List<String> getEventData(){
        return list;
    }
}
