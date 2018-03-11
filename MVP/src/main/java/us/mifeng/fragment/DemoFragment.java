package us.mifeng.fragment;


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

import us.mifeng.fragment.adapter.MyAdapter;
import us.mifeng.fragment.event.FragmentGetDatasEvent;
import us.mifeng.fragment.presenter.FragmentPresenterCompl;
import us.mifeng.fragment.presenter.IFragmentPresenter;
import us.mifeng.fragment.view.IFragmentView;
import us.mifeng.login.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends Fragment implements IFragmentView{
    private static final String BUNDLE_INDEX = "BUNDLE_INDEX";
    private int index;
    private IFragmentPresenter iFragmentPresenter;
    private MyAdapter adapter;

    public static DemoFragment newInstance(int index){
        DemoFragment fragment = new DemoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_INDEX,index);
        fragment.setArguments(bundle);
        return fragment;
    }
    public DemoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            index = getArguments().getInt(BUNDLE_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        //注册Register
        EventBus.getDefault().register(this);
        //查找View
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_home);
        //init
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        iFragmentPresenter = new FragmentPresenterCompl(this);
        adapter = new MyAdapter(iFragmentPresenter);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getActivity(),"Tab "+index+" : "+(String)adapter.getItems(position),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void onEvent(FragmentGetDatasEvent getDatasEvent){
        if (getDatasEvent!=null && getDatasEvent.getDatas()!=null&&getDatasEvent.getDatas().size()>0){
            adapter.setDatas(getDatasEvent.getDatas());
        }
    }
}
