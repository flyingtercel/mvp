package us.mifeng.fragment.event;

import java.util.List;

/**
 * Created by 黑夜之火 on 2017/6/27.
 */

public class FragmentGetDatasEvent {
    List<String>datas;
    public FragmentGetDatasEvent(List<String>datas){
        this.datas = datas;
    }
    public List<String>getDatas(){
        return datas;
    }
}
