package us.mifeng.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import us.mifeng.fragment.presenter.ActivityPresenterCompl;
import us.mifeng.fragment.presenter.IActivityPresenter;
import us.mifeng.login.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) this.findViewById(R.id.tablayout_fragments);
        ViewPager viewPager = (ViewPager) this.findViewById(R.id.viewpager_fragments);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        /*ViewPager在滑动的时候，设置预加载的数量
        * 当为1的时候，加载第三个时，第一个销毁，加载第一个时，第三个销毁，加载第二个时，两边都不会销毁
        * 当为3的时候，左边可以加载三个，右边可以加载3个，超出范围的被销毁*/
        viewPager.setOffscreenPageLimit(3);
        /*tablayout与Viewpager同步关联*/
        tabLayout.setupWithViewPager(viewPager);

        IActivityPresenter iActivityPresenter = new ActivityPresenterCompl(this);
        iActivityPresenter.loadDatas();
    }
    public class MyAdapter extends FragmentStatePagerAdapter
    {

        public String[]pagers = new String[]{"FragmentA","FragmentB","FragmentC"};
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return DemoFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return pagers.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pagers[position];
        }
    }
}
