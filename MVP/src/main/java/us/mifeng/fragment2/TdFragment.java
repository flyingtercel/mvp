package us.mifeng.fragment2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import us.mifeng.fragment2.event.IFragmentViewParstner;
import us.mifeng.fragment2.persion.DataComp;
import us.mifeng.fragment2.view.IFragmentViewListener;
import us.mifeng.login.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TdFragment extends Fragment implements IFragmentViewListener{

    private static String BUNDLER_INDEX = "index";
    private static int index;
    private RecycleAdapter adapter;
    private RecyclerView recyclerView;
    private View view;

    //返回Fragment的对象
    public static TdFragment newInstance(int index){
        TdFragment tf   = new TdFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLER_INDEX,index);
        tf.setArguments(bundle);
        return tf;
    }
    public TdFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        index = getArguments().getInt(BUNDLER_INDEX);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getArguments().getInt(BUNDLER_INDEX);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_td, container, false);
        EventBus.getDefault().register(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecycleAdapter(new IFragmentViewParstner(this));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getActivity(),"Fragment"+adapter.getItems(position),Toast.LENGTH_SHORT).show();
    }
    @Subscribe
    public void onEventData(DataComp comp){
        if (comp!=null &&comp.getListData()!=null&&comp.getListData().size()>0){
            adapter.setListData(comp.getListData());
        }
    }
}
