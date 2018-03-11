package us.mifeng.home.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 黑夜之火 on 2017/7/6.
 */

public class ActivityHolder {
    private List<String>activitys;
    private HashMap<String ,Class<?extends Activity>>map;

    public ActivityHolder(){
        activitys = new ArrayList<>();
        map = new HashMap<>();
    }
    public void addActivity(String activityName,Class<?extends Activity>activityClass){
        activitys.add(activityName);
        map.put(activityName,activityClass);
    }
    public List<String>getActivitys(){
        return activitys;
    }
    public Class<?extends Activity>getActivityClass(String activityName){
        return map.get(activityName);
    }

}
